package org.example.controller;

import org.example.constant.Constant;
import org.example.entity.User;
import org.example.mapper.UserMapper;
import org.example.util.R;
import org.example.util.Util;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;
import java.util.logging.Logger;


/**
 * @author x
 * @description 登录控制层
 * @Date: 2020/9/2 20:15
 */
@RestController
public class LoginController {

  final Logger L = Logger.getLogger("登录");

  @Resource
  private UserMapper userMapper;

  @RequestMapping(value = "login", method = RequestMethod.POST)
  @ResponseBody
  public R login(User loginUser) {
    L.info("用户登录:" + loginUser);

    //验证密码
    User user = userMapper.getPasswordByUserName(loginUser.getUsername());
    if (user == null || !user.getPassword().equals(Util.shaEncrypt(loginUser.getPassword()))) {
      return R.error().message("登录");
    }

    //更新最后登录时间
    userMapper.update(new User(loginUser.getUsername(), new Date()));

    //缓存token
    String token = UUID.randomUUID().toString();
    Constant.TOKEN.put(token, user.getUsername());

    //密码清除
    user.setPassword("");
    return R.ok().data("token", token).data("user", user).message("登录");
  }

  @RequestMapping(value = "exit", method = RequestMethod.GET)
  @ResponseBody
  public R exit(@RequestParam("token") String token) {
    L.info("用户退出:" + token);
    //删除缓存中的token
    Constant.TOKEN.remove(token);
    return R.ok().message("退出");
  }
}

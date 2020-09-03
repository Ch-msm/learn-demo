package org.example.controller;

import org.example.entity.User;
import org.example.mapper.UserMapper;
import org.example.util.R;
import org.example.util.Util;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;


/**
 * @author x
 * @description 用户控制层
 * @Date: 2020/9/4 20:47
 */
@RestController
@RequestMapping("user")
public class UserController {

  final Logger L = Logger.getLogger("用户");

  @Resource
  private UserMapper userMapper;


  @RequestMapping(value = "add", method = RequestMethod.POST)
  @ResponseBody
  public R add(User user) {
    String explain = "添加用户";
    L.info(explain + ":" + user);

    //密码加密
    if (user.getPassword() != null) {
      user.setPassword(Util.shaEncrypt(user.getPassword()));
    }

    //创建时间
    user.setCreateTime(new Date());
    try {
      int r = userMapper.createUser(user);
      return r == 1 ? R.ok().message(explain) : R.error().message(explain);
    } catch (Exception e) {
      return R.error().message("用户名被占用");
    }
  }

  @RequestMapping(value = "find", method = RequestMethod.GET)
  @ResponseBody
  public R find(@RequestParam("keyword") String keyword) {
    String explain = "用户列表";
    L.info(explain + ":" + keyword);
    List<User> list = userMapper.findUser(keyword);
    return R.ok().data("list", list).data("total", list.size()).message(explain);
  }

  @RequestMapping(value = "delete", method = RequestMethod.DELETE)
  @ResponseBody
  public R delete(@RequestParam("id") int id) {
    String explain = "删除用户";
    L.info(explain + ":" + id);
    int r = userMapper.delete(id);
    return r == 1 ? R.ok().message(explain) : R.error().message(explain);
  }

  @RequestMapping(value = "update", method = RequestMethod.PUT)
  @ResponseBody
  public R update(User user) {
    String explain = "更新用户";
    L.info(explain + ":" + user);
    try {
      int r = userMapper.update(user);
      return r == 1 ? R.ok().message(explain) : R.error().message(explain);
    } catch (Exception e) {
      return R.error().message("用户名被占用");
    }
  }


}

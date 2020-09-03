package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.entity.User;
import org.example.provider.UserProvider;

import java.util.List;

/**
 * @author x
 * @description 用户mapper
 * @Date: 2020/9/3 19:40
 */

@Mapper
public interface UserMapper {

  /**
   * 创建用户
   *
   * @param user 用户实体
   * @return 结果值
   */
  @Insert("insert into User(name,gender,username,province,city,createTime,password) values(#{name},#{gender},#{username},#{province},#{city},#{createTime},#{password})")
  int createUser(User user);

  /**
   * 查找用户
   *
   * @param keyword 关键字
   * @return 用户集合
   */
  @SelectProvider(type = UserProvider.class, method = "find")
  List<User> findUser(String keyword);

  /**
   * 删除用户
   *
   * @param id 用户id
   * @return 删除结果
   */
  @Delete("delete from User where id = #{id}")
  int delete(int id);

  /**
   * 根据用户名获取密码
   *
   * @param username 用户名
   * @return 密码
   */
  @Select("select * from User where username = #{username}")
  User getPasswordByUserName(String username);

  /**
   * 更新用户
   *
   * @param user 用户
   * @return 更新结果
   */
  @UpdateProvider(type = UserProvider.class, method = "update")
  int update(User user);

}

package org.example.provider;

import org.apache.ibatis.jdbc.SQL;
import org.example.entity.User;

/**
 * @author x
 * @description 用户sql
 * @Date: 2020/9/3 19:41
 */
public class UserProvider {
  public String update(User user) {
    return new SQL() {
      {
        UPDATE("User");
        if (user.getName() != null) {
          SET("name = #{name}");
        }
        if (user.getGender() != null) {
          SET("gender = #{gender}");
        }
        if (user.getUsername() != null) {
          SET("username = #{username}");
        }
        if (user.getCity() != null) {
          SET("city = #{city}");
        }
        if (user.getProvince() != null) {
          SET("province = #{province}");
        }
        if (user.getLoginTime() != null) {
          SET("loginTime = #{loginTime}");
        }
        if (user.getId() != null) {
          WHERE("ID = #{id}");
        } else {
          WHERE("username = #{username}");
        }
      }
    }.toString();
  }

  public String find(String keyword) {
    return new SQL() {
      {
        SELECT("*");
        FROM("User");
        if (keyword != null && !keyword.isEmpty()) {
          WHERE("name like '%" + keyword + "%'");
        }
      }
    }.toString();
  }
}

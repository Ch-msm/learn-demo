package org.example.entity;

import java.util.Date;

/**
 * @author x
 * @description 用户实体类
 * @Date: 2020/9/3 18:40
 */
public class User {

  /**
   * 自增id
   */
  private Long id;
  /**
   * 姓名
   */
  private String name;

  /**
   * 密码
   */
  private String password;
  /**
   * 性别：0 未知，1 男，2 女
   */
  private Integer gender;
  /**
   * 用户名
   */
  private String username;
  /**
   * 省
   */
  private String province;
  /**
   * 市
   */
  private String city;
  /**
   * 创建时间
   */
  private Date createTime;
  /**
   * 最后一次登录时间
   */
  private Date loginTime;

  public User() {

  }

  public User(String username, Date loginTime) {
    this.username = username;
    this.loginTime = loginTime;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getGender() {
    return gender;
  }

  public void setGender(Integer gender) {
    this.gender = gender;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getLoginTime() {
    return loginTime;
  }

  public void setLoginTime(Date loginTime) {
    this.loginTime = loginTime;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", password='" + password + '\'' +
        ", gender=" + gender +
        ", username='" + username + '\'' +
        ", province='" + province + '\'' +
        ", city='" + city + '\'' +
        ", createTime=" + createTime +
        ", loginTime=" + loginTime +
        '}';
  }
}

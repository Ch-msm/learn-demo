package org.example.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * @author x
 * @description 统一结果类
 * @Date: 2020/9/3 20:40
 */
public class R {
  private Boolean success;

  private Integer code;

  private String message;

  private Map<String, Object> data = new HashMap<>();

  private Date time;

  /**
   * 构造器私有
   */
  private R() {
    time = new Date();
  }

  /**
   * 通用返回成功
   */
  public static R ok() {
    R r = new R();
    r.setSuccess(ResultCodeEnum.SUCCESS.getSuccess());
    r.setCode(ResultCodeEnum.SUCCESS.getCode());
    r.setMessage(ResultCodeEnum.SUCCESS.getMessage());
    return r;
  }

  /**
   * 通用返回失败，未知错误
   */
  public static R error() {
    R r = new R();
    r.setSuccess(ResultCodeEnum.UNKNOWN_ERROR.getSuccess());
    r.setCode(ResultCodeEnum.UNKNOWN_ERROR.getCode());
    r.setMessage(ResultCodeEnum.UNKNOWN_ERROR.getMessage());
    return r;
  }

  /**
   * 设置结果，形参为结果枚举
   */
  public static R setResult(ResultCodeEnum result) {
    R r = new R();
    r.setSuccess(result.getSuccess());
    r.setCode(result.getCode());
    r.setMessage(result.getMessage());
    return r;
  }

  /**
   * 自定义返回数据
   */
  public R data(Map<String, Object> map) {
    this.setData(map);
    return this;
  }

  /**
   * 通用设置data
   */
  public R data(String key, Object value) {
    this.data.put(key, value);
    return this;
  }

  /**
   * 自定义状态信息
   */
  public R message(String message) {
    this.setMessage(message);
    return this;
  }

  /**
   * 自定义状态码
   */
  public R code(Integer code) {
    this.setCode(code);
    return this;
  }

  /**
   * 自定义返回结果
   */
  public R success(Boolean success) {
    this.setSuccess(success);
    return this;
  }

  public Boolean getSuccess() {
    return success;
  }

  public void setSuccess(Boolean success) {
    this.success = success;
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Map<String, Object> getData() {
    return data;
  }

  public void setData(Map<String, Object> data) {
    this.data = data;
  }

  public Date getTime() {
    return time;
  }

  public void setTime(Date time) {
    this.time = time;
  }
}

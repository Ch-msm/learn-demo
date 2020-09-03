package org.example.util;

/**
 * @author x
 * @description 结果枚举
 * @Date: 2020/9/3 20:41
 */
public enum ResultCodeEnum {
  /**
   *
   */
  SUCCESS(true, 200, "成功"),
  UNKNOWN_ERROR(false, 201, "未知错误"),
  PARAM_ERROR(false, 202, "参数错误");

  /**
   * 响应是否成功
   */
  private final Boolean success;
  /**
   * 响应状态码
   */
  private final Integer code;
  /**
   * 响应信息
   */
  private final String message;

  ResultCodeEnum(boolean success, Integer code, String message) {
    this.success = success;
    this.code = code;
    this.message = message;
  }

  public Boolean getSuccess() {
    return success;
  }

  public Integer getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }
}

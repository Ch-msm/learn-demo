package org.example.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author x
 * @description 工具类
 * @Date: 2020/9/3 20:59
 */
public class Util {

  /**
   * 密码加密
   *
   * @param password 明文
   * @return 密文
   */
  public static String shaEncrypt(String password) {
    MessageDigest sha;
    try {
      sha = MessageDigest.getInstance("SHA");
      sha.update(password.getBytes());
      return new BigInteger(sha.digest()).toString(32);
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    return "";
  }
}

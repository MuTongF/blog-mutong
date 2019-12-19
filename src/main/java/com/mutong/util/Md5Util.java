package com.mutong.util;

import java.util.UUID;
import org.apache.shiro.crypto.hash.SimpleHash;

public class Md5Util {

  //加密公式
  private static String PASS_AUTH = UUID.randomUUID().toString().replaceAll("-", "")
      .substring(0, 5);
  // 加密方式
  private static String HASH_ALGORITHM_NAME = "MD5";
  // 加密的次数
  private static int HASH_ITERATIONS = 2;

  //设置用户加密的严值
  public static String setSlat() {
    return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 5);
  }

  /**
   * 加密密码
   *
   * @param psw 密码
   * @param salt 严值
   */
  public static String encryPassWord(String psw, String salt) {
    // 加密的次数
    int hashIterations = 2;
    // 密码
    Object credentials = psw;
    String simpleHash = new SimpleHash(HASH_ALGORITHM_NAME, credentials, salt, hashIterations)
        .toHex();
    System.out.println("加密后的值----->" + simpleHash);
    return simpleHash;
  }


  public static void main(String[] args) {
    System.out.println(encryPassWord("123456", "c840e"));
  }


}

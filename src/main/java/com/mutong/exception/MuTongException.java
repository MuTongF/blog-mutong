package com.mutong.exception;

public class MuTongException extends RuntimeException {

  private Integer code;
  private String msg;


  @Override
  public String toString() {
    return "访问异常{" +
        "code=" + code +
        ", msg='" + msg + '\'' +
        '}';
  }

  public MuTongException(String msg) {
    this.msg = msg;
  }

  public MuTongException(Integer code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }
}

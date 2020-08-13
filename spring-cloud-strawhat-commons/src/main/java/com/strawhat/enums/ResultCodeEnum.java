package com.strawhat.enums;

/**
 * 应答码枚举
 * 00000  成功
 * 10000~199999 1类异常
 * 20000~29999 2类异常
 *
 */
public enum ResultCodeEnum {
    SUCCESS("00000","请求成功"),
    ERROR99991("99991","方法参数校验异常"),
    ERROR("99999","系统未知异常");
    private String code;
    private String msg;

    ResultCodeEnum() {
    }

    ResultCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public String getCode(){
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg(){
        return this.msg;
    }
}

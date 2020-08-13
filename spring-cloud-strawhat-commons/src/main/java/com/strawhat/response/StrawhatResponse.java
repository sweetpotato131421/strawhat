package com.strawhat.response;


import java.io.Serializable;

/**
 * 公共应答父类
 *
 * @author lize
 * @date 2020/8/13
 */

public class StrawhatResponse  implements Serializable {
    private static final long serialVersionUID = 1580560199562234562L;
    /**
     * 应答码
     */
    private String resultCode;
    /**
     * 应答信息
     */
    private String resultMsg;
    /**
     * 自定义报文体
     */
    private Object resultContent;


    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public Object getResultContent() {
        return resultContent;
    }

    public void setResultContent(Object resultContent) {
        this.resultContent = resultContent;
    }
}

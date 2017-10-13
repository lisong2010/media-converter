package com.qianmi.converter.exception;

/**
 * @author lisong(OF2016)
 * @date 2017-10-11
 */
public enum ErrorCode {
    ENCODER_ERR("00001", "编码失败");

    private String code;

    private String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

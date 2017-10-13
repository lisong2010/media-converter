package com.qianmi.converter.exception;

import lombok.Getter;

import java.util.Arrays;

/**
 * @author lisong(OF2016)
 * @date 2017-10-11
 */
@Getter
public class ConverterRunTimeException extends RuntimeException{

    private String code = null;
    private String errMessage = "";
    private Object[] params = null;

    public ConverterRunTimeException(ErrorCode errorCode, Object... args) {
        super(String.format(errorCode.getMessage(), args));
        this.code = errorCode.getCode();
        this.errMessage = String.format(errorCode.getMessage(), args);
        this.params = args;
    }

    @Override
    public String getMessage() {
        return this.code + "-" + this.errMessage + ", 参数: " + Arrays.toString(params);
    }
}

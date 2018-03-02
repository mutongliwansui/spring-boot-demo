package com.example.exception;

public class BusinessException extends RuntimeException{
    private Object data;

    public BusinessException(Object data) {
        this.data = data;
    }

    public BusinessException(String message, Object data) {
        super(message);
        this.data = data;
    }

    public BusinessException(String message, Throwable cause, Object data) {
        super(message, cause);
        this.data = data;
    }

    public BusinessException(Throwable cause, Object data) {
        super(cause);
        this.data = data;
    }

    public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, Object data) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

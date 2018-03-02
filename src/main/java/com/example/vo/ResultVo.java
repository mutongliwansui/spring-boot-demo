package com.example.vo;

import java.io.Serializable;
public class ResultVo implements Serializable{

    public static final int RESULT_CODE_SUCCESS = 200; //成功
    public static final int RESULT_CODE_VALIDFAIL = 401; //参数校验失败
    public static final int RESULT_CODE_FAIL = 402; //业务失败
    public static final int RESULT_CODE_ERROR = 500; //系统异常
    private int code; //响应码
    private String message; //结果信息
    private Object data; //数据

    public static ResultVo newInstance(int code, String message, Object data){
        return new ResultVo(code,message,data);
    }

    /**
     * 返回成功响应结果实例
     * @param message 结果信息
     * @param data 数据
     * @return
     */
    public static ResultVo newSucInstance(String message, Object data){
        return new ResultVo(RESULT_CODE_SUCCESS,message,data);
    }
    /**
     * 返回业务失败响应结果实例
     * @param message 结果信息
     * @param data 数据
     * @return
     */
    public static ResultVo newFailInstance(String message, Object data){
        return new ResultVo(RESULT_CODE_FAIL,message,data);
    }
    /**
     * 返回校验失败响应结果实例
     * @param message 结果信息
     * @param data 数据
     * @return
     */
    public static ResultVo newValidFailInstance(String message, Object data){
        return new ResultVo(RESULT_CODE_VALIDFAIL,message,data);
    }
    /**
     * 返回系统异常响应结果实例
     * @param message 结果信息
     * @return
     */
    public static ResultVo newErrorInstance(String message){
        return new ResultVo(RESULT_CODE_ERROR,message,null);
    }

    /**
     * 私有无参构造函数
     */
    private ResultVo(){

    }
    /**
     * 私有全参构造函数
     */
    private ResultVo(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

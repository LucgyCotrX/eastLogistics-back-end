package com.east.logistics.util;

public class Result {

 /* 根据Constants 常量 进行返回编码
    public static final int SUCCESS_CODE = 200;
    public static final String SUCCESS_MSG = "请求成功";
    public static final int EXCEPTION_CODE = 404;
    public static final String EXCEPTION_MSG = "请求处理异常";
    public static final int ERROR_CODE = 500;
    public static final String ERROR_MSG = "请求方式有误,请检查 GET/POST";
    public static final int NOT_URL_CODE = 501;
    public static final String NOT_URL_MSG = "请求路径不存在";
    public static final int INSUFFICIENT_AUTHORITY_CODE = 502;
    public static final String INSUFFICIENT_AUTHORITY_MSG = "权限不足";
    public static final int LOGON_EXPIRATION_CODE = 20011;
    public static final String LOGON_EXPIRATION_MSG = "登陆已过期";*/

    //状态码
    int code;
    //数据
    Object data;
    //消息提示
    String message;
    //数量
    int count;


    public int getCount() {
        return count;
    }


    public void setCount(int count) {
        this.count = count;
    }


    public Result() {
    }

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    public Result(int code, String message, Object data, int count) {
        this.code = code;
        this.data = data;
        this.message = message;
        this.count = count;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    /**
     * code:200
     * msg:请求成功
     *
     * @return
     */
    public static Result success() {
        return new Result(200, "true");
    }


    /**
     * code:201
     * msg:请求失败
     *
     * @return
     */
    public static Result error() {
        return new Result(201, "false");
    }
    /**
     * code:201
     * msg:请求失败
     *
     * @return
     */
    public static Result error(String message) {
        return new Result(1203, message);
    }

    /**
     * successMessage
     * 正常返回，携带消息
     * code:200
     *
     * @param message 消息
     *                data:null
     *                count:0
     * @return
     */
    public static Result successMessage(String message) {
        return new Result(200, message);
    }

    /**
     * successMessage
     * 正常返回，携带消息
     * code:200
     *
     * @param message 消息
     *                data:null
     *                count:0
     * @return
     */
    public static Result successMessage(String message, Object data) {
        return new Result(200, message,data);
    }
    public static Result successMessage(int code,String message, Object data) {
        return new Result(code, message,data);
    }
    /**
     * success
     * 成功方法 带数据返回
     * code:200
     *
     * @param data  数据
     * @param count 总数
     * @return
     */
    public static Result success(Object data, int count) {
        return new Result(200, "true", data, count);
    }

    /**
     * success
     * 成功方法 带数据返回
     * code:200
     * message: success
     *
     * @param data 数据
     *             count :0
     * @return
     */
    public static Result success(Object data) {
        return new Result(200, "true", data, 0);
    }

    /**
     * error
     * data:null
     * count:0
     *
     * @param code    错误编码
     * @param message 错误信息
     * @return
     */
    public static Result error(int code, String message) {
        return new Result(code, message);
    }

}

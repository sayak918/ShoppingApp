package com.sayak.ErrorHandling;

public class CouponErrorResponse {
    private int status;
    private String msg;


    public CouponErrorResponse(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public CouponErrorResponse() {

    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

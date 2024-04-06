package com.sayak.ErrorHandling;

public class QuantityErrorResponse {
    private int status;
    private String msg;

    public QuantityErrorResponse(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public QuantityErrorResponse() {

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

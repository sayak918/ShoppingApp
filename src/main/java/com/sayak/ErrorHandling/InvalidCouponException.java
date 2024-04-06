package com.sayak.ErrorHandling;

public class InvalidCouponException extends RuntimeException{
    public InvalidCouponException(String msg){
        super(msg);
    }
}

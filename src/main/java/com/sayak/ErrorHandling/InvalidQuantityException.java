package com.sayak.ErrorHandling;

public class InvalidQuantityException extends RuntimeException{
    public InvalidQuantityException(String msg){
        super(msg);
    }
}

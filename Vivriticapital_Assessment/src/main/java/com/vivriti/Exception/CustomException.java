package com.vivriti.Exception;

public class CustomException extends RuntimeException{
    private String errorMsg;

    public CustomException(String errorMsg){
        super(errorMsg);
        this.errorMsg = errorMsg;
    }
}

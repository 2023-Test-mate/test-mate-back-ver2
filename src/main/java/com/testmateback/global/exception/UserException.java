package com.testmateback.global.exception;

import lombok.Getter;

@Getter
public class UserException extends RuntimeException{

    private UserErrorCode userErrorCode;
    private String detailMessage;

    public UserException(UserErrorCode errorCode){
        super(errorCode.getMessage());
        this.userErrorCode = errorCode;
        this.detailMessage = errorCode.getMessage();
    }

    public UserException(UserErrorCode errorCode, String detailMessage){
        super(detailMessage);
        this.userErrorCode = errorCode;
        this.detailMessage = detailMessage;
    }

}
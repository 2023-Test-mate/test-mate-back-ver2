package com.testmateback.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserErrorCode {
    NO_EMAIL("해당되는 이메일(사용자가)이 없습니다."),
    NO_PASSWORD("비밀번호가 맞지 않습니다."),
    INTERNAL_SERVER_ERROR("서버에 오류가 발생하였습니다."),
    INVALID_REQUEST("잘못된 요청입니다."),
    ;

    private final String message;
}

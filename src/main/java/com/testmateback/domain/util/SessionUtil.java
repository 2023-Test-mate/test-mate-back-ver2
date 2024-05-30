package com.testmateback.domain.util;

import jakarta.servlet.http.HttpSession;

public class SessionUtil {

    private static final String LOGIN_SESSION_KEY = "USER_ID";

    private SessionUtil() {
        // 유틸리티 클래스의 인스턴스 생성 방지
    }

    public static Long getCurrentUserIdFromSession(HttpSession session) {
        // 세션에서 사용자 ID를 가져오는 로직
        Object userIdAttribute = session.getAttribute(LOGIN_SESSION_KEY);

        if (userIdAttribute != null) {
            return (Long) userIdAttribute;
        } else {
            throw new RuntimeException("User not logged in");
        }
    }
}
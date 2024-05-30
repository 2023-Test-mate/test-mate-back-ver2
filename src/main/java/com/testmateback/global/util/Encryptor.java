package com.testmateback.global.util;

public interface Encryptor {
    public String encrypt(String origin);
    boolean isMatch(String origin, String hashed);
}

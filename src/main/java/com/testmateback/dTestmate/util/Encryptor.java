package com.testmateback.dTestmate.util;

public interface Encryptor {
    public String encrypt(String origin);
    boolean isMatch(String origin, String hashed);
}

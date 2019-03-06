package com.javatest;

import java.math.BigInteger;
import java.security.SecureRandom;

public class TestUtils {

    public static String generateRandToken(int byteLength) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] token = new byte[byteLength];
        secureRandom.nextBytes(token);
        return new BigInteger(1, token).toString(16); //hex encoding
    }

    public static String generateRandEmail() {
        return generateRandToken(2) + "@" + generateRandToken(2) + ".com";
    }
}

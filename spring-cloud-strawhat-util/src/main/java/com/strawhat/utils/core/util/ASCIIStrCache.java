package com.strawhat.utils.core.util;

/**
 * @author lize
 * @date 2020/8/13
 */
public class ASCIIStrCache {
    private static final int ASCII_LENGTH = 128;
    private static final String[] CACHE = new String[128];

    public ASCIIStrCache() {
    }

    public static String toString(char c) {
        return c < 128 ? CACHE[c] : String.valueOf(c);
    }

    static {
        for(char c = 0; c < 128; ++c) {
            CACHE[c] = String.valueOf(c);
        }

    }
}

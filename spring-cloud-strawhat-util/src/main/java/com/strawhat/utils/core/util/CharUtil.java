package com.strawhat.utils.core.util;

/**
 * @author lize
 * @date 2020/8/13
 */
public class CharUtil {
    public static final char SPACE = ' ';
    public static final char TAB = '\t';
    public static final char DOT = '.';
    public static final char SLASH = '/';
    public static final char BACKSLASH = '\\';
    public static final char CR = '\r';
    public static final char LF = '\n';
    public static final char UNDERLINE = '_';
    public static final char DASHED = '-';
    public static final char COMMA = ',';
    public static final char DELIM_START = '{';
    public static final char DELIM_END = '}';
    public static final char BRACKET_START = '[';
    public static final char BRACKET_END = ']';
    public static final char COLON = ':';
    public static final char DOUBLE_QUOTES = '"';
    public static final char SINGLE_QUOTE = '\'';
    public static final char AMP = '&';

    public CharUtil() {
    }

    public static boolean isAscii(char ch) {
        return ch < 128;
    }

    public static boolean isAsciiPrintable(char ch) {
        return ch >= ' ' && ch < 127;
    }

    public static boolean isAsciiControl(final char ch) {
        return ch < ' ' || ch == 127;
    }

    public static boolean isLetter(char ch) {
        return isLetterUpper(ch) || isLetterLower(ch);
    }

    public static boolean isLetterUpper(final char ch) {
        return ch >= 'A' && ch <= 'Z';
    }

    public static boolean isLetterLower(final char ch) {
        return ch >= 'a' && ch <= 'z';
    }

    public static boolean isNumber(char ch) {
        return ch >= '0' && ch <= '9';
    }

    public static boolean isHexChar(char c) {
        return isNumber(c) || c >= 'a' && c <= 'f' || c >= 'A' && c <= 'F';
    }

    public static boolean isLetterOrNumber(final char ch) {
        return isLetter(ch) || isNumber(ch);
    }

    public static String toString(char c) {
        return ASCIIStrCache.toString(c);
    }

    public static boolean isCharClass(Class<?> clazz) {
        return clazz == Character.class || clazz == Character.TYPE;
    }

    public static boolean isChar(Object value) {
        return value instanceof Character || value.getClass() == Character.TYPE;
    }

    public static boolean isBlankChar(char c) {
        return isBlankChar((int)c);
    }

    public static boolean isBlankChar(int c) {
        return Character.isWhitespace(c) || Character.isSpaceChar(c) || c == 65279 || c == 8234;
    }

    public static boolean isEmoji(char c) {
        return c != 0 && c != '\t' && c != '\n' && c != '\r' && (c < ' ' || c > '\ud7ff') && (c < '\ue000' || c > '�') && (c < 1048576 || c > 1114111);
    }

    public static boolean isFileSeparator(char c) {
        return '/' == c || '\\' == c;
    }

    public static boolean equals(char c1, char c2, boolean ignoreCase) {
        if (ignoreCase) {
            return Character.toLowerCase(c1) == Character.toLowerCase(c2);
        } else {
            return c1 == c2;
        }
    }

    public static int getType(int c) {
        return Character.getType(c);
    }
}

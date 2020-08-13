package com.strawhat.utils.core.util;

/**
 * @author lize
 * @date 2020/8/13
 */
public class StrUtil {


    public static boolean isEmpty(CharSequence str){
        return str==null || str.length()==0;
    }

    public static boolean isNotEmpty(CharSequence str){
        return !isEmpty(str);
    }

    public static boolean isBlank(CharSequence str) {
        int length;
        if (str != null && (length = str.length()) != 0) {
            for(int i = 0; i < length; ++i) {
                if (!CharUtil.isBlankChar(str.charAt(i))) {
                    return false;
                }
            }

            return true;
        } else {
            return true;
        }
    }
}

package com.strawhat.utils.core.util;

/**
 * @author lize
 * @date 2020/8/13
 */
public class ObjectUtil {
    /**
     * 判断对象是否为null,Object不为null返回Object,为null返回默认值
     * @param object
     * @param defaultValue
     * @param <T>
     * @return
     */
    public static <T> T defaultIfNull(final T object, final T defaultValue) {
        return null != object ? object : defaultValue;
    }
}

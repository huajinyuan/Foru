package com.pro.foru.utils;

/**
 * Created by Administrator on 2016/7/20.
 */
public class StringUtils {
    public static boolean isEmpty(CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    public static boolean isNotEmpty(CharSequence cs) {
        return !StringUtils.isEmpty(cs);
    }
}

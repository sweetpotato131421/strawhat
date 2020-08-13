package com.strawhat.utils.core.date;

import com.strawhat.utils.core.util.StrUtil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 * 时间格式校验工具类
 * @author lize
 * @date 2020/8/13
 */
public class DateUtil {

    public static  DateTime parse(CharSequence dateStr,String format){
        return new DateTime(dateStr,format);
    }

    public static String format(Date date, String format) {
        if(date!=null && !StrUtil.isBlank(format)){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
            if (date instanceof  DateTime){
               TimeZone timeZone=((DateTime)date).getTimeZone();
               if(null!=timeZone){
                   simpleDateFormat.setTimeZone(timeZone);
               }
            }
            return format((Date)date,(DateFormat)simpleDateFormat);
        }else {
            return null;
        }
    }
    public static String format(Date date, DateFormat format) {
        return null != format && null != date ? format.format(date) : null;
    }
}

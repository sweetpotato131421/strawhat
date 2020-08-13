package com.strawhat.utils.core.date;

import com.strawhat.utils.core.util.ObjectUtil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author lize
 * @date 2020/8/13
 */
public class DateTime extends Date {

    private static final long serialVersionUID = 274695562048371213L;

    private boolean mutable;
    private Week firstDayOfWeek;
    private TimeZone timeZone;

    public DateTime(CharSequence dateStr, String format) {
        this((CharSequence)dateStr,(DateFormat)new SimpleDateFormat(format));
    }
    public DateTime(CharSequence dateStr,DateFormat dateFormat){
        this(parse(dateStr,dateFormat),dateFormat.getTimeZone());
    }
    public DateTime(Date date, TimeZone timeZone){
        this(date.getTime(),timeZone);
    }

    public DateTime(long timeMills,TimeZone timeZone){
        super(timeMills);
        this.mutable = true;
        this.firstDayOfWeek = Week.MONDAY;
        this.timeZone = (TimeZone) ObjectUtil.defaultIfNull(timeZone, TimeZone.getDefault());

    }
    public static Date parse(CharSequence dateStr,DateFormat dateFormat) {
        try {
            return dateFormat.parse(dateStr.toString());
        }catch (Exception e){
            //TODO
            throw new RuntimeException("Parse Date Error",e);
        }
    }

    public TimeZone getTimeZone() {
        return this.timeZone;
    }
}

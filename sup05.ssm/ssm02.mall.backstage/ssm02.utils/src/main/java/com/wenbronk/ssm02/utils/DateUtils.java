package com.wenbronk.ssm02.utils;

import org.apache.commons.lang3.time.FastDateFormat;

import java.text.ParseException;
import java.util.Date;

/**
 * @Author wenbronk
 * @Date 2019-07-21
 */
public class DateUtils {
    private static final FastDateFormat dateFormat = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");

    public static String date2Str(Date date) {
        return dateFormat.format(date);
    }

    public static Date str2Date(String dateStr) throws ParseException {
        return dateFormat.parse(dateStr);
    }
}

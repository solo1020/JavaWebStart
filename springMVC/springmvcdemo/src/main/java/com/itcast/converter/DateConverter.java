package com.itcast.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName DateConverter
 * @description:
 * @author: isquz
 * @time: 2021/12/1 22:06
 */
public class DateConverter implements Converter<String, Date> {


    @Override
    public Date convert(String s) {
        // 将日期字符串转成日期对象
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }
}

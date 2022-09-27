package org.luoyinchen.telegrambot.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * @ClassName DateUtils
 * @Description 时间工具类
 * @Author luoyinchen
 * @Date 2022/9/27
 * @Version 1.0
 **/
public class DateUtils {
    //中国时区
    public static final TimeZone SHANGHAI = TimeZone.getTimeZone("Asia/Shanghai");

    private static final String DEFAULT_CHINA_DATE_FORMAT = "日期：yyyy 年 MM 月 dd 日 北京时间：HH 时 mm 分 ss 秒";

    /**
     * 获取中国时区的日历对象
     *
     * @return Calendar 中国时区的日历对象
     */
    public static Calendar getChinaDate() {
        return Calendar.getInstance(SHANGHAI);
    }

    /**
     * 获取中国时区的默认格式处理的时间字符串
     *
     * @return string 时间字符串
     */
    public static String getChinaDateFormatStr() {
        SimpleDateFormat sft = new SimpleDateFormat(DateUtils.DEFAULT_CHINA_DATE_FORMAT);
        sft.setTimeZone(DateUtils.SHANGHAI);
        return sft.format(DateUtils.getChinaDate().getTime());
    }

    /**
     * 获取中国时区的格式化处理的时间字符串
     *
     * @param format 格式
     * @return string 时间字符串
     */
    public static String getChinaDateFormatStr(String format) {
        SimpleDateFormat sft = new SimpleDateFormat(format);
        sft.setTimeZone(DateUtils.SHANGHAI);
        return sft.format(DateUtils.getChinaDate().getTime());
    }
}

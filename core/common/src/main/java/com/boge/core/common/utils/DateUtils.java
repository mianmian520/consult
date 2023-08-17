package com.boge.core.common.utils;

import com.boge.core.common.consts.DateConstants;

import java.lang.management.ManagementFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 * @Author boge
 * @Date 2022/10/19 15:08
 */
public class DateUtils {

    /**
     * 获取服务器启动时间
     */
    public static Date getServerStartDate() {
        long time = ManagementFactory.getRuntimeMXBean().getStartTime();
        return new Date(time);
    }

    /**
     * 计算相差天数
     */
    public static int differentDaysByMillisecond(Date date1, Date date2) {
        return Math.abs((int) ((date2.getTime() - date1.getTime()) / (1000 * 3600 * 24)));
    }

    /**
     * 计算两个时间差
     */
    public static String getDatePoor(Date endDate, Date nowDate) {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
        return day + "天" + hour + "小时" + min + "分钟";
    }

    /**
     * 增加 LocalDateTime ==> Date
     */
    public static Date toDate(LocalDateTime temporalAccessor) {
        ZonedDateTime zdt = temporalAccessor.atZone(ZoneId.systemDefault());
        return Date.from(zdt.toInstant());
    }

    /**
     * 增加 LocalDate ==> Date
     */
    public static Date toDate(LocalDate temporalAccessor) {
        LocalDateTime localDateTime = LocalDateTime.of(temporalAccessor, LocalTime.of(0, 0, 0));
        ZonedDateTime zdt = localDateTime.atZone(ZoneId.systemDefault());
        return Date.from(zdt.toInstant());
    }

    public static Date getNowDate() {
        return new Date();
    }

    public static String parseDateToStr(final String format, final Date date) {
        return new SimpleDateFormat(format).format(date);
    }

    public static Date formatStrToDate(final String format, final String date) throws ParseException {
        return new SimpleDateFormat(format).parse(date);
    }

    /**
     * 得到昨日时间
     * @param lastTime 昨天时间  小时:分钟
     * @return 时间
     */
    public static Date yesterdayDate(String lastTime) throws ParseException {
        Date date = DateUtils.formatStrToDate(DateConstants.HH_MM, lastTime);
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.set(Calendar.DAY_OF_MONTH, instance.get(Calendar.DAY_OF_MONTH));
        return instance.getTime();
    }

    /**
     *  当前时间减去时间
     * @param time 时间
     * @param unit 单位
     * @return 日期时间
     */
    public static Date subtractionTime(int time, int unit) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(getNowDate());
        instance.set(unit, instance.get(unit) - time);
        return instance.getTime();
    }
}

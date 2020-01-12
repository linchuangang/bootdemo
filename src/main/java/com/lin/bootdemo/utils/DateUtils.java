package com.lin.bootdemo.utils;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.tuple.Pair;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * 对日期进行转换处理的工具类。
 *
 * @author Jeesea
 */
public abstract class DateUtils extends org.apache.commons.lang3.time.DateUtils {

    private static final ThreadLocal<SimpleDateFormat> THREAD_LOCAL_FORMAT = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMdd"));
    private static final ThreadLocal<SimpleDateFormat> MONTH_DAY_FORMAT = ThreadLocal.withInitial(() -> new SimpleDateFormat("MM/dd"));
    private static final ThreadLocal<Calendar> THREAD_LOCAL_CALENDAR = ThreadLocal.withInitial(Calendar::getInstance);
    /**
     * 日期格式：yyyyMMdd
     */
    public static final String PATTERN_DATE_SHORT = "yyyyMMdd";

    /**
     * 日期格式：yyyy-MM-dd
     */
    public static final String PATTERN_DATE = "yyyy-MM-dd";

    /**
     * 日期格式：yyyy-MM-dd HH:mm:ss
     */
    public static final String PATTERN_DATE_TIME = "yyyy-MM-dd HH:mm:ss";


    public static final String PATTERN_DATE_TIME2 = "yyyy-MM-dd HH:00:00";


    /**
     * 日期格式：dd/MM/yyyy
     */
    public static final String PATTERN_DATE_2 = "dd/MM/yyyy";

    /**
     * 日期格式：yyyy/MM/dd
     */
    public static final String PATTERN_DATE_3 = "yyyy/MM/dd";

    /**
     * 日期格式：dd/MM/yyyy HH:mm:ss
     */
    public static final String PATTERN_DATE_TIME_2 = "dd/MM/yyyy HH:mm:ss";

    /**
     * 日期格式：yyyy-MM-dd HH:mm:ss.SSS
     */
    public static final String PATTERN_DATE_TIME_FULL = "yyyy-MM-dd HH:mm:ss.SSS";

    /**
     * 日期格式：yyyy-MM
     */
    public static final String PATTERN_YEAR_MONTH = "yyyy-MM";

    public static final String PATTERN_YEAR_MONTH2 = "yyyy/MM";

    /**
     * 日期格式：HH:mm
     */
    public static final String PATTERN_HOUR_MINUTE = "HH:mm";

    /**
     * 日期格式：MM/dd HH:mm
     */
    public static final String PATTERN_MONTH_DAY_HOUR = "MM/dd HH:mm";

    /**
     * 日期格式：MM/dd
     */
    public static final String PATTERN_MONTH_DAY = "MM/dd";

    /**
     * 日期格式：MM/dd
     */
    public static final String PATTERN_HOUR_MINUTE_S = "HH:mm:ss";

    /**
     * 当天的510分钟转换为8:30:00
     **/
    public static String intTimeToString(Integer startTime, Integer time) {
        if (startTime == null) {
            startTime = 0;
        }
        time = time.intValue() + startTime.intValue();
        if (time != null && time.intValue() <= 1440 && time.intValue() >= 0) {
            int hour = time.intValue() / 60;
            int minute = time.intValue() % 60;

            String hourStr = StringUtils.EMPTY;
            String minuteStr = StringUtils.EMPTY;
            if (hour < 10) {
                hourStr = "0" + hour;
            } else {
                hourStr = "" + hour;
            }
            if (minute < 10) {
                minuteStr = "0" + minute;
            } else {
                minuteStr = "" + minute;
            }
            return hourStr + ":" + minuteStr + ":00";
        } else if (time.intValue() >= 1440) {
            int hour = (time.intValue() - 1440) / 60;
            int minute = time.intValue() % 60;

            String hourStr = StringUtils.EMPTY;
            String minuteStr = StringUtils.EMPTY;
            if (hour < 10) {
                hourStr = "0" + hour;
            } else {
                hourStr = "" + hour;
            }
            if (minute < 10) {
                minuteStr = "0" + minute;
            } else {
                minuteStr = "" + minute;
            }
            return hourStr + ":" + minuteStr + ":00";
        }
        return "";
    }


    public static String format(Calendar cal, String pattern) {
        if (cal == null) {
            return null;
        }

        return DateFormatUtils.format(cal, pattern);
    }

    /**
     * 将日期时间置为23点59分59秒
     *
     * @param date
     * @return
     */
    public static Date last(Date date) {
        date.setHours(23);
        date.setMinutes(59);
        date.setSeconds(59);
        return date;
    }

    /**
     * 将日期时间置为0点0分0秒
     *
     * @param date
     * @return
     */
    public static Date begin(Date date) {
        date.setHours(00);
        date.setMinutes(00);
        date.setSeconds(00);
        return date;
    }

    public static String format(Date date, String pattern) {
        if (date == null) {
            return null;
        }

        return DateFormatUtils.format(date, pattern);
    }

    public static String formatToDate(Calendar cal) {
        if (cal == null) {
            return null;
        }

        return DateFormatUtils.ISO_DATE_FORMAT.format(cal);
    }

    public static String formatToDate(Date date) {
        if (date == null) {
            return null;
        }

        return DateFormatUtils.ISO_DATE_FORMAT.format(date);
    }

    public static String formatToDateTime(Calendar cal) {
        return format(cal, PATTERN_DATE_TIME);
    }

    public static String formatToDateTime(Date date) {
        return format(date, PATTERN_DATE_TIME);
    }

    /**
     * 获取某天的开始时间。
     */
    public static Date getDateBegin(Date date) {
        if (date == null) {
            return null;
        }

        return truncate(date, Calendar.DATE);
    }

    /**
     * 获取某天的开始时间和结束时间。
     */
    public static Pair<Date, Date> getDateBeginAndEnd(Date date) {
        return Pair.of(getDateBegin(date), getDateEnd(date));
    }

    /**
     * 获取某天的结束时间。
     */
    public static Date getDateEnd(Date date) {
        if (date == null) {
            return null;
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTime();
    }

    /**
     * 获取当前月的第一天的开始时间。
     */
    public static Date getMonthBegin() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        return getMonthBegin(year, month);
    }

    /**
     * 获取某年中某月的第一天的开始时间。
     */
    public static Date getMonthBegin(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, 1);
        return getDateBegin(cal.getTime());
    }

    /**
     * 获取当前月的第一天的开始时间和最后一天的结束时间。
     */
    public static Pair<Date, Date> getMonthBeginAndEnd() {
        return Pair.of(getMonthBegin(), getMonthEnd());
    }

    /**
     * 获取某年中的某月的第一天的开始时间和最后一天的结束时间。
     */
    public static Pair<Date, Date> getMonthBeginAndEnd(int year, int month) {
        return Pair.of(getMonthBegin(year, month), getMonthEnd(year, month));
    }

    /**
     * 获取当前月的最后一天的结束时间。
     */
    public static Date getMonthEnd() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        return getMonthEnd(year, month);
    }

    /**
     * 获取某年中某月的最后一天的结束时间。
     */
    public static Date getMonthEnd(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, 1);
        cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        return getDateEnd(cal.getTime());
    }

    /**
     * 获取今天开始时间。
     */
    public static Date getTodayBegin() {
        return getDateBegin(new Date());
    }

    /**
     * 获取今天的开始时间和结束时间。
     */
    public static Pair<Date, Date> getTodayBeginAndEnd() {
        return Pair.of(getTodayBegin(), getTodayEnd());
    }

    /**
     * 获取今天的结束时间。
     */
    public static Date getTodayEnd() {
        return getDateEnd(new Date());
    }

    /**
     * 获取昨天开始时间。
     */
    public static Date getYestodyBegin() {
        Date todayBegin = getTodayBegin();
        return todayBegin == null ? null : DateUtils.addDays(todayBegin, -1);
    }

    /**
     * 获取昨天的开始时间和结束时间。
     */
    public static Pair<Date, Date> getYestodyBeginAndEnd() {
        return Pair.of(getYestodyBegin(), getYestodyEnd());
    }

    /**
     * 获取昨天的结束时间。
     */
    public static Date getYestodyEnd() {
        Date todayEnd = getTodayEnd();
        return todayEnd == null ? null : DateUtils.addDays(todayEnd, -1);
    }

    /**
     * 获取当前时间所在的年份，例如：2015。
     */
    public static int getYear() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.YEAR);
    }

    /**
     * 根据日期对象获取年份。如果 <code>date</code> 为 null，则返回 0。
     */
    public static int getYear(Date date) {
        if (date == null) {
            return 0;
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.YEAR);
    }

    /**
     * 根据日期对象获取月份。
     *
     * <p>
     * <strong>返回值说明：</strong>
     * <ul>
     * <li>当 date 为 null 时，返回 0</li>
     * <li>其他情况返回 1-12 的数字</li>
     * </ul>
     */
    public static int getMonth(Date date) {
        if (date == null) {
            return 0;
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MONTH) + 1;
    }


    /**
     * 根据日期对象获取年份。如果 <code>date</code> 为 null，则返回 0。
     */
    public static int getWeekOfYear(Date date) {
        if (date == null) {
            return 0;
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * 根据日期对象获取星期几，根据中国人的传统将星期一作为星期的第一天。
     *
     * <p>
     * <strong>返回值说明：</strong>
     * <ul>
     * <li>当 date 为 null 时，返回 0</li>
     * <li>其他情况返回 1-7 的数字</li>
     * <li>其中，星期一是 1，星期天是 7</li>
     * </ul>
     */
    public static int getChineseWeek(Date date) {
        if (date == null) {
            return 0;
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        return dayOfWeek == 1 ? 7 : dayOfWeek - 1;
    }

    /**
     * 根据日期对象获取当周是一年中的第几周，根据中国人的传统将星期一作为星期的第一天。
     *
     * <p>
     * <strong>返回值说明：</strong>
     * <ul>
     * <li>当 date 为 null 时，返回 0</li>
     * <li>其他情况返回周次的数字</li>
     * </ul>
     */
    public static int getChineseWeekOfYear(Date date) {
        if (date == null) {
            return 0;
        }

        Calendar cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.setTime(date);
        return cal.get(Calendar.WEEK_OF_YEAR);
    }

    public static Date parse(String str, String pattern) {
        if (StringUtils.isBlank(str)) {
            return null;
        }

        Date result = null;
        try {
            result = parseDate(str, pattern);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static Date parseByDate(String str) {
        return parse(str, PATTERN_DATE);
    }

    public static Date parseByInt(String str) {
        return parse(str, PATTERN_DATE_SHORT);
    }

    public static Date parseByDateTime(String str) {
        return parse(str, PATTERN_DATE_TIME);
    }

    public static Date parseByDate2(String str) {
        return parse(str, PATTERN_DATE_2);
    }

    public static Date parseByDate3(String str) {
        return parse(str, PATTERN_DATE_3);
    }

    public static Date parseByDateTime2(String str) {
        return parse(str, PATTERN_DATE_TIME_2);
    }

    /**
     * 将秒数格式化为可读的时间。例如：08:58
     */
    public static String secondsToDisplayTime(long seconds) {
        if (seconds < 0) {
            return "00:00";
        }

        long day = TimeUnit.SECONDS.toDays(seconds);
        long hour = TimeUnit.SECONDS.toHours(seconds) - (day * 24);
        long minute = TimeUnit.SECONDS.toMinutes(seconds) - (TimeUnit.SECONDS.toHours(seconds) * 60);
        long second = TimeUnit.SECONDS.toSeconds(seconds) - (TimeUnit.SECONDS.toMinutes(seconds) * 60);

        StringBuilder time = new StringBuilder();
        if (day != 0) {
            time.append(StringUtils.leftPad(String.valueOf(day), 2, "0") + ":");
        }
        if (hour != 0) {
            time.append(StringUtils.leftPad(String.valueOf(hour), 2, "0") + ":");
        }
        time.append(StringUtils.leftPad(String.valueOf(minute), 2, "0") + ":");
        time.append(StringUtils.leftPad(String.valueOf(second), 2, "0"));

        return time.toString();
    }

    /**
     * 将秒转成小时分钟秒并展示
     *
     * @param duration
     * @return
     */
    public static String toDisplayString(long duration) {
        long hour = duration / (60 * 60);
        long minute = (duration - (hour * 60 * 60)) / 60;
        long second = duration % 60;
        StringBuilder buf = new StringBuilder();

        if (hour > 0) {
            buf.append(hour).append("h");
        }

        if (minute > 0) {
            buf.append(minute).append("m");
        }

        if (minute > 0) {
            buf.append(second).append("s");
        }

        return buf.toString();
    }

    /**
     * 获得当天从零点以来的分钟数
     *
     * @return
     */
    public static int getCurrentMinuteFromBegin() {
        Calendar cal = Calendar.getInstance();
        int nowMinutes = cal.get(Calendar.HOUR_OF_DAY) * 60 + cal.get(Calendar.MINUTE);
        return nowMinutes;
    }

    /**
     * 将时间规约到指定的小时
     *
     * @param cal       - 日期
     * @param hourOfDay
     * @return
     */
    public static Calendar restrictTime2Hour(Calendar cal, int hourOfDay) {
        cal.set(Calendar.HOUR_OF_DAY, hourOfDay);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal;
    }

    public static void main(String[] arg) {
        Date date = DateUtils.parseByDateTime("2016-08-26 12:22:36");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

//		System.out.println(sdf.format(date));


        System.out.println(intTimeToString(0, 1200));
        System.out.println(getCurrentMinuteFromBegin());
        System.out.println(new Date().getMinutes());
    }

    public static int getDayOfYearFromDate(Date date) {
        SimpleDateFormat simpleDateFormat = THREAD_LOCAL_FORMAT.get();
        return Integer.valueOf(simpleDateFormat.format(date));
    }

    public static int getDayOfYearFromDate(Calendar date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        return Integer.valueOf(simpleDateFormat.format(date.getTime()));
    }

    public static int getDayOfYearFromDateStr(String dateStr) {
        Date date;
        try {
            date = parseByDate(dateStr);
        } catch (RuntimeException e) {
            date = parseByDateTime(dateStr);
        }
        return getDayOfYearFromDate(date);
    }

    public static Date getDateFromDayOfYear(int day) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        try {
            return simpleDateFormat.parse(String.valueOf(day));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 从给定的日期参数得到累进的分钟数，例如08:30 为 8*60+30 = 510
     *
     * @param date 时间
     * @return 累进的分钟总数
     */
    public static int dateToMinute(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Long minutes = TimeUnit.HOURS.toMinutes(calendar.get(Calendar.HOUR_OF_DAY));
        return minutes.intValue() + calendar.get(Calendar.MINUTE);
    }


    /**
     * 通过年月，计算月份天数。
     */
    public static int getDaysByYearMonth(String year, String month) {
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy/MM");
        Calendar rightNow = Calendar.getInstance();
        try {
            rightNow.setTime(simpleDate.parse(year + "/" + month));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //根据年月 获取月份天数
        int days = rightNow.getActualMaximum(Calendar.DAY_OF_MONTH);
        return days;
    }

    public static Date getYearMonthWeekSunday(int year, int month, int week) {
        Calendar calendar = THREAD_LOCAL_CALENDAR.get();
        if (Objects.equals(Calendar.DECEMBER, month) && Objects.equals(1, week)) {
            year += 1;
        }
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.WEEK_OF_YEAR, week);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        return calendar.getTime();
    }

    /**
     * 获取month day
     *
     * @param date
     * @return
     */
    public static String getMonthDayFromDate(Date date) {
        SimpleDateFormat sdf = MONTH_DAY_FORMAT.get();
        return sdf.format(date);
    }

    /**
     * 20190530 -->> 05/30
     */
    public static String formatMonthSunDay(Integer dayOfYear) {
        Date dateFromDayOfYear = DateUtils.getDateFromDayOfYear(dayOfYear);
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateFromDayOfYear);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        Date time = cal.getTime();
        String format = DateUtils.format(time, DateUtils.PATTERN_DATE_SHORT);
        String substring = format.substring(4);
        StringBuilder builder = new StringBuilder(substring);
        builder.insert(2, "/");
        return builder.toString();
    }

    public static String formatMonthDay(Integer dayOfYear) {
        Date dateFromDayOfYear = DateUtils.getDateFromDayOfYear(dayOfYear);
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateFromDayOfYear);
        Date time = cal.getTime();
        String format = DateUtils.format(time, DateUtils.PATTERN_DATE_SHORT);
        String substring = format.substring(4);
        StringBuilder builder = new StringBuilder(substring);
        builder.insert(2, "/");
        return builder.toString();
    }

    /**
     * 对齐到周日
     *
     * @param time
     * @return
     */
    public static LocalDateTime alignLocalDateTimeToSunday(LocalDateTime time) {
        LocalDate localDate = time.toLocalDate();
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        if (!Objects.equals(dayOfWeek, DayOfWeek.SUNDAY)) {
            LocalDate sunday = localDate.with(ChronoField.DAY_OF_WEEK, DayOfWeek.SUNDAY.getValue());
            time = LocalDateTime.of(sunday, time.toLocalTime());
        }
        return time;
    }


    /**
     * 对齐到周日
     *
     * @param date
     * @return
     */
    public static Date alignDateToSunday(Date date) {
        LocalDateTime time = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        LocalDate localDate = time.toLocalDate();
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        if (!Objects.equals(dayOfWeek, DayOfWeek.SUNDAY)) {
            LocalDate sunday = localDate.with(ChronoField.DAY_OF_WEEK, DayOfWeek.SUNDAY.getValue());
            time = LocalDateTime.of(sunday, time.toLocalTime());
        }
        return Date.from(time.toInstant(ZoneOffset.ofHours(8)));
    }

    /**
     * 对齐到周日
     *
     * @param dayOfYear
     * @return
     */
    public static Integer alignDayOfYearToSunday(Integer dayOfYear) {
        Date dateFromDayOfYear = getDateFromDayOfYear(dayOfYear);
        Date date = alignDateToSunday(dateFromDayOfYear);
        return getDayOfYearFromDate(date);
    }

    /**
     * 获取当前日期是星期几<br>
     *
     * @param date
     * @return 当前日期是星期几
     */
    public static String getWeekOfDate(Date date) {
        String[] weekDays = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0) {
            w = 0;
        }
        return weekDays[w];
    }

    /**
     * 根据星期获取日期
     *
     * @param week 星期几 1代码星期日，2代表星期一。。。7代表星期六
     * @return
     */
    public static Date getDateByWeek(int week) {
        int targetWeek = week;
        Calendar c = Calendar.getInstance();
        // 当前日期星期数
        int currWeek = c.get(Calendar.DAY_OF_WEEK);

        if (currWeek > targetWeek) {
            do {
                // 向前推一天，直到星期数与所给星期数相同
                c.add(Calendar.DAY_OF_MONTH, -1);
            } while (targetWeek != c.get(Calendar.DAY_OF_WEEK));
        } else if (currWeek < targetWeek) {
            do {
                // 向后推一天，直到星期数与所给星期数相同
                c.add(Calendar.DAY_OF_MONTH, 1);
            } while (targetWeek != c.get(Calendar.DAY_OF_WEEK));
        }
        return c.getTime();
    }

}

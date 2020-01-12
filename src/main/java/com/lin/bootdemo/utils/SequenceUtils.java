package com.lin.bootdemo.utils;

import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.DatatypeConverter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.Random;

/**
 * @author gd
 * @Date 2019/7/5 16:15
 * @Description random sequence
 * 生成计划批次，32位随机序列
 * 以ip和当前时间计算
 */
public final class SequenceUtils {
    private static final Logger logger= LoggerFactory.getLogger(SequenceUtils.class);

    private static final String EDITION_PATTERN="yyyyMMddHHmmssSSS";
    private static final String FORECAST_PATTERN = "MM/dd/yyyy";
    private static final ThreadLocal<SimpleDateFormat> SIMPLE_DATE_FORMAT=ThreadLocal.withInitial(() ->new SimpleDateFormat(EDITION_PATTERN));
    private static final ThreadLocal<SimpleDateFormat> FORECAST_DATE_FORMAT=ThreadLocal.withInitial(() ->new SimpleDateFormat(FORECAST_PATTERN));
    private static final ThreadLocal<Calendar> THREAD_LOCAL_CALENDAR=ThreadLocal.withInitial(Calendar::getInstance);
    private static final  char[] str = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
            'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private static final int len=10;
    /**
     * 获取随机序列号
     * @return
     */
    public static String getRandomSequence()
    {
        String hostAddress="";
        try
        {
             hostAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            logger.error("unknown host address!");
        }
        long time = System.nanoTime();
        hostAddress+=time;
        StringBuilder sb=new StringBuilder();
        Random r=new Random();
        int i=0;
        while (i<len)
        {
            sb.append(str[r.nextInt(str.length)]);
            i++;
        }
        try
        {
            // md5 加密一次
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            instance.update(hostAddress.getBytes(Charset.defaultCharset()));
            instance.update(sb.toString().getBytes(Charset.defaultCharset()));
            byte[] digest = instance.digest();
            return DatatypeConverter.printHexBinary(digest);
        }
        catch (NoSuchAlgorithmException e)
        {
            logger.error("no such message digest algorithm!");
        }
        return null;
    }

    /**
     *  获得时间序列
     * @return
     */
    public static String getTimeSequence()
    {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(EDITION_PATTERN));
    }

    /**
     *  通过edition 获取forecast day
     * @param edition
     * @return
     */
    public static String getEditionForecastDay(String edition)
    {
        SimpleDateFormat sdf = SIMPLE_DATE_FORMAT.get();
        SimpleDateFormat sf = FORECAST_DATE_FORMAT.get();
        Date parseEdition = null;
        try
        {
            parseEdition = sdf.parse(edition);
            return sf.format(parseEdition);
        }
        catch (ParseException e)
        {
            logger.error("can not parse edition {} to specific date!",edition);
        }
        return null;
    }

    /**
     *
     * @param edition
     * @return
     */
    public static Integer getEditionYearWeek(String edition)
    {
        SimpleDateFormat sdf = SIMPLE_DATE_FORMAT.get();
        Calendar calendar=THREAD_LOCAL_CALENDAR.get();
        try
        {
            Date parse = sdf.parse(edition);
            calendar.setTime(parse);
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int week = calendar.get(Calendar.WEEK_OF_YEAR);
            if (Objects.equals(Calendar.DECEMBER,month) && Objects.equals(1,week))
            {
                year+=1;
            }
            return year*100 + week;
        } catch (ParseException e)
        {
            logger.error("can not parse edition {}",edition);
        }
        return 0;
    }
}

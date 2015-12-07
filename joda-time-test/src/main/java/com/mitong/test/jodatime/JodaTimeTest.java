package com.mitong.test.jodatime;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 15-7-21
 */
public class JodaTimeTest {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
    public static void main(String[] args) {
        DateTime dateTime = new DateTime(new Date());
        System.out.println(dateTime.getDayOfMonth());
        System.out.println(dateTime.getMonthOfYear());
        System.out.println(dateTime.getYear());
        System.out.println(dateTime.centuryOfEra().get());
        System.out.println(DateTime.now().withTime(0, 0, 0, 0).equals(DateTime.now().withTimeAtStartOfDay()));
        DateTime newYear = dateTime.plusYears(2).withDayOfYear(154);
        System.out.println(Days.daysBetween(dateTime, newYear).getDays());
        System.out.println(DATE_TIME_FORMATTER.print(newYear));


        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
    }
}

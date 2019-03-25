package com.example.gt.musyrif;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Function {
    public static String EpochDateString(String epochSeconds, String formatString) {
        Date updateDate = new Date(Long.parseLong(epochSeconds));
        SimpleDateFormat format = new SimpleDateFormat(formatString);
        return format.format(updateDate);

    }
    public static Calendar EpochCalendar(String epochSeconds){
        Date updateDate = new Date (Long.parseLong(epochSeconds));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(updateDate);
        return calendar;
    }

}

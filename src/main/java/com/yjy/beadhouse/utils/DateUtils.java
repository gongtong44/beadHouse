package com.yjy.beadhouse.utils;


import java.text.SimpleDateFormat;
import java.util.Date;


public class DateUtils {

    public static String getNowTime(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(new Date());
    }

    public static String formatDate(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(date);
    }
}

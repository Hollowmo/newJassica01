package com.jassica.jassica.utils;

public class DateUtil {

    /**
     * 毫秒转化为天小时分钟秒
     *
     * @param ms 毫秒值
     * @return
     */
    public static String formatTime(long ms) {
        int ss = 1000;
        int mi = ss * 60;
        int hh = mi * 60;
        int dd = hh * 24;

        long day = ms / dd;
        long hour = (ms - day * dd) / hh;
        long minute = (ms - day * dd - hour * hh) / mi;
        double second = (ms - day * dd - hour * hh - minute * mi) * 1.0 / ss;
        // long milliSecond = ms - day * dd - hour * hh - minute * mi - second * ss;

        if (day > 0) {
            return day + "天" + hour + " : " + minute + " : " + (int) second;
        } else if (hour > 0) {
            return hour + " : " + minute + " : " + (int) second;
        } else if (minute > 0) {
            return minute + "分钟";
        } else {
            return 0 + "分钟";
        }
    }

}

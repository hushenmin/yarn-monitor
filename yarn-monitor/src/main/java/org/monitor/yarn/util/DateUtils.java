package org.monitor.yarn.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2017/6/14.
 */
public class DateUtils {
    public  static  final SimpleDateFormat TIME_FORMAT =
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private  static final  SimpleDateFormat DATE_FORMAT =
            new SimpleDateFormat("yyyy-MM-dd");
    public static  String formatTime(Date date){return  TIME_FORMAT.format(date);}

    public static  String formatTime(){return  TIME_FORMAT.format(new Date());}

    public  static  String formatDate(Date date){return  DATE_FORMAT.format(date);}

    public  static  String  formatTimeStamp(Date date){return String.valueOf(date.getTime());  }

    /**
     * 计算时间差值（单位为秒）
     * @param time1 时间1
     * @param time2 时间2
     * @return 差值
     */
    public static int minus(String time1, String time2) {
        try {
            Date datetime1 = TIME_FORMAT.parse(time1);
            Date datetime2 = TIME_FORMAT.parse(time2);

            long millisecond = datetime1.getTime() - datetime2.getTime();

            return Integer.valueOf(String.valueOf(millisecond / 1000));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 计算几天前的时间（凌晨开始）
     * @param day
     * @return
     */
    public static String getDateBefore(int day){
        Calendar calendar =Calendar.getInstance();
        calendar.add(Calendar.DATE, -day);
        return formatDate(calendar.getTime());

    }

}

package slh.code.java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TestDemo {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getTimeZone("America/New_York"));
//        sdf.setTimeZone(TimeZone.getTimeZone("America/Lima"));

        Date date = sdf.parse("2021-05-21");

        System.out.println(date);


        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY,10);
        cal.set(Calendar.MINUTE,00);
        cal.setTimeZone(TimeZone.getTimeZone("America/Lima"));
        System.out.println(cal.getTime());
//        cal.setTime();

        Calendar cal2 = Calendar.getInstance();
        cal2.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        cal2.set(2021,5,20,16,00);
        System.out.println(cal2.getTime());
    }

}

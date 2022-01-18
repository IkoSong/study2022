package slh.code.java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateDemo {
    public static void main(String[] args) {
        String usDate = "04-21-2021 05:22:26";
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("America/New York"));
        try {
            Date date = sdf.parse(usDate);
            SimpleDateFormat sdf2 = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
            for (String availableID : TimeZone.getAvailableIDs()) {
                System.out.println(availableID);
            }
            System.out.println();
            sdf2.setTimeZone(TimeZone.getTimeZone("GMT"));
            System.out.println(sdf2.format(date));
            System.out.println(date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

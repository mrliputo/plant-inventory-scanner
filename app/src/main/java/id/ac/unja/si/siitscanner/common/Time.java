package id.ac.unja.si.siitscanner.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static java.util.Calendar.DATE;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;

public class Time {

    // This method gets the age of the plant based on the planted date
    public static int getPlantAge(String planted) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Date stringPlanted = null;

        try {
            stringPlanted = sdf.parse(planted);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar a = Calendar.getInstance();
        a.setTime(stringPlanted);

        Calendar b = Calendar.getInstance();

        int diff = b.get(YEAR) - a.get(YEAR);
        if (a.get(MONTH) > b.get(MONTH) ||
                (a.get(MONTH) == b.get(MONTH) && a.get(DATE) > b.get(DATE))) {
            diff--;
        }
        return diff;
    }
}

package hw8.taxi;

import hw8.taxi.service.ClientService;
import hw8.taxi.service.ClientServiceImpl;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * Created by ПК on 16.07.2015.
 */
@Deprecated
public class MainTaxiTester {
    private static long ONE_YEAR_AS_MILLISECONDS = 365L*24L*60L*60L*1000L;
    private static long TWENTY_FIVE_YEARS_AS_MILLISECONDS = 25L*ONE_YEAR_AS_MILLISECONDS;
    private static long FIFTY_YEARS_AS_MILLISECONDS = 50L*ONE_YEAR_AS_MILLISECONDS;
    private static String generateDOB()
    {
        //Equation for calculating a random number within a given range is as follows:  Min + (int)(Math.random() * ((Max - Min) + 1))
        long someTimeBetween25And50YearsInMilliSeconds = TWENTY_FIVE_YEARS_AS_MILLISECONDS +
                (long)(Math.random() * ((FIFTY_YEARS_AS_MILLISECONDS - TWENTY_FIVE_YEARS_AS_MILLISECONDS) + 1));
        Calendar dob = Calendar.getInstance();
        dob.setTimeInMillis(dob.getTimeInMillis() - someTimeBetween25And50YearsInMilliSeconds);
        StringBuffer sb = new StringBuffer();
        sb.append(dob.get(Calendar.YEAR)).append("/").append(dob.get(Calendar.MONTH)+1).append("/").append(dob.get(Calendar.DAY_OF_MONTH));
        System.out.println(sb.toString());
        return sb.toString();
    }

    public static void main(String[] args) {
        long yearTime = 12L * 30L * 24L * 60L * 60L * 1000L;
        Date randomDate = new Date(System.currentTimeMillis()-(long)(Math.random()*yearTime));
        System.out.println(randomDate);


        //-------------Рабочий код!
       /* long yearTime = 12L * 30L * 24L * 60L * 60L * 1000L;
        Calendar cal = Calendar.getInstance();
        long mathrand = (long)(Math.random()*yearTime);
        cal.setTimeInMillis(cal.getTimeInMillis()-(long)(Math.random()*yearTime));
        Date randomDate = new Date(cal.getTimeInMillis());*/


    }
    }
/* Random random = new Random();
        long yearTime = 12L * 30L * 24L * 60L * 60L * 1000L;
        System.out.println(yearTime);
        Calendar cal = Calendar.getInstance();
        System.out.println(cal);
        long curTimeMillis = cal.getTimeInMillis();
        Calendar cal2 = Calendar.getInstance();
        cal2.add(Calendar.YEAR, -1);
        System.out.println(cal2);
        long differense = curTimeMillis-cal2.getTimeInMillis();
        System.out.println(differense);
        Date randomDate = new Date(curTimeMillis-(long)Math.random()*differense+1);
        System.out.println(randomDate);

    }*/
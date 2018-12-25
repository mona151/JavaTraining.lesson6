import java.util.concurrent.ThreadLocalRandom;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RandomDateGenerator {

    private static Date generateRandomTimestamp(){
        Date startDate = new Date(110 ,0 ,0);
        Date endDate  = new Date();
        long random = ThreadLocalRandom.current().nextLong(startDate.getTime(), endDate.getTime());
        Date date = new Date(random);
        return date;
    }

    public static String getSimpleRandomDate(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(generateRandomTimestamp());
    }

    public static String getRandomTimestamp(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(generateRandomTimestamp());
    }
}

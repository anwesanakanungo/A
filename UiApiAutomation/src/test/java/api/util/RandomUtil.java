package api.util;

import java.util.Random;

public final class RandomUtil {
    private RandomUtil() {

    }

    public static int getNumber() {
        Random rand = new Random();

        return rand.nextInt(1000);
    }

    public static String getFirstName() {
        return FakerUtil.getFirstName();
    }

    public static String getLastName() {
        return FakerUtil.getLastName();
    }

    public static String getFromDate() {
        return FakerUtil.getFromDate();
    }

    public static String getDateToday() {
        return FakerUtil.getToDate();
    }

    public static String getFood() {
        return FakerUtil.getFood();
    }

    public static Boolean getBooleanValueTrue() {

        return FakerUtil.getBooleanValueTrue();
    }

}

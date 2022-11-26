package api.util;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;


public final class FakerUtil {

    static Faker faker = new Faker();

    private FakerUtil() {
    }

    static String getNumber() {

        return String.valueOf(faker.number());
    }

    static String getFirstName() {
        return faker.name().firstName();
    }

    static String getLastName() {
        return faker.name().lastName();
    }

    static String getFromDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Faker faker = new Faker();
        return sdf.format(faker.date().birthday());
    }

    static String getToDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Faker faker = new Faker();
        return sdf.format(faker.date().birthday());
    }

    static String getFood() {
        return faker.food().fruit();
    }

    static Boolean getBooleanValueTrue() {
        return faker.bool().equals("true");
    }
}

package api.apiconfigreader;

import frameworkconstants.FrameWorkConstants;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public final class ConfigReader {

    private static final Properties properties = new Properties();
    private static final HashMap<String, String> MAP = new HashMap<>();

    static {
        try {
            FileInputStream fileInputStream = new FileInputStream(FrameWorkConstants.CONFIGFILE);
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
        properties.entrySet().forEach(e -> MAP.put(String.valueOf(e.getKey()), (String.valueOf(e.getValue()))));
    }

    private ConfigReader() {
    }

    public static String getValue(String Key) {
        return MAP.get(Key);

    }


}

package api.util;

import java.util.LinkedHashMap;

public class DataStore {
    private static final ThreadLocal<LinkedHashMap<String, Object>> dataMap =
            ThreadLocal.withInitial(() -> new LinkedHashMap<String, Object>());

    private DataStore() {
    }

    public static void setValue(String key, Object value) {
        dataMap.get().put(key, value);
    }

    public static Object getValue(String key) {
        return dataMap.get().get(key);
    }
}

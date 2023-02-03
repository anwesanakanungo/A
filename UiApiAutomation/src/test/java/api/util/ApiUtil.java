package api.util;

import io.restassured.response.Response;
import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Paths;

public final class ApiUtil {
    private  ApiUtil() {
    }

    @SneakyThrows
    public static String readJsonFileGetAsString(String filepath) {
        return new String(Files.readAllBytes(Paths.get(filepath)));
    }

    @SneakyThrows
    public static void storeJsonResponse(String filepath, Response response) {
        Files.write(Paths.get(filepath), response.asByteArray());
    }
}

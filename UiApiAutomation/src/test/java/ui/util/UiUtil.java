package ui.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public final class UiUtil {
    private WebDriver driver ;
    private UiUtil() {
    }

    public static String getTextForElement(WebElement element ){
        return element.getText();
    }
    public static void getTextForElements(List<WebElement> elements ){
       // elements.stream().forEach();
    }
    public static int   getResponseCode(String str) throws IOException {
        URL url = new URL(str);
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
          int statusCode = http.getResponseCode();
        System.out.printf(str + "::" +statusCode);
        return statusCode;
    }
}

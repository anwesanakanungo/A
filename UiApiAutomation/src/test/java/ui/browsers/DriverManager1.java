package ui.browsers;
import frameworkconstants.FrameWorkConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.function.Supplier;

public final class DriverManager1 {
    public static final Supplier<WebDriver> chromeSupplier=()-> {
        System.setProperty("webdriver.chrome.driver",FrameWorkConstants.CHROMEDRIVERPATH );
        return new ChromeDriver();
    };
    public static final Supplier<WebDriver> FirefoxSupplier=()-> {
        System.setProperty("webdriver.gecko.driver", FrameWorkConstants.FIREFOXDRIVERPATH);
        return new FirefoxDriver();
    };
public static final Supplier<WebDriver> remoteSupplier=()-> {
    RemoteWebDriver remoteWebDriver = null;
    try {
        remoteWebDriver= new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
               DesiredCapabiltyRemoteChrome.getChromeDesiredCapabilty());
    } catch (MalformedURLException e) {
        e.printStackTrace();
    }
    return remoteWebDriver;
 } ;
    private DriverManager1() {
    }

}

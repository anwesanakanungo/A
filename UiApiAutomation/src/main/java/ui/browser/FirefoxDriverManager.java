package ui.browser;

import frameworkconstants.FrameWorkConstants;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class FirefoxDriverManager extends DriverManager {

    private GeckoDriverService firefoxService;

    @Override
    public void startService() {
        if (null == firefoxService) {
            try {
                firefoxService = new GeckoDriverService.Builder()
                        .usingDriverExecutable(new File(FrameWorkConstants.FIREFOXDRIVERPATH))
                        .usingAnyFreePort()
                        .build();
                firefoxService.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void stopService() {
        if (null != firefoxService && firefoxService.isRunning())
            firefoxService.stop();
    }

    @Override
    public void createDriver() {

        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("test-type-firefox");
        capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
        driver = new FirefoxDriver((Capabilities) firefoxService, capabilities);
    }

}

package ui.browsers;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCapabiltyRemoteChrome {

    public static DesiredCapabilities getChromeDesiredCapabilty(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("version", "108");
        capabilities.setCapability("platform", "LINUX");
return capabilities ;
    }
}

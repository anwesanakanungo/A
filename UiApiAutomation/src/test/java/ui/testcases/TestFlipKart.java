package ui.testcases;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.browser.DriverManager;
import ui.browsers.BrowserTypes;
import ui.browsers.DesiredCapabiltyRemoteChrome;
import ui.browsers.DriverManager1;
import ui.pages.AmazonHomePage;
import ui.pages.DellComputerPage;
import ui.pages.GoogleSearchPage;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;


public class TestFlipKart {
    DriverManager driverManager;
    WebDriver driver ;
    @Test
    public void flipkartTest() throws InterruptedException, MalformedURLException {

        driver=DriverManager1.remoteSupplier.get();
        driver.get("https://www.google.com/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.navigate().refresh();
        driver.findElement(By.name("q")).sendKeys("asdfgfg");
        driver.quit();
        //driver.findElement(By.xpath("//div[@class='_3uDYxP']//select[@class='_2YxCDZ']")).click();


    }

        @Test
        public void filterPriceTest() throws InterruptedException, MalformedURLException {
        //docker container run -p 4445:4445 --name anwesana1 selenium/standalone-chrome
            driver=DriverManager1.remoteSupplier.get();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            GoogleSearchPage.using(driver)
                    .goToGoogle()
                    .setSearchText("amazon")
                    .goToAmazon();
            AmazonHomePage.using(driver)
                    .setSearchText("dell computers");

          driver.quit();
            }

        }




package ui.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ui.browser.DriverManager;
import ui.browser.DriverManagerFactory;
import ui.browser.DriverType;
import ui.pages.AmazonHomePage;
import ui.pages.DellComputerPage;
import ui.pages.GoogleSearchPage;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TestFlipKart {
    DriverManager driverManager;
    WebDriver driver;


    @BeforeTest
    public void beforeTest() {
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = driverManager.getDriver();
    }

    @AfterMethod
    public void afterMethod() {
        driverManager.quitDriver();
    }

    @Test
    public void flipkartTest() throws InterruptedException {
        driver.get("https://www.makemytrip.com/hotels/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.navigate().refresh();

        driver.findElement(By.id("checkin")).click();

        driver.findElement(By.xpath("//div[@aria-label='Fri Jan 13 2023']")).click();
        driver.findElement(By.xpath("//div[@aria-label='Sun Jan 15 2023']")).click();
        //driver.findElement(By.xpath("//div[@class='_3uDYxP']//select[@class='_2YxCDZ']")).click();


    }

}

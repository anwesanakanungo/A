package ui.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import ui.browsers.DriverManager1;
import ui.util.UiUtil;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static ui.util.UiUtil.getResponseCode;

public class RemovetheBlankLinks {
    WebDriver driver;

    @Test
    public void removeTheBlankLinksTest() throws InterruptedException, MalformedURLException {

        this.driver = DriverManager1.chromeSupplier.get();
        this.driver.get("https://www.google.com/");
        this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        List<WebElement> el = this.driver.findElements(By.tagName("a"));
        Predicate<WebElement> isBlank = (e) -> e.getText().trim().length() != 0;
        Predicate<WebElement> contains = (e) -> ! e.getText().contains("S");
        el.stream().
                filter(isBlank).filter(contains).map((e)-> e.getText()).forEach(System.out::println);
    }
    @Test
    public void verifyPageTitle() throws InterruptedException, MalformedURLException {
        this.driver = DriverManager1.chromeSupplier.get();
        this.driver.get("https://www.google.com/");
        this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String pageTitle= driver.getTitle();
        System.out.println(pageTitle);
        assertThat(pageTitle).isEqualTo("Google");
    }
    @AfterTest
    public void teardown(){
        driver.quit();
    }

}
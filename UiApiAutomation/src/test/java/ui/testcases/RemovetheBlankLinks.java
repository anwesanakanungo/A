package ui.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ui.browsers.DriverManager1;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

public class RemovetheBlankLinks {
    WebDriver driver;

    @Test
    public void removeTheBlankLinksTest() throws InterruptedException, MalformedURLException {

        this.driver = DriverManager1.chromeSupplier.get();
        this.driver.get("https://www.google.com/");
        this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      List<WebElement> el= this.driver.findElements(By.tagName("a"));
        System.out.println(el.size());
        System.out.println("***************************");
        Predicate<WebElement> isBlank =(e)->e.getText().trim().length()==0 ;
        el.removeIf(isBlank);
        System.out.println(el.size());
        el.forEach(el1-> System.out.println(el1.getText()));
        Predicate<WebElement> contains =(e)->e.getText().contains("S") ;
        el.removeIf(contains);
        el.forEach(el1-> System.out.println(el1.getText()));
    }
}
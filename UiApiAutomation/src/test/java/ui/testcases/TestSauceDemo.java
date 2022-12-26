package ui.testcases;

import com.creditdatamw.zerocell.Reader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import ui.browser.DriverManager;
import ui.browser.DriverManagerFactory;
import ui.browser.DriverType;
import ui.excelreader.DataModel;

import java.io.File;
import java.util.List;



public class TestSauceDemo {
    DriverManager driverManager;
    WebDriver driver;
    private List<DataModel> dataModels ;



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

    @Test(dataProvider = "getData")
    public void CheckingTest(DataModel data) {
        driver.get(data.getURL());
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(data.getUsername());
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(data.getPassword());
        driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
        driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();

    }
    @DataProvider
    public static Object[][] getData(){

        return (Object[][])Reader.
                of(DataModel.class).
                from(new File(
                        System.getProperty("user.dir") + "/src/main/resources/testdata/TestData.xlsx"
                ))
                .sheet("Sheet1") //sheet name to read
                .skipHeaderRow(true) //skipping headers
                .list().toArray();
    }

}

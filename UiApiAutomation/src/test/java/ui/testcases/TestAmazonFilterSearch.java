package ui.testcases;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestAmazonFilterSearch {
    private static final Logger logger = LoggerFactory.getLogger(TestAmazonFilterSearch.class);
    DriverManager driverManager;
    WebDriver driver;
    private GoogleSearchPage googlesSearchPage;
    private AmazonHomePage amazonHomePage;
    private DellComputerPage dellComputerPage;

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
    public void filterPriceTest() throws InterruptedException {
        GoogleSearchPage.using(driver)
                .goToGoogle()
                .setSearchText("amazon")
                .goToAmazon();
        AmazonHomePage.using(driver)
                .setSearchText("dell computers");
        DellComputerPage.using(driver)
                .setSearchText("30000", "50000")
                .goToSecondSearchPage();

        List<WebElement> allProductPrice = DellComputerPage.getAllProductPrice();
        for (WebElement product : allProductPrice) {
            String price = product.getText();
            int actualprice = Integer.parseInt(price.replace(",", ""));
            assertThat(actualprice)
                    .isLessThan(60000);

        }

    }
}
package ui.pages;

import api.apiconfigreader.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GoogleSearchPage {
    private static final Logger logger = LoggerFactory.getLogger(GoogleSearchPage.class);
    private final WebDriver driver;

    @FindBy(xpath = "//input[@title='Search']")
    private WebElement searchText;


    @FindBy(xpath = "//h3[normalize-space()='Amazon.in']")
    private WebElement amazonLink;


    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static GoogleSearchPage using(WebDriver driver) {
        return new GoogleSearchPage(driver);
    }

    public GoogleSearchPage goToGoogle() {
        driver.get(ConfigReader.getValue("GOOGLE_URL"));
        logger.info("Go To google");
        return this;
    }

    public GoogleSearchPage setSearchText(String textSearch) {
        this.searchText.sendKeys(textSearch);
        logger.info("Search Text");
        searchText.submit();
        logger.info("Submit");
        return this;
    }

    public void goToAmazon() {
        this.amazonLink.click();
        logger.info("Click on amazonLink");
    }

}

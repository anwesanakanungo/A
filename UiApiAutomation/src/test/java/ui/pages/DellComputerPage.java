package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class DellComputerPage {
    private static final Logger logger = LoggerFactory.getLogger(DellComputerPage.class);
    @FindBys({
            @FindBy(xpath = "//span[contains(text(),'5.0 out of 5 stars')]")
    })
    public static List<WebElement> allsStarRatingProduct;
    @FindBys({
            @FindBy(className = "a-price-whole")
    })
    public static List<WebElement> allProductPrice;
    private final WebDriver driver;
    @FindBy(id = "low-price")
    private WebElement lowPrice;
    @FindBy(id = "high-price")
    private WebElement highPrice;
    @FindBy(xpath = "//input[@class='a-button-input']")
    private WebElement goButton;
    @FindBy(xpath = "//input[@class='a-button-input']")
    private WebElement secondPageButton;

    public DellComputerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static DellComputerPage using(WebDriver driver) {
        return new DellComputerPage(driver);
    }

    public static List<WebElement> getAllProductPrice() {
        return allProductPrice;

    }

    public DellComputerPage setSearchText(String LowPrice, String HighPrice) {
        lowPrice.sendKeys(LowPrice);
        logger.info("Enter low price");
        highPrice.sendKeys(HighPrice);
        logger.info("Enter High price");
        return this;
    }

    public void goToSecondSearchPage() {
        this.secondPageButton.click();
    }
}

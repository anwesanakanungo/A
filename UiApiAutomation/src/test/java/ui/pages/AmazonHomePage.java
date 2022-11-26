package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ui.uiutil.WebDriverWrapperUtil;

public class AmazonHomePage {
    private static final Logger logger = LoggerFactory.getLogger(AmazonHomePage.class);
    private final WebDriver driver;

    @FindBy(id = "searchDropdownBox")
    private WebElement amazonDropDown;


    @FindBy(id = "twotabsearchtextbox")
    private WebElement amazonSearch;


    public AmazonHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static AmazonHomePage using(WebDriver driver) {
        return new AmazonHomePage(driver);
    }

    public AmazonHomePage setSearchText(String textSearch) {
        WebDriverWrapperUtil.selectItemFromDropdown(amazonDropDown, "Electronics");
        logger.info("select items from Electronics");
        amazonSearch.sendKeys(textSearch);
        logger.info("search Dell computer");
        amazonSearch.submit();
        logger.info("click on ENTER");
        return this;
    }

}

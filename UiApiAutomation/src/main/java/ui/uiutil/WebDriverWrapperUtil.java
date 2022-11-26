package ui.uiutil;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class WebDriverWrapperUtil {

    public static void mouseHover(WebDriver driver, WebElement element) {
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(element);
            actions.perform();
        } catch (NoSuchElementException nse) {
            System.out.println("Cannot mouse hover to element");
        }
    }

    public static void rightClick(WebDriver driver, WebElement element) {
        try {
            Actions actions = new Actions(driver);
            actions.contextClick(element);
            actions.perform();
        } catch (NoSuchElementException nse) {
            System.out.println("Cannot right click on element");
        }
    }

    public static void doubleClick(WebDriver driver, WebElement element) {
        try {
            Actions actions = new Actions(driver);
            actions.doubleClick(element);
            actions.perform();
        } catch (NoSuchElementException nse) {
            System.out.println("Cannot double click on element");
        }
    }

    public static WebElement getBranchStaffTableActionElement
            (WebElement webTable, Map<String, String> map) {
        try {
            List<WebElement> rows = webTable.findElements(By.tagName("tr"));
            System.out.println("Found " + rows.size() + " rows in the table");
            for (int i = 0; i < rows.size(); i++) {
                List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
                System.out.println("Found " + columns.size() + " columns in the table");
                if (columns.size() == 0) {
                    continue;
                }
                if (columns.get(1).getText().equalsIgnoreCase(map.get("Name"))
                        && columns.get(2).getText().equalsIgnoreCase(map.get("Code"))) {
                    if (map.get("Action").equalsIgnoreCase("View")) {
                        return webTable.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[4]/table/tbody/tr[" + (i) + "]/td[4]/button[1]"));
                    } else if (map.get("Action").equalsIgnoreCase("Edit")) {
                        return webTable.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[4]/table/tbody/tr[" + (i) + "]/td[4]/button[2]"));
                    } else {
                        return webTable.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[4]/table/tbody/tr[" + (i) + "]/td[4]/button[3]"));

                    }
                }
            }
        } catch (Exception nse) {
            System.out.println("Exception while getting " + map.get("Action") + " button");
        }
        return null;
    }

    public static boolean selectItemFromDropdown(WebElement element, String valueToBeSelected) {
        try {
            Select selectObject = new Select(element);
            selectObject.selectByVisibleText(valueToBeSelected);
        } catch (Exception nse) {
            System.out.println("Exception while selecting item from dropdown");
        }

        return false;
    }

    public static String captureScreenshot(WebDriver driver, String screenshotName) throws Exception {

        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);

        return destination;
    }

}

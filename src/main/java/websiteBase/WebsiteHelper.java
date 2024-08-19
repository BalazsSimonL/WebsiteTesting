package websiteBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebsiteHelper {

    public static void waitUntilWebElementIsClickable(WebElement webElement, WebDriverWait wait, WebDriver driver){
        wait.until(ExpectedConditions.visibilityOf(webElement));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
    public static void waitUntilWebElementIsVisible(WebElement webElement, WebDriverWait wait, WebDriver driver){
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }
}


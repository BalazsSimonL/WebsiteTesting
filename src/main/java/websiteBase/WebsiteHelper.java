package websiteBase;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class WebsiteHelper {

    public static void withCustomImplicitWait(WebDriver driver, Duration customDuration, VoidFunction function){
        driver.manage().timeouts().implicitlyWait(customDuration);
        function.execute();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public static boolean isPresent(WebDriver driver, WebElement element) {
        AtomicBoolean isPresent = new AtomicBoolean(false);
        withCustomImplicitWait(driver, Duration.ofSeconds(0), () -> {
            try {
                element.isDisplayed();
                isPresent.set(true);
            } catch (NoSuchElementException | StaleElementReferenceException e){
                isPresent.set(false);
            }
        });
        return isPresent.get();
    }

    public static void delay(int sleepDuration) {
        try {
            Thread.sleep((long)sleepDuration * 1000L);
        } catch (InterruptedException var2) {
            var2.printStackTrace();
        }

    }

    public static void retryIfExceptionThrown(long attemptLimit, VoidFunction retryFunction){
        int attempts = 1;
        while (attempts <= attemptLimit){
            try {
                retryFunction.execute();
                return;
            } catch (Exception e){
                System.out.println("Exception catched: " + e);
            }
        }

    }

    public static void retryIfExceptionThrown(VoidFunction retryFunction){
        retryIfExceptionThrown(3, retryFunction);
    }

    /**
     * An expectation for checking that the given element has the same location and dimension between two calls,
     * so it does not have any animation, nor moved and is still attached to the DOM.
     * Use as wait.until parameter.
     * @param element the WebElement
     * @return true once the checked element has same dimension and Location between two calls, meaning it is steady, and attached to the DOM.
     */
    public static ExpectedCondition<Boolean> steadinessOf(final WebElement element, WebDriver driver){
        return new ExpectedCondition<Boolean>() {

            private WebElement lastElement = null;
            private Point lastLocation = null;
            private Dimension lastDimension = null;

            @Override
            public Boolean apply(WebDriver driver) {
                if (lastElement == null){
                    lastElement = element;
                }
                try {
                    if (isPresent(driver, lastElement)){
                        Point location = lastElement.getLocation();
                        Dimension dimension = lastElement.getRect().getDimension();
                        if (location.equals(lastLocation) && dimension.equals(lastDimension)){
                            return true;
                        }
                        lastLocation = location;
                        lastDimension = dimension;
                    }
                }catch (StaleElementReferenceException e){
                    lastElement = null;
                }

                return false;
            }
            @Override
            public String toString(){
                return "stadiness of element: " + element;
            }
        };
    }

    /**
     * Wait for WebElement to become visible
     * @param webElement expected WebElement
     * @param attemptLimit Number of attempts (long)
     * @param wait WebDriverWait
     */
    public static void waitUntilWebElementIsVisible(WebElement webElement, long attemptLimit, WebDriverWait wait, WebDriver driver){
        retryIfExceptionThrown(attemptLimit, () -> {
            wait.until(steadinessOf(webElement, driver));
            wait.until(ExpectedConditions.visibilityOf(webElement));
        });
    }

    /**
     * Wait for WebElement to become visible
     * @param webElement expected WebElement
     * @param wait WebDriverWait
     */
    public static void waitUntilWebElementIsVisible(WebElement webElement, WebDriverWait wait, WebDriver driver){
        waitUntilWebElementIsVisible(webElement, 3L, wait, driver);
    }


    /**
     * Wait for WebElement to become clickable
     * @param webElement expected WebElement
     * @param attemptLimit Number of attempts (long)
     * @param wait WebDriverWait
     */
    public static void waitUntilWebElementIsClickable(WebElement webElement, long attemptLimit, WebDriverWait wait, WebDriver driver){
        retryIfExceptionThrown(attemptLimit, () -> {
            wait.until(steadinessOf(webElement, driver));
            wait.until(ExpectedConditions.visibilityOf(webElement));
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
        });
    }

    /**
     * Wait for WebElement to become clickable
     * @param webElement expected WebElement
     * @param wait WebDriverWait
     */
    public static void waitUntilWebElementIsClickable(WebElement webElement, WebDriverWait wait, WebDriver driver){
        waitUntilWebElementIsClickable(webElement, 3L, wait, driver);
    }

    //public static void waitUntilWebElementIsVisible(List<WebElement> tableBodyRowTable) {

}


package websitePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import websiteBase.WebsiteHelper;




public class HomePage {

    public WebDriver driver;
    public WebDriverWait wait;

    public HomePage(WebDriver driver) {
    }
    @FindBy(xpath = "//button[@id='logout']")
    public WebElement logout;

    public void logoutButton() {
        WebsiteHelper.waitUntilWebElementIsVisible(logout, wait, driver);
    }
}

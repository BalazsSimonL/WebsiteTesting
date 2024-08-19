package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import websiteBase.TestData;
import websiteBase.WebsiteUI;

import java.time.Duration;

public class CustomerTest {

    public WebDriver driver;
    public WebsiteUI ui;
    public WebDriverWait wait;

    @BeforeMethod
    public void before() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-search-engine-choice-screen");
        this.driver = new ChromeDriver(options);
        this.ui = new WebsiteUI(this.driver);
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));

        Alert alert = driver.switchTo().alert();
    }

    @Test
    public void deleteCustomer(){
        ui.loginPage.openWebsite();
        ui.loginPage.loginWebsite();
    }
}

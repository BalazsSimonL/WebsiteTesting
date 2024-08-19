package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import websiteBase.TestData;
import websiteBase.WebsiteHelper;
import websiteBase.WebsiteUI;

import java.time.Duration;

public class LoginTest {

    public WebDriver driver;
    public WebsiteUI ui;
    public WebDriverWait wait;
    public TestData testData;

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


    }

    @Test
    public void loginWebsite() {
        ui.loginPage.openWebsite();
        ui.loginPage.loginWebsite("test.21@gmail.com", "test1234");
        WebsiteHelper.waitUntilWebElementIsVisible(ui.homePage.tableBodyRowTable, wait, driver);
        Assert.assertTrue(ui.homePage.logoutButton.isDisplayed());
        ui.homePage.clickToLogoutButton();
        WebsiteHelper.waitUntilWebElementIsVisible(ui.loginPage.loginButton, wait, driver);
        Assert.assertTrue(ui.loginPage.linkToAPIDocumentation.isDisplayed());
    }

    @AfterMethod
    public void after() {
        driver.quit();
    }

}


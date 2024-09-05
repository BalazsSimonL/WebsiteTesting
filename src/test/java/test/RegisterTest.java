package test;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import websiteBase.DTO;
import websiteBase.WebsiteHelper;
import websiteBase.WebsiteUI;

import java.time.Duration;

public class RegisterTest {


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

    }

    @Test
    public void signUpOnWebsite() {
        ui.loginPage.openWebsite();
        ui.loginPage.clickToSignUpButton();
        DTO customer = DTO.createCustomerDTO();
        ui.registerPage.createANewAccount(customer);
        Assert.assertTrue(ui.homePage.logoutButton.isDisplayed());
        WebsiteHelper.waitUntilWebElementIsVisible(ui.homePage.addContactButton, wait, driver);
        ui.homePage.clickToLogoutButton();
        WebsiteHelper.waitUntilWebElementIsVisible(ui.loginPage.linkToAPIDocumentation, wait, driver);
        ui.loginPage.loginWebsite("test.21@gmail.com" , "test1234");
        System.out.println(customer.getEmail());
        System.out.println(customer.getPassword());
        WebsiteHelper.waitUntilWebElementIsClickable(ui.homePage.logoutButton, wait, driver);
        Assert.assertTrue(ui.homePage.addContactButton.isDisplayed());
    }

    @AfterMethod
    public void after() {
        driver.quit();
    }
}


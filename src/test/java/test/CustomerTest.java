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
import websiteBase.TestData;
import websiteBase.UserDTO;
import websiteBase.WebsiteUI;
import websitePages.HomePage;

import java.text.SimpleDateFormat;
import java.time.Duration;


public class CustomerTest {

    public WebDriver driver;
    public WebsiteUI ui;
    public WebDriverWait wait;
    public HomePage homePage;
    Faker faker = new Faker();

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
    public void addCustomer() {
        ui.loginPage.openWebsite();
        UserDTO user = TestData.getUser();
        ui.loginPage.loginWebsite(user);
        ui.homePage.clickToAddNewContactButton();

        // Generate fake data
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String date = new SimpleDateFormat("yyyy-MM-dd").format(faker.date().birthday());
        String email = faker.internet().emailAddress();
        String phoneNumber = faker.numerify("###########");
        String streetAddress1 = faker.address().streetAddress();
        String streetAddress2 = faker.address().streetAddress();
        String city = faker.address().city();
        String stateOfProvince = faker.address().state();
        String postalCode = faker.address().zipCode();
        String country = faker.address().country();


        // Store data in TestData
        ui.addContactPage.fillAddCustomerInformation(firstName, lastName, email, date, phoneNumber, streetAddress1, streetAddress2, city, stateOfProvince, postalCode, country);

        Assert.assertTrue(ui.homePage.customerdatatablerow.isDisplayed());
        String tableText = ui.homePage.customerdatatablerow.getText();
        Assert.assertTrue(tableText.contains(firstName));
        ui.homePage.clickToLogoutButton();
    }
    @AfterMethod
    public void after(){
        driver.quit();
    }
}

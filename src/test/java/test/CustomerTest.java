package test;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
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
import websitePages.AddContactPage;
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

        //Alert alert = driver.switchTo().alert();
    }

    @Test
    public void addCustomer() {
        ui.loginPage.openWebsite();
        ui.loginPage.loginWebsite("test.21@gmail.com", "test1234");
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
        TestData.firstName = firstName;
        TestData.lastName = lastName;
        TestData.email = email;
        TestData.date = date;
        TestData.phoneNumber = phoneNumber;
        TestData.streetAddress1 = streetAddress1;
        TestData.streetAddress2 = streetAddress2;
        TestData.city = city;
        TestData.stateOfProvince = stateOfProvince;
        TestData.postalCode = postalCode;
        TestData.country = country;


        ui.addContactPage.fillAddCustomerInformation(firstName, lastName, email, date, phoneNumber, streetAddress1, streetAddress2, city, stateOfProvince, postalCode, country);
        Assert.assertFalse(ui.addContactPage.addContactErrorMessage.isDisplayed());

        Assert.assertTrue(ui.homePage.tableBodyRowTable.isDisplayed());
        String tableText = ui.homePage.tableBodyRowTable.getText();
        Assert.assertTrue(tableText.contains(firstName));
        ui.homePage.clickToLogoutButton();
    }
    @AfterMethod
    public void after(){
        driver.quit();
    }
}

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
import websiteBase.CustomerDTO;
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
        if (TestData.getUser() == null) {
            UserDTO user = new UserDTO("", "lastName", "test.21@gmail.com", "test1234");
            TestData.setUser(user);}

    }

    @Test
    public void addCustomer() {
        ui.loginPage.openWebsite();
        UserDTO user = TestData.getUser();
        ui.loginPage.loginWebsite(user);
        ui.homePage.clickToAddNewContactButton();

        CustomerDTO customer = new CustomerDTO(faker.name().firstName(), faker.name().lastName(),faker.internet().emailAddress(),  new SimpleDateFormat("yyyy-MM-dd").format(faker.date().birthday()), faker.numerify("###########"), faker.address().streetAddress(), faker.address().streetAddress(), faker.address().city(), faker.address().state(), faker.address().zipCode(), faker.address().country());

        ui.addContactPage.fillAddCustomerInformation(customer);

        Assert.assertTrue(ui.homePage.customerdatatablerow.isDisplayed());
        String tableText = ui.homePage.customerdatatablerow.getText();
        Assert.assertTrue(tableText.contains(customer.getFirstName()));
        ui.homePage.clickToLogoutButton();
    }
    @AfterMethod
    public void after(){
        driver.quit();
    }
}

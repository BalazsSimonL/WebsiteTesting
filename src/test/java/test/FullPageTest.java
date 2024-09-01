package test;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import websiteBase.UserDTO;
import websiteBase.WebsiteUI;
import websitePages.HomePage;

import java.time.Duration;
import java.text.SimpleDateFormat;

public class FullPageTest {

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
    public void fullPageTest(){
        ui.loginPage.openWebsite();

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String password = faker.internet().password();
        String date = new SimpleDateFormat("yyyy-MM-dd").format(faker.date().birthday());
        String email = faker.internet().emailAddress();
        String phoneNumber = faker.numerify("###########");
        String streetAddress1 = faker.address().streetAddress();
        String streetAddress2 = faker.address().streetAddress();
        String city = faker.address().city();
        String stateOfProvince = faker.address().state();
        String postalCode = faker.address().zipCode();
        String country = faker.address().country();

        //UserDTO user = new UserDTO(email, password, firstName, date, lastName, phoneNumber, streetAddress1, streetAddress2, city, stateOfProvince, postalCode, country);

        //ui.registerPage.createANewAccount();
    }
    }

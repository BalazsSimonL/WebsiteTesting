package websitePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import websiteBase.DTO;
import websiteBase.WebsiteHelper;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;
    public DTO testData;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //region elements

    /**
     * Login Page Email Field
     **/
    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailInput;

    /**
     * Login Page Password Field
     **/
    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordInput;

    /**
     * Login Button
     **/
    @FindBy(xpath = "//button[@id='submit']")
    public WebElement loginButton;

    /**
     * Register Button
     **/
    @FindBy(xpath = "//button[@id='signup']")
    public WebElement registerButton;

    /**
     * API documentation link
     */
    @FindBy(xpath = "//a[text()='here']")
    public WebElement linkToAPIDocumentation;

    //endregion

    //region element functions

    /**
     * Click the login button
     **/
    public void clickToLoginButton() {
        WebsiteHelper.waitUntilWebElementIsClickable(loginButton, wait, driver);
        loginButton.click();
    }

    /**
     * Click to Sign Up button
     */
    public void clickToSignUpButton() {
        WebsiteHelper.waitUntilWebElementIsClickable(registerButton, wait, driver);
        registerButton.click();
    }

    /**
     * Fill in the email field
     **/
    public void fillEmailInput(String email) {
        WebsiteHelper.waitUntilWebElementIsVisible(emailInput, wait, driver);
        emailInput.sendKeys(email);
    }

    /**
     * Fill in the password field
     **/
    public void fillPasswordInput(String password) {
        WebsiteHelper.waitUntilWebElementIsVisible(passwordInput, wait, driver);
        passwordInput.sendKeys(password);
    }

//endregion

//region other functions

    /**
     * Open the website
     **/
    public void openWebsite() {
        driver.get("https://thinking-tester-contact-list.herokuapp.com/");
    }

    /**
     * Login in to the Website
     *
     * @param email    String email
     * @param password String password
     */
    public void loginWebsite(String email, String password) {
        fillEmailInput(email);
        fillPasswordInput(password);
        clickToLoginButton();
    }
//endregion
}
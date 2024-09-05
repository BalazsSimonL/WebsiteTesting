package websitePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import websiteBase.DTO;
import websiteBase.WebsiteHelper;

import java.time.Duration;

public class RegisterPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //region elements

    /**
     * Add User Header
     **/
    @FindBy(xpath = "/html/body/div/h1")
    public WebElement addUserHeader;

    /**
     * First Name Field
     **/
    @FindBy(xpath = "//*[@id=\"firstName\"]")
    public WebElement firstNameField;

    /**
     * Last Name Field
     **/
    @FindBy(xpath = "//*[@id=\"lastName\"]")
    public WebElement lastNameField;

    /**
     * Email Field
     **/
    @FindBy(xpath = "//*[@id=\"email\"]")
    public WebElement emailField;

    /**
     * Password Field
     **/
    @FindBy(xpath = "//*[@id=\"password\"]")
    public WebElement passwordField;

    /**
     * Submit Button
     **/
    @FindBy(xpath = "//*[@id='submit']")
    public WebElement submitButton;

    /**
     * Cancel Button
     **/
    @FindBy(xpath = "//*[@id='cancel']")
    public WebElement cancelButton;

    //endregion

    //region elements functions

    /**
     * Header is visible
     **/
    public void headerVisible() {
        WebsiteHelper.waitUntilWebElementIsVisible(addUserHeader, wait, driver);
    }

    /**
     * Click Submit button
     **/
    public void clickOnSubmitButton() {
        WebsiteHelper.waitUntilWebElementIsClickable(submitButton, wait, driver);
        submitButton.click();
    }

    /**
     * Click on Cancel Button
     **/
    public void clickOnCancelButton() {
        WebsiteHelper.waitUntilWebElementIsClickable(cancelButton, wait, driver);
        cancelButton.click();
    }


    /**
     * Fill First Name Field
     **/
    public void fillFirstNameField(String value) {
        WebsiteHelper.waitUntilWebElementIsVisible(firstNameField, wait, driver);
        firstNameField.sendKeys(value);
    }

    /**
     * Fill Last Name Field
     **/
    public void fillLastNameField(String value) {
        WebsiteHelper.waitUntilWebElementIsVisible(lastNameField, wait, driver);
        lastNameField.sendKeys(value);
    }

    /**
     * Fill Email Field
     **/
    public void fillEmailField(String value) {
        WebsiteHelper.waitUntilWebElementIsVisible(emailField, wait, driver);
        emailField.sendKeys(value);
    }

    /**
     * Fill Password Field
     **/
    public void fillPasswordField(String value) {
        WebsiteHelper.waitUntilWebElementIsVisible(passwordField, wait, driver);
        passwordField.sendKeys(value);
    }

//endregion

//other region elements functions

    /**
     * Fill User Information
     * //@param firstName String firstName
     * //@param lastName  String lastName
     * //@param email     String email
     * //@param password  String password
     **/

    public void createANewAccount(DTO user) {
        fillFirstNameField(user.getFirstName());
        fillLastNameField(user.getLastName());
        fillEmailField(user.getEmail());
        fillPasswordField(user.getPassword());
        clickOnSubmitButton();
    }

    public void cancelSignUp() {
        WebsiteHelper.waitUntilWebElementIsVisible(cancelButton, wait, driver);
        cancelButton.click();
    }

//endregion
}
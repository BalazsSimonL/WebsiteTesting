package websitePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import websiteBase.DTO;
import websiteBase.WebsiteHelper;
import java.time.Duration;

public class AddContactPage {

    private WebDriver driver;
    private WebDriverWait wait;
    public HomePage homePage;

    public AddContactPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //region elements

    /**
     * Add Contact First Name Field
     **/
    @FindBy(xpath = "//input[@id='firstName']")
    public WebElement addContactFirstNameField;

    /**
     * Add Contact Last Name Field
     **/
    @FindBy(xpath = "//input[@id='lastName']")
    public WebElement addContactLastNameField;

    /**
     * Add Contact Date Of Birth Field
     **/
    @FindBy(xpath = "//input[@id='birthdate']")
    public WebElement addContactDateOfBirthField;

    /**
     * Add Contact Email Field
     **/
    @FindBy(xpath = "//input[@id='email']")
    public WebElement addContactEmailField;

    /**
     * Add Contact Phone Number Field
     **/
    @FindBy(xpath = "//input[@id='phone']")
    public WebElement addContactPhoneNumberField;

    /**
     * Add Contact Street Address 1 Field
     **/
    @FindBy(xpath = "//input[@id='street1']")
    public WebElement addContactStreetAddress1Field;

    /**
     * Add Contact Street Address 2 Field
     **/
    @FindBy(xpath = "//input[@id='street2']")
    public WebElement addContactStreetAddress2Field;

    /**
     * Add Contact City Field
     **/
    @FindBy(xpath = "//input[@id='city']")
    public WebElement addContactCityField;

    /**
     * Add Contact State Of Province Field
     **/
    @FindBy(xpath = "//input[@id='stateProvince']")
    public WebElement addContactStateOfProvinceField;

    /**
     * Add Contact Postal Code Field
     **/
    @FindBy(xpath = "//input[@id='postalCode']")
    public WebElement addContactPostalCodeField;

    /**
     * Add Contact Country Field
     **/
    @FindBy(xpath = "//input[@id='country']")
    public WebElement addContactCountryField;

    /**
     * Add Contact Submit Button
     **/
    @FindBy(xpath = "//button[@id='submit']")
    public WebElement addContactSubmitButton;

    /**
     * Add Contact Cancel Button
     **/
    @FindBy(xpath = "//button[@id='cancel']")
    public WebElement addContactCancelButton;

    /**
     * Add Contact Logout Button
     **/
    @FindBy(xpath = "//button[@id='logout']")
    public WebElement addContactLogoutButton;

    /**
     * Error message
     **/
    @FindBy(xpath = "//*[@id=\"error\"]")
    public WebElement addContactErrorMessage;


    //endregion

    //region element functions

    /**
     * Fill First Name Field
     **/
    public void fillFirstNameField(String value) {
        WebsiteHelper.waitUntilWebElementIsVisible(addContactFirstNameField, wait, driver);
        addContactFirstNameField.sendKeys(value);
    }

    /**
     * Fill Last Name Field
     **/
    public void fillLastNameField(String value) {
        WebsiteHelper.waitUntilWebElementIsVisible(addContactLastNameField, wait, driver);
        addContactLastNameField.sendKeys(value);
    }

    /**
     * Fill Date Of Birth Field
     **/
    public void fillDateOfBirthField(String value) {
        WebsiteHelper.waitUntilWebElementIsVisible(addContactDateOfBirthField, wait, driver);
        addContactDateOfBirthField.sendKeys(value);
    }

    /**
     * Fill Email Field
     **/
    public void fillEmailField(String value) {
        WebsiteHelper.waitUntilWebElementIsVisible(addContactEmailField, wait, driver);
        addContactEmailField.sendKeys(value);
    }

    /**
     * Fill Phone Number Field
     **/
    public void fillPhoneNumberField(String value) {
        WebsiteHelper.waitUntilWebElementIsVisible(addContactPhoneNumberField, wait, driver);
        addContactPhoneNumberField.sendKeys(value);
    }

    /**
     * Fill Street Address 1 Field
     **/
    public void fillStreetAddress1Field(String value) {
        WebsiteHelper.waitUntilWebElementIsVisible(addContactStreetAddress1Field, wait, driver);
        addContactStreetAddress1Field.sendKeys(value);
    }

    /**
     * Fill Street Address 2 Field
     **/
    public void fillStreetAddress2Field(String value) {
        WebsiteHelper.waitUntilWebElementIsVisible(addContactStreetAddress2Field, wait, driver);
        addContactStreetAddress2Field.sendKeys(value);
    }

    /**
     * Fill City Field
     **/
    public void fillCityField(String value) {
        WebsiteHelper.waitUntilWebElementIsVisible(addContactCityField, wait, driver);
        addContactCityField.sendKeys(value);
    }

    /**
     * Fill State Of Province Field
     **/
    public void fillStateOfProvinceField(String value) {
        WebsiteHelper.waitUntilWebElementIsVisible(addContactStateOfProvinceField, wait, driver);
        addContactStateOfProvinceField.sendKeys(value);
    }

    /**
     * Fill Postal Code Field
     **/
    public void fillPostalCodeField(String value) {
        WebsiteHelper.waitUntilWebElementIsVisible(addContactPostalCodeField, wait, driver);
        addContactPostalCodeField.sendKeys(value);
    }

    /**
     * Fill Country Field
     **/
    public void fillCountryField(String value) {
        WebsiteHelper.waitUntilWebElementIsVisible(addContactCountryField, wait, driver);
        addContactCountryField.sendKeys(value);
    }

    /**
     * Click on Submit Button
     **/
    public void clickOnSubmitButton() {
        WebsiteHelper.waitUntilWebElementIsClickable(addContactSubmitButton, wait, driver);
        addContactSubmitButton.click();
    }

    /**
     * Click On Cancel Button
     **/
    public void clickOnCancelButton() {
        WebsiteHelper.waitUntilWebElementIsClickable(addContactCancelButton, wait, driver);
        addContactCancelButton.click();
    }

    /**
     * Click on Logout Button
     **/
    public void clickOnLogoutButton() {
        WebsiteHelper.waitUntilWebElementIsClickable(addContactLogoutButton, wait, driver);
        addContactLogoutButton.click();
    }


    //endregion

    //other region elements functions

    /**
     * Fill Customer Information
     * //@param firstName       String firstName
     * //@param lastName        String lastName
     * //@param email           String email
     * //@param date String date
     * //@param phoneNumber     String phoneNumber
     * //@param streetAddress1  String streetAddress1
     * //@param streetAddress2  String streetAddress2
     * //@param city            String city
     * //@param stateOfProvince String stateOfProvince
     * //@param postalCode      String postalCode
     * //@param country         String country
     **/

    public void fillAddCustomerInformation(DTO createCustomerDTO) {
        WebsiteHelper.waitUntilWebElementIsClickable(addContactLogoutButton, wait, driver);
        fillFirstNameField(createCustomerDTO.getFirstName());
        fillLastNameField(createCustomerDTO.getLastName());
        fillEmailField(createCustomerDTO.getEmail());
        fillDateOfBirthField(createCustomerDTO.getDate());
        fillPhoneNumberField(createCustomerDTO.getPhoneNumber());
        fillStreetAddress1Field(createCustomerDTO.getStreetAddress1());
        fillStreetAddress2Field(createCustomerDTO.getStreetAddress2());
        fillCityField(createCustomerDTO.getCity());
        fillStateOfProvinceField(createCustomerDTO.getStateOfProvince());
        fillPostalCodeField(createCustomerDTO.getPostalCode());
        fillCountryField(createCustomerDTO.getCountry());
        clickOnSubmitButton();
    }
    public void stopAddCustomerInformation(){
        homePage.addContactButton.click();
        WebsiteHelper.waitUntilWebElementIsClickable(addContactCancelButton, wait, driver);
        clickOnCancelButton();
    }
    public void logoutFromAddCustomerInformation(){
        homePage.addContactButton.click();
        WebsiteHelper.waitUntilWebElementIsClickable(addContactLogoutButton, wait, driver);
        clickOnLogoutButton();
    }

    //endregion
}

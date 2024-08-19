package websitePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddContactPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public AddContactPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //region elements

    /** Add Contact First Name Field**/
    @FindBy(xpath = "//input[@id='firstName']")
    public WebElement addContactFirstNameField;

    /** Add Contact Last Name Field**/
    @FindBy(xpath = "//input[@id='lastName']")
    public WebElement addContactLastNameField;

    /** Add Contact Date Of Birth Field**/
    @FindBy(xpath = "//input[@id='birthdate']")
    public WebElement addContactDateOfBirthField;

    /** Add Contact Email Field**/
    @FindBy(xpath = "//input[@id='email']")
    public WebElement addContactEmailField;

    /** Add Contact Phone Number Field**/
    @FindBy(xpath = "//input[@id='phone']")
    public WebElement addContactPhoneNumberField;

    /** Add Contact Street Address 1 Field**/
    @FindBy(xpath = "//input[@id='street1']")
    public WebElement addContactStreetAddress1Field;

    /** Add Contact Street Address 2 Field**/
    @FindBy(xpath = "//input[@id='street2']")
    public WebElement addContactStreetAddress2Field;

    /** Add Contact City Field**/
    @FindBy(xpath = "//input[@id='city']")
    public WebElement addContactCityField;

    /** Add Contact State Of Province Field**/
    @FindBy(xpath = "//input[@id='stateProvince']")
    public WebElement addContactStateOfProvinceField;

    /** Add Contact Postal Code Field**/
    @FindBy(xpath = "//input[@id='postalCode']")
    public WebElement addContactPostalCodeField;

    /** Add Contact Country Field**/
    @FindBy(xpath = "//input[@id='country']")
    public WebElement addContactCountryField;

    /** Add Contact Submit Button **/
    @FindBy(xpath = "//button[@id='submit']")
    public WebElement addContactSubmitButton;

    /** Add Contact Cancel Button **/
    @FindBy(xpath = "//button[@id='cancel']")
    public WebElement addContactCancelButton;

    /** Add Contact Logout Button **/
    @FindBy(xpath = "//button[@id='logout']")
    public WebElement addContactLogoutButton;


    //endregion
}

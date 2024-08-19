package websitePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactDetailsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public ContactDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //region elements

    /** Contact Details Edit Contact Button **/
    @FindBy(xpath = "//button[@id='edit-contact']")
    public WebElement contactDetailsEditContactButton;

    /** Contact Details Delete Contact Button **/
    @FindBy(xpath = "//button[@id='edit-contact']")
    public WebElement contactDetailsDeleteContactButton;

    /** Contact Details Return To Contact List Button**/
    @FindBy(xpath = "//button[@id='return']")
    public WebElement contactDetailsReturnToContactListButton;

    /** Contact Details Logout Button **/
    @FindBy(xpath = "//button[@id='logout']")
    public WebElement contactDetailsLogoutButton;

    /** Contact Details First Name Information **/
    @FindBy(xpath = "//span[@id='firstName']")
    public WebElement contactDetailsFirstNameFieldInformation;

    /** Contact Details Delete Contact Pop-Up Button OK **/

    //endregion
}
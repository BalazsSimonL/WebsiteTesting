package websitePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import websiteBase.WebsiteHelper;

import java.time.Duration;
import java.util.List;


public class HomePage {

    public WebDriver driver;
    public WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

   //region elements

    /**
     * Logout button
     **/
    @FindBy(xpath = "//*[@id=\"logout\"]")
    public WebElement logoutButton;

    /**
     * Add-contact button
     **/
    @FindBy(xpath = "//*[@id=\"add-contact\"]")
    public WebElement addContactButton;

    /**
     * Name field in the Table
     **/
    @FindBy(xpath = "//*[@id=\"myTable\"]/tr/td[2]")
    public WebElement tableName;

    /**
     * Birthdate field in the Table
     **/
    @FindBy(xpath = "//*[@id=\"myTable\"]/tr/td[3]")
    public WebElement tableBirthdate;

    /**
     * Email field in the Table
     **/
    @FindBy(xpath = "//*[@id=\"myTable\"]/tr/td[4]")
    public WebElement tableEmail;

    /**
     * Phone field in the Table
     **/
    @FindBy(xpath = "//*[@id=\"myTable\"]/tr/td[5]")
    public WebElement tablePhone;

    /**
     * Address field in the Table
     **/
    @FindBy(xpath = "//*[@id=\"myTable\"]/tr/td[6]")
    public WebElement tableAddress;

    /**
     * City,State field in the Table
     **/
    @FindBy(xpath = "//*[@id=\"myTable\"]/tr/td[7]")
    public WebElement tableCityPostal;

    /**
     * Country field in the Table
     **/
    @FindBy(xpath = "//*[@id=\"myTable\"]/tr/td[8]")
    public WebElement tableCountry;

    /**
     * Table
     **/
    @FindBy(xpath = "//*[@class='contactTableBodyRow']")
    public WebElement tableBodyRowTable;

    //endregion

    //region element functions

    /** Click on Logout Button **/

    public void clickToLogoutButton() {
        WebsiteHelper.waitUntilWebElementIsClickable(logoutButton, wait, driver);
        logoutButton.click();
    }
    /** Click on Add-new contact **/
    public void clickToAddNewContactButton(){
        WebsiteHelper.waitUntilWebElementIsClickable(addContactButton, wait, driver);
        addContactButton.click();
    }
    /** Table Contact is visible **/
    public void tableContactsAreVisible(){
        WebsiteHelper.waitUntilWebElementIsVisible(tableBodyRowTable, wait, driver);
    }
    //endregion

    //region other functions

    //endregion

}

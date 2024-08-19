package websiteBase;

import org.openqa.selenium.WebDriver;
import websitePages.*;

public class WebsiteUI {
    private WebDriver driver;
    public AddContactPage customerPage;
    public EditPage editPage;
    public HomePage homePage;
    public LoginPage loginPage;
    public RegisterPage registerPage;
    public ContactDetailsPage contactDetailsPage;

    public WebsiteUI(WebDriver driver) {
        this.driver = driver;
        this.homePage = new HomePage(driver);
        this.customerPage = new AddContactPage(driver);
        this.editPage = new EditPage(driver);
        this.loginPage = new LoginPage(driver);
        this.registerPage = new RegisterPage(driver);
        this.contactDetailsPage = new ContactDetailsPage(driver);

    }
}

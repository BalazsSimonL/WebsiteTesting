package websiteBase;

import org.openqa.selenium.WebDriver;
import websitePages.CustomerPage;
import websitePages.EditPage;
import websitePages.HomePage;
import websitePages.LoginPage;

public class WebsiteUI {
    private WebDriver driver;
    public CustomerPage customerPage;
    public EditPage editPage;
    public HomePage homePage;
    public LoginPage loginPage;

    public WebsiteUI(WebDriver driver) {
        this.driver = driver;
        this.homePage = new HomePage(driver);
        this.customerPage = new CustomerPage(driver);
        this.editPage = new EditPage(driver);
        this.loginPage = new LoginPage(driver);
    }
}

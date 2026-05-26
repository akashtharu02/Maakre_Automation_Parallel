package test_package;

import org.openqa.selenium.WebDriver;
import pages_package.CustomerSigninPage;

public class LoginHelper {

    private WebDriver driver;

    public LoginHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void login() {
        CustomerSigninPage signIn = new CustomerSigninPage(driver);
        signIn.enterEmail("example@customer.com");
        signIn.enterPassword("pass@123");
        signIn.clickOnSignInButton();
    }
}
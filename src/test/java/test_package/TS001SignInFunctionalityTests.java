package test_package;

import base_package.Base;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages_package.CustomerSigninPage;
import pages_package.Toast_URL_Page;

public class TS001SignInFunctionalityTests extends Base {

    @Test(priority = 1)
    public void TS001_TC002_Valid_Email_and_Password_with_Password_Masked() {
        CustomerSigninPage signIn = new CustomerSigninPage(getDriver());
        Toast_URL_Page popup = new Toast_URL_Page(getDriver());

        signIn.enterEmail("example@customer.com");
        signIn.enterPassword("pass@123");
        signIn.clickOnSignInButton();

        Assert.assertEquals(
                popup.getSuccessMessage(),
                "Logged in successfully",
                "Successfully signed in message is not displayed"
        );
        Assert.assertTrue(
                popup.getPageUrl().contains("/dashboard"),
                "User is not redirected to the dashboard"
        );
    }
    @Test(priority = 2)
    public void TS001_TC003_SigIn_Using_Enter_Button() {
        CustomerSigninPage signIn = new CustomerSigninPage(getDriver());
        Toast_URL_Page popup = new Toast_URL_Page(getDriver());

        signIn.clickEyeIcon();
        signIn.enterEmail("example@customer.com");
        signIn.enterPassword("pass@123");
        signIn.pressEnterKey();


        Assert.assertEquals(
                popup.getSuccessMessage(),
                "Logged in successfully",
                "Successfully signed in message is not displayed 1"
        );

        Assert.assertTrue(popup.getPageUrl().contains("/dashboard"), "User is not redirected to " +
                "the dashboard URL with password unmasked");

    }

    @Test(priority = 3)
    public void TS001_TC004_Valid_Email_and_Password_with_Password_unMasked() {
        CustomerSigninPage signIn = new CustomerSigninPage(getDriver());
        Toast_URL_Page popup = new Toast_URL_Page(getDriver());

        signIn.clickEyeIcon();
        signIn.enterEmail("example@customer.com");
        signIn.enterPassword("pass@123");
        signIn.clickOnSignInButton();

        Assert.assertEquals(
                popup.getSuccessMessage(),
                "Logged in successfully",
                "Successfully signed in message is not displayed 1"
        );

        Assert.assertTrue(popup.getPageUrl().contains("/dashboard"), "User is not redirected to " +
                "the dashboard URL with password unmasked");

    }

}


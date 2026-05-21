package test_package;

import base_package.Base;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages_package.DashboardPage;
import pages_package.LogoutPopupPage;
import pages_package.Toast_URL_Page;


public class TS018LogoutFunctionalityTests extends Base {

    @BeforeMethod
    public void before() {
        TS001SignInFunctionalityTests.TS001_TC002_Valid_Email_and_Password_with_Password_Masked();


    }

    @Test(priority = 1)
    public void TS018_TC004_1_Logout_Functionality() {
        DashboardPage dashboard = new DashboardPage(driver);
        LogoutPopupPage logout = new LogoutPopupPage(driver);
        Toast_URL_Page popup = new Toast_URL_Page(driver);

        dashboard.clickOnLogoutTab();
        logout.clickLogoutBtn();

        Assert.assertEquals(
                popup.getSuccessMessage(),
                "Logged out successfully",
                "Unable to create consignment"
        );
    }

    @Test(priority = 2)
    public void TS018_TC003_Logout_Confirmation_Popup_Cancel_Button_Functionality() {
        DashboardPage dashboard = new DashboardPage(driver);
        LogoutPopupPage logout = new LogoutPopupPage(driver);

        dashboard.clickOnLogoutTab();
        logout.clickCancelBtn();

    }


    @Test(priority = 3)
    public void TS018_TC004_1_Logout_Confirmation_Popup_Cancel_and_Logout_Using_Tab_and_Enter_Buttons()  {
        DashboardPage dashboard = new DashboardPage(driver);
        LogoutPopupPage logout = new LogoutPopupPage(driver);
        Toast_URL_Page popup = new Toast_URL_Page(driver);

        dashboard.clickOnLogoutTab();
        logout.pressEnter();
        dashboard.clickOnLogoutTab();
        logout.pressTab_then_enter();


        Assert.assertEquals(
                popup.getSuccessMessage(),
                "Logged out successfully",
                "Unable to create consignment"
        );
    }

}


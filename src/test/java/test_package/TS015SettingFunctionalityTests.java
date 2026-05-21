package test_package;

import base_package.Base;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages_package.CustomerSetting_PasswordChangePage;
import pages_package.DashboardPage;
import pages_package.Toast_URL_Page;

public class TS015SettingFunctionalityTests extends Base {

    @BeforeMethod
    public void preprocess()  {
        DashboardPage dashboard = new DashboardPage(driver);
        TS001SignInFunctionalityTests.TS001_TC002_Valid_Email_and_Password_with_Password_Masked();
        dashboard.clickOnSettingsTab();
    }
    @Test(priority=1)
    public void TS015_Update_Password_with_Masked_Data() {
        DashboardPage dashboard = new DashboardPage(driver);
        Toast_URL_Page popup = new Toast_URL_Page(driver);
        CustomerSetting_PasswordChangePage setting = new CustomerSetting_PasswordChangePage(driver);

        dashboard.clickOnSettingsTab();
        setting.enterOldPassword("pass@123");
        setting.enterNewPassword("pass@123");
        setting.enterConformPassword("pass@123");
        setting.clickOnUpdatePasswordBTN();

        //  Capture Toast Message immediately
        String actualMessage = popup.getSuccessMessage();
        // Assert
        Assert.assertEquals(
                actualMessage,
                "Password changed successfully.",
                "Success message did not match after password change!"
        );
        Assert.assertTrue(driver.getPageSource().contains("Password changed success"),"unable to change password");
    }

    @Test(priority=1)
    public void TS015_Update_Password_with_unMasked_Data() {
        DashboardPage dashboard = new DashboardPage(driver);
        Toast_URL_Page popup = new Toast_URL_Page(driver);
        CustomerSetting_PasswordChangePage setting = new CustomerSetting_PasswordChangePage(driver);


        dashboard.clickOnSettingsTab();
        setting.enterOldPassword("pass@123");
        setting.clickOnEyeIcon1();
        setting.enterNewPassword("pass@123");
        setting.clickOnEyeIcon2();
        setting.enterConformPassword("pass@123");
        setting.clickOnEyeIcon3();
        setting.clickOnUpdatePasswordBTN();

        //  Capture Toast Message immediately

        // Assert
        Assert.assertEquals(
                popup.getSuccessMessage(),
                "Password changed successfully.",
                "Success message did not match after password change!"
        );
        Assert.assertTrue(driver.getPageSource().contains("Password changed success"),"unable to change password");

    }

}

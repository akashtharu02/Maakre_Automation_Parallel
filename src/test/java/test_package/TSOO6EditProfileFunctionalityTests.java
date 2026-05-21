package test_package;

import base_package.Base;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages_package.*;

public class TSOO6EditProfileFunctionalityTests extends Base {

    @BeforeMethod
    public void before(){
        DashboardPage dashboard = new DashboardPage(driver);
        TS001SignInFunctionalityTests.TS001_TC002_Valid_Email_and_Password_with_Password_Masked();
        dashboard.clickOnProfile();
    }

    @Test(priority = 1)
    public void TS003_TC001_Edit_Customer_Profile_With_Valid_Data() {
        CustomerProfilePage profile = new CustomerProfilePage(driver);
        EditProfileFormPage editProfile = new EditProfileFormPage(driver);
        Toast_URL_Page popup = new Toast_URL_Page(driver);

        profile.clickEditProfile();
        editProfile.enterCompanyName("Crave Solution Pvt. Ltd.");
        editProfile.enterABNNumber("55149796077");
        editProfile.enterCompanyAddress("82 Cherry Grove");
        editProfile.enterState("Tasmania");
        editProfile.enterPostCode("4522");
        editProfile.enterCity("Scotchtown");
        editProfile.enterSuburb("West Hobart");
        editProfile.enterEmail("example@customer.com");
        editProfile.enterPhoneNumber("+21 485-54-8451");
        editProfile.enterUserName("example_customer");

        editProfile.clickEditBtn();


        Assert.assertEquals(
                popup.getSuccessMessage(),
                "Customer updated successfully",
                "Unable update profile,ABN number invalid "
        );
    }

}

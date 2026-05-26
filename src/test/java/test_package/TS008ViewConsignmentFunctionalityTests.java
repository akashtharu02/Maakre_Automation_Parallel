package test_package;
import base_package.Base;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages_package.ConsignmentFormPage;
import pages_package.DashboardPage;
import pages_package.Toast_URL_Page;
import pages_package.ViewConsignmentsPage;


public class TS008ViewConsignmentFunctionalityTests extends Base {

    @BeforeMethod
    public void preprocess()  {
        new LoginHelper(getDriver()).login();

    }

    @Test(priority = 1)
    public void TS008_TC003_Create_Consignment_Successfully_with_Valid_Info() {

        DashboardPage dashboard = new DashboardPage(getDriver());
        ViewConsignmentsPage consignmentListing = new ViewConsignmentsPage(getDriver());
        ConsignmentFormPage consignmentForm = new ConsignmentFormPage(getDriver());
        Toast_URL_Page popup = new Toast_URL_Page(getDriver());

        dashboard.waitForDashboardToLoad();
        dashboard.clickConsignmentsDropdown();
        dashboard.clickViewConsignments();
        consignmentListing.clickCreateNew();
        consignmentForm.selectReceiver("Claude Tech, Marco");
        consignmentForm.selectDeliveryAddress("Gausala Chowk, Gausala, Kathmandu,");
        consignmentForm.clickCheckbox();
        consignmentForm.selectAuthorityType("Front");
//      consignmentForm.selectDropdownOption(authorityTypeDropdown,"Front");
        consignmentForm.selectServiceType("Urgent");

        consignmentForm.selectPickupAddress("82 Cherry Grove, West Hobart, Scotchtown, Tasmania");
        consignmentForm.enterSpecialInstruction("Drive Slowly");

        consignmentForm.selectDate("25", "June", "2026");

        consignmentForm.selectPackageCode("PLT");
//        consignmentForm.clickPackageAddPackage();
        consignmentForm.enterPackageDescription("description of Package");
        consignmentForm.enterPackageLength("50");
        consignmentForm.enterPackageWidth("40");
        consignmentForm.enterPackageHeight("30");
        consignmentForm.enterPackageWeight("20");
        consignmentForm.clickCreatePackageBtn();


        Assert.assertEquals(
                popup.getSuccessMessage(),
                "Consignment created successfully",
                "Unable to create consignment"
        );

    }
}

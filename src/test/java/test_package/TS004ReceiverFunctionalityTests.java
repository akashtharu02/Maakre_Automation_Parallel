package test_package;

import base_package.Base;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages_package.ReceiverFormPage;
import pages_package.DashboardPage;
import pages_package.Toast_URL_Page;
import pages_package.ReceiversListingPage;

import java.util.List;

public class TS004ReceiverFunctionalityTests extends Base {


    @BeforeMethod
    public void preprocess()  {
        DashboardPage dashboard = new DashboardPage(driver);
        TS001SignInFunctionalityTests.TS001_TC002_Valid_Email_and_Password_with_Password_Masked();
        dashboard.clickReceiver();
    }

    @Test(priority = 1)
    public void TS004_TC001_1_Adding_Receiver_When_Form_Contains_Valid_Data_Without_ABN() {
        ReceiversListingPage receiverListing = new ReceiversListingPage(driver);
        ReceiverFormPage addReceiver = new ReceiverFormPage(driver);
        Toast_URL_Page popup = new Toast_URL_Page(driver);


        receiverListing.clickAddReceiverBtn();
        addReceiver.enterCompanyName("Java Tech PVT. LTD.");
        addReceiver.enterReceiverName("Sushant");
        addReceiver.enterABNNumber("");
        addReceiver.enterState("Bagmati");
        addReceiver.enterCity("Kathamndu");
        addReceiver.enterSuburb("Chabhil");
        addReceiver.enterPostCod("2010");
        addReceiver.enterStreetAddress("KL Tour");
        addReceiver.enterEmail("jvhwertewth@gmail.com");
        addReceiver.enterReferenceNumber("rrer");
        addReceiver.enterPhoneNumber("+61-986551157");
        addReceiver.clickSubmitBtn();


        Assert.assertEquals(
                popup.getSuccessMessage(),
                "Receiver information created successfully",
                "Unable to create a new receiver. A record with this email, " +
                        "phone, or reference number may already exist."
        );
    }

    @Test(priority = 2)
    public void TS004_TC001_2_Adding_Receiver_When_Form_Contains_Valid_Data_With_ABN() {
        ReceiversListingPage receiverListing = new ReceiversListingPage(driver);
        ReceiverFormPage addReceiver = new ReceiverFormPage(driver);
        Toast_URL_Page popup = new Toast_URL_Page(driver);

        receiverListing.clickAddReceiverBtn();
        addReceiver.enterCompanyName("Java Tech PVT. LTD.");
        addReceiver.enterReceiverName("Sushant");
        addReceiver.enterABNNumber("95709620575");
        addReceiver.enterState("Bagmati");
        addReceiver.enterCity("Kathamndu");
        addReceiver.enterSuburb("Chabhil");
        addReceiver.enterPostCod("2010");
        addReceiver.enterStreetAddress("KL Tour");
        addReceiver.enterEmail("edwddwrl@gmail.com");
        addReceiver.enterReferenceNumber("ppp");
        addReceiver.enterPhoneNumber("+61-981627345");
        addReceiver.clickSubmitBtn();

        Assert.assertEquals(
                popup.getSuccessMessage(),
                "Receiver information created successfully",
                "Unable to create a new receiver. A record with this ABN," +
                        " email, phone, or reference number may already exist."
        );
    }


    @Test(priority = 3)
    public void TS004_TC002_1_Update_Receiver_Form_with_Valid_Data_with_ABN() {
        ReceiversListingPage receiverListing = new ReceiversListingPage(driver);
        ReceiverFormPage updateReceiver = new ReceiverFormPage(driver);
        Toast_URL_Page popup = new Toast_URL_Page(driver);

        receiverListing.clickEditIconButton();
        updateReceiver.enterCompanyName("Java Tech PVT. LTD.");
        updateReceiver.enterReceiverName("Sushant");
        updateReceiver.enterABNNumber("");
        updateReceiver.enterState("Bagmati");
        updateReceiver.enterCity("Kathamndu");
        updateReceiver.enterSuburb("Chabhil");
        updateReceiver.enterPostCod("2010");
        updateReceiver.enterStreetAddress("KL Tour");
        updateReceiver.enterEmail("jatecsdhh@gmail.com");
        updateReceiver.enterReferenceNumber("Jt");
        updateReceiver.enterPhoneNumber("+61-983385779");
        updateReceiver.clickSubmitBtn();


        Assert.assertEquals(
                popup.getSuccessMessage(),
                "Receiver Update successful",
                "Unable to update receiver profiles"
        );
    }

    @Test(priority = 4)
    public void TS004_TC002_2_Update_Receiver_Form_with_Valid_Data_Without_ABN() {
        ReceiversListingPage receiverListing = new ReceiversListingPage(driver);
        ReceiverFormPage updateReceiver = new ReceiverFormPage(driver);
        Toast_URL_Page popup = new Toast_URL_Page(driver);

        receiverListing.clickEditIconButton();
        updateReceiver.enterCompanyName("Java Tech PVT. LTD.");
        updateReceiver.enterReceiverName("Sushant");
        updateReceiver.enterABNNumber("");
        updateReceiver.enterState("Bagmati");
        updateReceiver.enterCity("Kathamndu");
        updateReceiver.enterSuburb("Chabhil");
        updateReceiver.enterPostCod("2010");
        updateReceiver.enterStreetAddress("KL Tour");
        updateReceiver.enterEmail("jatecsdhh@gmail.com");
        updateReceiver.enterReferenceNumber("Jt");
        updateReceiver.enterPhoneNumber("+61-983385779");
        updateReceiver.clickSubmitBtn();
        updateReceiver.clickSubmitBtn();


        Assert.assertEquals(
                popup.getSuccessMessage(),
                "Receiver Update successful",
                "Unable to update receiver profiles"
        );
    }


    @Test(priority = 6)
    public void TS004_TC003_Search_Receiver_By_their_Name_and_Company_Namee() {
        ReceiversListingPage receiverListing = new ReceiversListingPage(driver);

        // Search by company name
        receiverListing.enterCompanyNameKeywords("Java Tech");
        receiverListing.waitForSearchResults("Java Tech");

        List<String> companyResults = receiverListing.getDisplayedReceiverRows();
        System.out.println("Result By company Name:" + companyResults);
        Assert.assertFalse(companyResults.isEmpty(), "No results displayed for company search.");
        Assert.assertTrue(
                companyResults.stream().anyMatch(row -> row.contains("Java Tech")),
                "Expected 'Java Tech' not found in search results."
        );

        // Search by receiver name
        receiverListing.clearSearchField();
        receiverListing.enterReceiverNameKeywords("Elon Musk");
        receiverListing.waitForSearchResults("Elon Musk");

        List<String> receiverResults = receiverListing.getDisplayedReceiverRows();
        System.out.println("Result by Receiver Name:" + receiverResults);
        Assert.assertFalse(receiverResults.isEmpty(), "No results displayed for name search.");
        Assert.assertTrue(
                receiverResults.stream().anyMatch(row -> row.contains("Elon Musk")),
                "Expected 'Elon Musk' not found in search results."
        );
    }

}

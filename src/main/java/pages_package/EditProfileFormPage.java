package pages_package;

import com.beust.jcommander.IStringConverter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EditProfileFormPage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    public EditProfileFormPage(WebDriver driver){
        this.driver =driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    private final By companyName = By.id("company_name");
    private final By abnNumber = By.id("abn");
    private final By companyAddress = By.id("street_address");
    private final By state = By.id("state");
    private final By postCode = By.id("post_code");
    private final By city = By.id("city");
    private final By suburb = By.id("suburb");
    private final By companyEmail = By.id("email");
    private final By phoneNumber = By.id("phone_number");
    private final By userName = By.id("username");
    private final By editBtn =By.xpath("//button[@type=\"submit\"]");

    public void enterCompanyName(String comName){
        driver.findElement(companyName).clear();
        driver.findElement(companyName).sendKeys(comName);
    }
    public void enterABNNumber(String ABN){
        driver.findElement(abnNumber).clear();
        driver.findElement(abnNumber).sendKeys(ABN);
    }
    public void enterCompanyAddress(String comAddress){
        driver.findElement(companyAddress).clear();
        driver.findElement(companyAddress).sendKeys(comAddress);
    }
    public void enterState(String comState){
        driver.findElement(state).clear();
        driver.findElement(state).sendKeys(comState);
    }
    public void enterPostCode(String poCode){
        driver.findElement(postCode).clear();
        driver.findElement(postCode).sendKeys(poCode);
    }
    public void enterCity(String comCity){
        driver.findElement(city).clear();
        driver.findElement(city).sendKeys(comCity);
    }
    public void enterSuburb(String comSuburb){
        driver.findElement(suburb).clear();
        driver.findElement(suburb).sendKeys(comSuburb);
    }
    public void enterEmail(String comEmail){
        WebElement codeDropdown = wait.until(
                ExpectedConditions.elementToBeClickable(companyEmail)
        );
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", codeDropdown);
        driver.findElement(companyEmail).clear();
        driver.findElement(companyEmail).sendKeys(comEmail);
    }

    public void enterPhoneNumber(String phNumber){
        WebElement phoneNumberField = driver.findElement(phoneNumber);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", phoneNumberField);
        phoneNumberField.clear();
        phoneNumberField.sendKeys(phNumber);
    }
    public void enterUserName(String uName){
        WebElement codeDropdown = wait.until(
                ExpectedConditions.elementToBeClickable(userName)
        );
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", codeDropdown);
        driver.findElement(userName).clear();
        driver.findElement(userName).sendKeys(uName);
    }
    public void clickEditBtn(){
        WebElement codeDropdown = wait.until(
                ExpectedConditions.elementToBeClickable(editBtn)
        );
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", codeDropdown);
        driver.findElement(editBtn).click();
    }

}

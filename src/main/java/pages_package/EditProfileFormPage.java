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
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
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
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(companyName)
        );
        driver.findElement(companyName).clear();
        driver.findElement(companyName).sendKeys(comName);
    }
    public void enterABNNumber(String ABN){
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(abnNumber)
        );
        driver.findElement(abnNumber).clear();
        driver.findElement(abnNumber).sendKeys(ABN);
    }
    public void enterCompanyAddress(String comAddress){
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(companyAddress)
        );
        driver.findElement(companyAddress).clear();
        driver.findElement(companyAddress).sendKeys(comAddress);
    }
    public void enterState(String comState){
        driver.findElement(state).clear();
        driver.findElement(state).sendKeys(comState);
    }
    public void enterPostCode(String poCode){
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(postCode)
        );
        driver.findElement(postCode).clear();
        driver.findElement(postCode).sendKeys(poCode);
    }
    public void enterCity(String comCity){
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(city)
        );
        driver.findElement(city).clear();
        driver.findElement(city).sendKeys(comCity);
    }
    public void enterSuburb(String comSuburb){
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(suburb)
        );
        driver.findElement(suburb).clear();
        driver.findElement(suburb).sendKeys(comSuburb);
    }
    public void enterEmail(String comEmail){
        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(companyEmail)
        );
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        driver.findElement(companyEmail).clear();
        driver.findElement(companyEmail).sendKeys(comEmail);
    }

    public void enterPhoneNumber(String phNumber){
        WebElement element = driver.findElement(phoneNumber);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.clear();
        element.sendKeys(phNumber);
    }
    public void enterUserName(String uName){
        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(userName)
        );
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        driver.findElement(userName).clear();
        driver.findElement(userName).sendKeys(uName);
    }
    public void clickEditBtn(){
        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(editBtn)
        );
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        driver.findElement(editBtn).click();
    }

}

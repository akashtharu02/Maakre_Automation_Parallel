package pages_package;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.IExpectedExceptionsHolder;

import java.time.Duration;

public class ReceiverFormPage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    public ReceiverFormPage(WebDriver driver){
        this.driver = driver;
        this.wait =  new WebDriverWait(driver, Duration.ofSeconds(50));
    }
    private final By companyName = By.id("company_name");
    private final By receiverName = By.id("receiver_name");
    private final By abnNumber = By.id("abn");
    private final By state = By.id("state");
    private final By city = By.id("city");
    private final By suburb = By.id("suburb");
    private final By postcode = By.id("post_code");
    private final By streetAddress = By.id("street_address");
    private final By email = By.id("email");
    private final By referenceNumber = By.id("reference_no");
    private final By phoneNumber = By.id("phone_no");
    private final By submitBtn = By.xpath("//button[@type='submit']");

    public void enterCompanyName(String compName){
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(companyName)
        );
        element.clear();
        element.sendKeys(compName);
    }

    public void enterReceiverName(String receiveName){
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(receiverName)
        );
        driver.findElement(receiverName).clear();
        driver.findElement(receiverName).sendKeys(receiveName);
    }

    public void enterABNNumber(String abn){
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(abnNumber)
        );
        driver.findElement(abnNumber).clear();
        driver.findElement(abnNumber).sendKeys(abn);
    }

    public void enterState(String stateName){
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(state)
        );
        element.clear();
        driver.findElement(state).sendKeys(stateName);
    }

    public void enterCity(String cityName){
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(city)
        );
        element.clear();
        driver.findElement(city).sendKeys(cityName);
    }

    public void enterSuburb(String suburbName){
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(suburb)
        );
        element.clear();
        driver.findElement(suburb).sendKeys(suburbName);
    }

    public void enterPostCod(String poCode){
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(postcode)
        );
        element.clear();
        driver.findElement(postcode).sendKeys(poCode);
    }

    public void enterStreetAddress(String strAddress){
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(streetAddress)
        );
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.clear();
        driver.findElement(streetAddress).sendKeys(strAddress);
    }

    public void enterEmail(String receiverEmail){
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(email)
        );
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.clear();
        element.sendKeys(receiverEmail);
    }

    public void enterReferenceNumber(String refNumber){
        WebElement element= wait.until(
                ExpectedConditions.visibilityOfElementLocated(referenceNumber)
        );
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.clear();
        driver.findElement(referenceNumber).sendKeys(refNumber);
    }

    public void enterPhoneNumber(String phNumber){
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(phoneNumber)
        );
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.clear();
        driver.findElement(phoneNumber).sendKeys(phNumber);
    }

    public void clickSubmitBtn(){
        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(submitBtn)
        );
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

}

package pages_package;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomerSetting_PasswordChangePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public CustomerSetting_PasswordChangePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }

    private final By oldPassword = By.id("old_password");
    private final By newPassword = By.id("new_password");
    private final By conformPassword = By.id("new_password2");
    private final By updatePasswordBtn = By.xpath("//button[@type='submit']");
    private final By eyeIcon1 = By.xpath("(//div[@class=\"relative group\"])[1]/button");
    private final By eyeIcon2 = By.xpath("(//div[@class=\"relative group\"])[2]/button");
    private final By eyeIcon3 = By.xpath("(//div[@class=\"relative group\"])[3]/button");

    public void enterOldPassword(String oldPass){
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(oldPassword)
        );

        driver.findElement(oldPassword).sendKeys(oldPass);
    }

    public void enterNewPassword(String newPass){
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(newPassword)
        );
        driver.findElement(newPassword).sendKeys(newPass);
    }

    public void enterConformPassword(String conformPass){
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(conformPassword)
        );
        driver.findElement(conformPassword).sendKeys(conformPass);
    }

    public void clickOnUpdatePasswordBTN(){
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(updatePasswordBtn)
        );
        driver.findElement(updatePasswordBtn).click();
    }

    public void clickOnEyeIcon1(){
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(eyeIcon1)
        );
        driver.findElement(eyeIcon1).click();
    }
    public void clickOnEyeIcon2(){
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(eyeIcon2)
        );
        driver.findElement(eyeIcon2).click();
    }
    public void clickOnEyeIcon3(){
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(eyeIcon3)
        );
        driver.findElement(eyeIcon3).click();
    }

}

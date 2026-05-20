package pages_package;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomerSigninPage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    public CustomerSigninPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    private final By emailField = By.id("email");
    private final By passwordField = By.id("password");
    private final By signInButton = By.xpath("//button[@type=\"submit\"]");
    private final By eyeIcon = By.xpath("//button[@type='button']");
    private final By successMessage = By.xpath("//div[@role=\"status\"]");


    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }
    public void clickEyeIcon(){driver.findElement(eyeIcon).click();}
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    public void clickOnSignInButton() {
        driver.findElement(signInButton).click();
    }

    public void pressEnterKey() {
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(signInButton));
        popup.sendKeys(Keys.ENTER);
    }

}



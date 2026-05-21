package pages_package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Toast_URL_Page {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public Toast_URL_Page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }


    private final By successMessage = By.xpath("//div[@role=\"status\"]");


    //Toast Message Method
    public String getSuccessMessage() {
        WebElement toast = wait.until(
                ExpectedConditions.visibilityOfElementLocated(successMessage)
        );
        return toast.getText();
    }

    //Method to get current URL
    public String getPageUrl() {

        wait.until(ExpectedConditions.urlContains("/dashboard"));
        return driver.getCurrentUrl();
    }
}
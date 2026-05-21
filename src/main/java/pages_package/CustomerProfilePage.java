package pages_package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomerProfilePage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    public CustomerProfilePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }
    private final By editProfileBtn = By.xpath("//button[text()='Edit Profile']");
    public void clickEditProfile(){
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(editProfileBtn)
        );
        element.click();
    }
}

package pages_package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ViewConsignmentsPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    public ViewConsignmentsPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));

    }
    private final By createNew = By.xpath("//span[text()=\"Create new\"]");

    public void clickCreateNew(){
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(createNew)
        );
        driver.findElement(createNew).click();
    }
}

package pages_package;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogoutPopupPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public LogoutPopupPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }

    private final By logoutBtn = By.xpath("//Button[text()=\"Logout\"]");
    private final By cancelBtn = By.xpath("//Button[text()=\"Cancel\"]");

    public void clickLogoutBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutBtn));
        driver.findElement(logoutBtn).click();
    }

    public void clickCancelBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cancelBtn));
        driver.findElement(cancelBtn).click();
    }


    public void pressTab_then_enter(){
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(cancelBtn));

        popup.sendKeys(Keys.TAB);
        driver.switchTo().activeElement().sendKeys(Keys.ENTER);
    }

    public void pressEnter() {
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(cancelBtn));
        popup.sendKeys(Keys.ENTER);
    }













//    // Utility
//    public boolean isPopupDisplayed() {
//        return driver.findElement(logoutPopupContainer).isDisplayed();
//    }

}

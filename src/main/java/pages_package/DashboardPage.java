//package pages_package;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.time.Duration;
//
//public class DashboardPage {
//    private final WebDriver driver;
//    private final WebDriverWait wait;
//
//    public DashboardPage(WebDriver driver) {
//        this.driver = driver;
//        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
//
//    }
//
//    private final By receiverTab = By.xpath("//span[text()='Receiver']");
//    private final By profilee = By.xpath("//h4[@class='text-sm font-medium text-gray-800 truncate']");
//    private final By settingsTab = By.xpath("//span[text()='Settings']");
//    private final By consignmentsDropdown = By.xpath("//span[text()=\"Consignments\"]");
//    private final By viewConsignmentsTab = By.xpath("//a[text()=\"View Consignments\"]");
//    private final By logoutTab = By.xpath("//nav/ul/div/span");
//
//
//    public void clickReceiver() {
//        WebElement element = wait.until(
//                ExpectedConditions.presenceOfElementLocated(receiverTab)
//        );
//        element.click();
//    }
//
//    public void clickOnProfile() {
//        WebElement element = wait.until(
//                ExpectedConditions.presenceOfElementLocated(profilee)
//        );
//        element.click();
//    }
//
//    public void clickOnSettingsTab() {
//        WebElement element = wait.until(
//                ExpectedConditions.presenceOfElementLocated(settingsTab)
//        );
//        element.click();
//    }
//
//    public void clickConsignmentsDropdown() {
//        WebElement element = wait.until(
//                ExpectedConditions.presenceOfElementLocated(consignmentsDropdown)
//        );
//        element.click();
//    }
//
//    public void clickViewConsignments() {
//        WebElement element = wait.until(
//                ExpectedConditions.presenceOfElementLocated(viewConsignmentsTab)
//        );
//        element.click();
//    }
//
//    public void clickOnLogoutTab() {
//        WebElement element = wait.until(
//                ExpectedConditions.presenceOfElementLocated(logoutTab)
//        );
//        element.click();
//    }
//
//    public void waitForDashboardToLoad() {
//        wait.until(ExpectedConditions.presenceOfElementLocated(
//                By.xpath("//span[text()='Receiver']")
//        ));
//    }
//
//}



package pages_package;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }

    private final By receiverTab         = By.xpath("//span[text()='Receiver']");
    private final By profilee            = By.xpath("//h4[@class='text-sm font-medium text-gray-800 truncate']");
    private final By settingsTab         = By.xpath("//span[text()='Settings']");
    private final By consignmentsDropdown = By.xpath("//span[text()=\"Consignments\"]");
    private final By viewConsignmentsTab  = By.xpath("//a[text()=\"View Consignments\"]");
    private final By logoutTab           = By.xpath("//nav/ul/div/span");

    private void jsClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void waitForDashboardToLoad() {
        wait.until(driver -> ((JavascriptExecutor) driver)
                .executeScript("return document.readyState").equals("complete"));
        wait.until(ExpectedConditions.presenceOfElementLocated(receiverTab));
    }

    public void clickReceiver() {
        WebElement element = wait.until(
                ExpectedConditions.presenceOfElementLocated(receiverTab));
        jsClick(element);
    }

    public void clickOnProfile() {
        WebElement element = wait.until(
                ExpectedConditions.presenceOfElementLocated(profilee));
        jsClick(element);
    }

    public void clickOnSettingsTab() {
        WebElement element = wait.until(
                ExpectedConditions.presenceOfElementLocated(settingsTab));
        jsClick(element);
    }

    public void clickConsignmentsDropdown() {
        WebElement element = wait.until(
                ExpectedConditions.presenceOfElementLocated(consignmentsDropdown));
        jsClick(element);
    }

    public void clickViewConsignments() {
        WebElement element = wait.until(
                ExpectedConditions.presenceOfElementLocated(viewConsignmentsTab));
        jsClick(element);
    }

    public void clickOnLogoutTab() {
        WebElement element = wait.until(
                ExpectedConditions.presenceOfElementLocated(logoutTab));
        jsClick(element);
    }
}
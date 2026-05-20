package pages_package;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class ReceiversListingPage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    public ReceiversListingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    private final By addReceiverBtn = By.xpath("//span[text()='Add Receiver']");
    private final By editIconButton = By.xpath("//div/a[@href=\"/receiver/42\"]");
    private final By searchReceiverField = By.xpath("/html/body/div[3]/div[3]/section/div[2]/div/input");
    private final By tableRows = By.xpath("//tbody/tr/td");

    public void clickAddReceiverBtn(){
        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(addReceiverBtn)
        );
        driver.findElement(addReceiverBtn).click();
    }

    public void clickEditIconButton(){
        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(editIconButton)
        );
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    public void clearSearchField(){
        driver.findElement(searchReceiverField).clear();
    }
    public void enterCompanyNameKeywords(String keywords){
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(searchReceiverField)
        );
        element.sendKeys(keywords);
    }

    public void enterReceiverNameKeywords(String keywords){
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(searchReceiverField)
        );
        element.sendKeys(keywords);
    }

    public List<String> getDisplayedReceiverRows() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(tableRows));
        List<WebElement> rows = driver.findElements(tableRows);
        return rows.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

  }


}

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
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }

    private final By addReceiverBtn    = By.xpath("//span[text()='Add Receiver']");
    private final By editIconButton    = By.xpath("//div/a[@href=\"/receiver/42\"]");
    private final By searchReceiverField = By.xpath("/html/body/div[3]/div[3]/section/div[2]/div/input");
    private final By tableRows         = By.xpath("//tbody/tr");  // ← changed to <tr> not <td>

    public void clickAddReceiverBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(addReceiverBtn)).click();
    }

    public void clickEditIconButton() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(editIconButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    public void clearSearchField() {
        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(searchReceiverField));
        field.clear();
        // wait for table to reset after clearing
        wait.until(driver -> {
            try {
                List<WebElement> rows = driver.findElements(tableRows);
                return !rows.isEmpty();
            } catch (StaleElementReferenceException e) {
                return false;
            }
        });
    }

    public void enterCompanyNameKeywords(String keywords) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchReceiverField)).sendKeys(keywords);
    }

    public void enterReceiverNameKeywords(String keywords) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchReceiverField)).sendKeys(keywords);
    }


    public List<String> getDisplayedReceiverRows() {
        wait.until(driver -> {
            try {
                List<WebElement> rows = driver.findElements(tableRows);
                return !rows.isEmpty();
            } catch (StaleElementReferenceException e) {
                return false;
            }
        });
        List<WebElement> rows = driver.findElements(tableRows);
        return rows.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public void waitForSearchResults(String keyword) {
        wait.until(driver -> {
            try {
                List<WebElement> rows = driver.findElements(tableRows);
                return rows.stream()
                        .allMatch(row -> row.getText().contains(keyword));
            } catch (StaleElementReferenceException e) {
                return false; // table still re-rendering, retry
            }
        });
    }
}
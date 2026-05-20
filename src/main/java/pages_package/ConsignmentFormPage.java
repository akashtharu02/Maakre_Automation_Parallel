package pages_package;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConsignmentFormPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public ConsignmentFormPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    private final By receiverDropdown = By.id("receiver");
    private final By deliveryAddress = By.id("delivery_addresses");
    private final By authorityCheckBox = By.id("authority_to_leave");
    public static By authorityTypeDropdown = By.xpath("//span[text()='Authority to Leave Type']");
    private final By serviceType = By.xpath("//span[text()=\"Service type\"]");
    private final By pickUpAddress = By.id("pickup_addresses");
    private final By specialInstruction = By.id("special_instruction");
    private final By packageCode = By.xpath("//span[text()=\"Code\"]");
    private final By packageDescription = By.id("packages.0.desc");
    private final By packageLength = By.id("packages.0.length");
    private final By packageWidth = By.id("packages.0.width");
    private final By packageHeight = By.id("packages.0.height");
    private final By packageWeight = By.id("packages.0.weight");
    private final By packageAddBtn = By.xpath("//button[text()='Add']");
    private final By createConsignmentBTn = By.xpath("//button[@type='submit']");

    private final By dateInput = By.xpath("//span[text()=\"Pick a date\"]");
    private final By monthYearLabel = By.xpath("//span[@class=\"select-none font-medium text-sm rdp-caption_label\"]");
    private final By prevButton = By.xpath("//*[@id=\"radix-_r_9_\"]/div/div/nav/button[1]");
    private final By nextButton = By.xpath("//*[@id=\"radix-_r_9_\"]/div/div/nav/button[2]");


    public void clickCheckbox(){
        driver.findElement(authorityCheckBox).click();

    }
    // Generic reusable dropdown handler
    private void selectDropdownOption(By dropdownLocator,String tagName, String optionText) {
        // Click dropdown to open options
        driver.findElement(dropdownLocator).click();

        // Build dynamic locator for option
        By dropdownOptionLocator = By.xpath("//"+tagName+"[contains(text(),'"+optionText+"')]");

        // Wait until option is visible/clickable
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(dropdownOptionLocator));
        option.click();
    }

    public void selectReceiver(String receiverName){
        WebElement codeDropdown = wait.until(
                ExpectedConditions.visibilityOfElementLocated(deliveryAddress)
        );
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", codeDropdown);
        selectDropdownOption(receiverDropdown,"div", receiverName);
    }

    public void selectDeliveryAddress(String address){
        WebElement codeDropdown = wait.until(
                ExpectedConditions.visibilityOfElementLocated(deliveryAddress)
        );
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", codeDropdown);
        selectDropdownOption(deliveryAddress,"div", address);
    }

    public void selectAuthorityType(String authType){
        WebElement codeDropdown = wait.until(
                ExpectedConditions.visibilityOfElementLocated(authorityTypeDropdown)
        );
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", codeDropdown);
        selectDropdownOption(authorityTypeDropdown,"li", authType);
    }

    public void selectServiceType(String service){
        WebElement codeDropdown = wait.until(
                ExpectedConditions.visibilityOfElementLocated(serviceType)
        );
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", codeDropdown);
        selectDropdownOption(serviceType,"li", service);
    }

    public void selectPickupAddress(String pickup){
        WebElement codeDropdown = wait.until(
                ExpectedConditions.visibilityOfElementLocated(pickUpAddress)
        );
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", codeDropdown);
        selectDropdownOption(this.pickUpAddress,"div",pickup);
    }

    public void enterSpecialInstruction(String instruction) {
        WebElement instructionField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(specialInstruction)
        );
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", instructionField);
        instructionField.sendKeys(instruction);
    }

//    public void selectPackageCode(String packCode){
//        WebElement code = driver.findElement(packageCode);
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", code);
//        selectDropdownOption(packageCode,"li",packCode);
//    }

    public void selectPackageCode(String packCode) {
        WebElement codeDropdown = wait.until(
                ExpectedConditions.visibilityOfElementLocated(packageCode)
        );
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", codeDropdown);
        selectDropdownOption(packageCode, "li", packCode);
    }

    public void clickPackageAddPackage(){
        WebElement codeDropdown = wait.until(
                ExpectedConditions.visibilityOfElementLocated(packageAddBtn)
        );
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", codeDropdown);
        driver.findElement(packageAddBtn).click();
    }

    public void enterPackageDescription(String description){
        WebElement codeDropdown = wait.until(
                ExpectedConditions.visibilityOfElementLocated(packageDescription)
        );
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", codeDropdown);
        driver.findElement(packageDescription).sendKeys(description);
    }

    public void enterPackageLength(String length){
        WebElement codeDropdown = wait.until(
                ExpectedConditions.visibilityOfElementLocated(packageLength)
        );
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", codeDropdown);
        driver.findElement(packageLength).sendKeys(length);
    }

    public void enterPackageWidth(String width){
        WebElement codeDropdown = wait.until(
                ExpectedConditions.visibilityOfElementLocated(packageWidth)
        );
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", codeDropdown);
        driver.findElement(packageWidth).sendKeys(width);
    }

    public void enterPackageHeight(String height){
        WebElement codeDropdown = wait.until(
                ExpectedConditions.visibilityOfElementLocated(packageHeight)
        );
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", codeDropdown);
        driver.findElement(packageHeight).sendKeys(height);
    }

    public void enterPackageWeight(String weight){
        WebElement codeDropdown = wait.until(
                ExpectedConditions.visibilityOfElementLocated(packageWeight)
        );
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", codeDropdown);
        driver.findElement(packageWeight).sendKeys(weight);
    }

    public void clickCreatePackageBtn(){
        WebElement codeDropdown = wait.until(
                ExpectedConditions.visibilityOfElementLocated(createConsignmentBTn)
        );
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", codeDropdown);
        codeDropdown.click();
    }


    // Method to select date
    public void selectDate(String day, String month, String year) {
        // Open date picker
        WebElement dateField = wait.until(ExpectedConditions.elementToBeClickable(dateInput));
        dateField.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(monthYearLabel));

        // Navigate to desired month/year
        while (true) {
            String currentMonthYear = driver.findElement(monthYearLabel).getText();
            if (currentMonthYear.equals(month + " " + year)) {
                break;
            } else {
                driver.findElement(nextButton).click();
            }
        }

        // Select the day
        String dayXpath = "//td/button[text()='"+day+"']";
        WebElement dayElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dayXpath)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dayElement);
        dayElement.click();
    }

}

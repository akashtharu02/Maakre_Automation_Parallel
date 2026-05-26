package base_package;


import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.time.Duration;

//public class Base {
//    protected static WebDriver driver;
//
//    @BeforeMethod
//    public void setUp() {
//        driver = new ChromeDriver();
//
//        driver.manage().window().setSize(new Dimension(1920, 1080));
//        driver.get("https://dev.tms.maakretransport.com.au/");
//
//
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
//
//
//
//    }


public class Base {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    protected WebDriver getDriver() {
        return driver.get();
    }

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser) {
        driver.set(createDriver(browser));
        getDriver().manage().window().setSize(new Dimension(1920, 1080));
        getDriver().get("https://dev.tms.maakretransport.com.au/");
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
    }

    private WebDriver createDriver(String browser) {
        switch (browser.toLowerCase()) {

            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("--disable-dev-shm-usage");
                chromeOptions.addArguments("--disable-gpu");
                chromeOptions.addArguments("--remote-allow-origins=*");
                chromeOptions.addArguments("--window-size=1920,1080");
                chromeOptions.addArguments("--force-device-scale-factor=1");
                return new ChromeDriver(chromeOptions);



            case "edge":
                System.setProperty("webdriver.edge.driver", "C:\\Windows\\System32\\msedgedriver.exe");
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--headless=new");
                edgeOptions.addArguments("--no-sandbox");
                edgeOptions.addArguments("--disable-dev-shm-usage");
                edgeOptions.addArguments("--disable-gpu");
                edgeOptions.addArguments("--window-size=1920,1080");
                edgeOptions.addArguments("--force-device-scale-factor=1");
                edgeOptions.addArguments("--remote-debugging-port=0");
                edgeOptions.addArguments("--disable-extensions");
                edgeOptions.addArguments("--disable-software-rasterizer");
                edgeOptions.addArguments("--no-first-run");
                edgeOptions.addArguments("--no-default-browser-check");
                edgeOptions.addArguments("--disable-background-networking");
                edgeOptions.addArguments("--user-data-dir=C:\\ProgramData\\Jenkins\\.jenkins\\edge-profile-"
                        + System.currentTimeMillis());
                edgeOptions.setBinary("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");
                return new EdgeDriver(edgeOptions);


            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless");
                firefoxOptions.addArguments("--window-size=1920,1080");
                firefoxOptions.addPreference("layout.css.devPixelsPerPx", "1.0");
                return new FirefoxDriver(firefoxOptions);

            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }

    @AfterMethod
    public void tearDown()  {
        getDriver().quit();
        driver.remove();

    }
}

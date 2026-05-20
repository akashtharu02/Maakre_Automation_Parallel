package base_package;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class Base {
    protected static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://dev.tms.maakretransport.com.au/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }



//public class Base {
//   protected static WebDriver driver;
//
//    @BeforeMethod
//    @Parameters("browser")
//    public void setUp(String browser) {
//        driver = createDriver(browser);
//        driver.get("https://dev.tms.maakretransport.com.au/");
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//    }
//
//    private WebDriver createDriver(String browser) {
//        switch (browser.toLowerCase()) {
//            case "chrome":
//                return new ChromeDriver();
//            case "firefox":
//                return new FirefoxDriver();
//            case "edge":
//                return new EdgeDriver();
//            default:
//                throw new IllegalArgumentException("Unsupported browser: " + browser);
//        }
//    }


    @AfterMethod
    public void tearDown() throws InterruptedException {

            driver.quit();

    }
}
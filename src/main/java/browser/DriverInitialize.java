package browser;

import browser.Browser;
import browser.DriverSetUp;
import com.regiojet.LocatorsRegioJet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

public class DriverInitialize {
    protected static WebDriver driver;
    protected Browser browser = new Browser(driver);
    @BeforeClass
    public static void setUpDriver() throws Exception {
        driver = DriverSetUp.setUpDriver("chrome");
    }

    @After
    public void quitDriver() throws Exception {
        browser.quitDriver();
        setUpDriver();
    }

    @AfterClass
    public static void closeDriver() {
        driver.close();
    }
}

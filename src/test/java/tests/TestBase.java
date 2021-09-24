package tests;


import driverManager.DriverManager;
import driverManager.DriverManagerFactory;
import driverManager.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    private DriverManager driver;

    @BeforeSuite
    public void setUp() {
        driver = DriverManagerFactory.getManager(DriverType.CHROME);
    }

    @AfterSuite
    public void tearDown() {
        driver.quitDriver();
    }

    public WebDriver getDriver() {
        return driver.getDriver();
    }

}

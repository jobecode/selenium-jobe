package driverManager;

import lombok.extern.java.Log;
import org.openqa.selenium.WebDriver;

@Log
public abstract class DriverManager {

    protected WebDriver driver;

    protected abstract WebDriver createDriver();

    public void quitDriver() {
        if(driver != null) {
           try {
               driver.quit();
               log.info("Terminating driver...");
           } catch (Exception e) {
               log.severe("Unable to terminate driver");
           }
        }
    }

    public WebDriver getDriver() {
        if(driver == null) {
            driver = createDriver();
        }
        return driver;
    }
}

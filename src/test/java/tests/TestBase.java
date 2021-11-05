package tests;


import driverManager.DriverManagerFactory;
import driverManager.DriverType;
import lombok.extern.java.Log;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Log
public class TestBase {

    private static final int TIME_OUT_IMPLICIT = 5000;

    WebDriver driver;

    @BeforeSuite
    public void setUp() {
        driver = DriverManagerFactory.getManager(DriverType.CHROME).getDriver();
        driver.manage().timeouts().implicitlyWait(TIME_OUT_IMPLICIT, TimeUnit.MILLISECONDS);
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

    @AfterMethod
    public void takeScreenshotOnTestFailure(ITestResult iTestResult) {
        try {
            if (iTestResult.getStatus() == ITestResult.FAILURE) {
                log.severe("There was an error in test execution");
                File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                //TODO: when adding parameters I can consider adding + Arrays.toString(iTestResult.getParameters()) + ".jpg") to the file name
                FileUtils.copyFile(scrFile, new File("errorScreenshots\\" + iTestResult.getName() + ".jpg"));

            }
        } catch (IOException e) {
            log.warning("Error on screenshot " + e.getMessage());
        }

    }

}

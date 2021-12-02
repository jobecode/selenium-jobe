package driverManager;


import lombok.extern.java.Log;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Log
public class Hooks {

    private static final int TIME_OUT_IMPLICIT = 10000;

    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverManagerFactory.getManager(DriverType.CHROME).getDriver();
        driver.manage().timeouts().implicitlyWait(TIME_OUT_IMPLICIT, TimeUnit.MILLISECONDS);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
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

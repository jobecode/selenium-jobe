package driverManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class OperaDriverManager extends DriverManager {


    @Override
    protected WebDriver createDriver() {
        WebDriverManager.operadriver().setup();
        return new OperaDriver(getOperaOptions());
    }

    private OperaOptions getOperaOptions() {
        OperaOptions operaOptions = new OperaOptions();
        operaOptions.addArguments("--disable-notifications");
        return operaOptions;
    }
}

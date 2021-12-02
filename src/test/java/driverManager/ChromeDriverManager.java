package driverManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager {

    @Override
    protected WebDriver createDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(getChromeOptions());
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications")
                .addArguments("--ignore-certificate-errors")
                .setPageLoadStrategy(PageLoadStrategy.NORMAL);
        return chromeOptions;

    }

}

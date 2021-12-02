package pages;

import org.openqa.selenium.WebDriver;
import utilities.ConfigurationLoader;

public class HomePage extends PageBase {

    public HomePage(WebDriver driver) {
        super(driver);
        openHomePage();
    }

    private void openHomePage() {
        navigateToUrl(ConfigurationLoader.getInstance().getProperty("baseUrl"));
    }




}

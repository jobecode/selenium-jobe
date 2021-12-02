package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class ForgottenPasswordPage extends PageBase {

    public ForgottenPasswordPage(WebDriver driver) {
        super(driver);
    }

    public boolean forgottenPasswordPageIsVisible() {
        return wait.until(visibilityOfElementLocated(By.id("send_password_form"))).isDisplayed();
    }


}

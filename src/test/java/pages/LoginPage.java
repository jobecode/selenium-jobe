package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ConfigurationLoader;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class LoginPage extends PageBase {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public AccountPage loginWithTestUser(String username, String password) {
        ConfigurationLoader properties = ConfigurationLoader.getInstance();
        enterUser(properties.getProperty(username));
        enterPassword(properties.getProperty(password));
        clickSignInButton();
        return new AccountPage(driver);
    }

    public void clickSignInButton() {
        wait.until(visibilityOfElementLocated(By.className("btn-primary"))).click();
    }

    public ForgottenPasswordPage clickOnForgotPassword() {
        wait.until(visibilityOfElementLocated(By.partialLinkText("Forgot"))).click();
        return new ForgottenPasswordPage(driver);
    }

    private void enterUser(String user) {
        wait.until(visibilityOfElementLocated(By.id("user_login"))).sendKeys(user);
    }

    private void enterPassword(String password) {
        wait.until(visibilityOfElementLocated(By.id("user_password"))).sendKeys(password);
    }






}

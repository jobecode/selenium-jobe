package pages;

import lombok.extern.java.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

@Log
public class PageBase {

    WebDriver driver;
    WebDriverWait wait;

    private static final int TIME_OUT_SECONDS = 10;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,TIME_OUT_SECONDS);
    }

    public void waitForPageToBeLoaded() {
        wait.until(driver1 -> ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete"));
    }

    public void navigateToUrl(String url) {
        try {
            log.info("Navigating to: " +  url);
            driver.get(url);
        } catch(TimeoutException e) {
            log.warning("it took too long navigating to the URL. Please, check test server");
        }
        waitForPageToBeLoaded();
    }

    public void clickOnIndexZeroBank() {
        wait.until(visibilityOfElementLocated(By.className("brand"))).click();
        waitForPageToBeLoaded();
    }

    public LoginPage clickOnSignIn() {
        wait.until(visibilityOfElementLocated(By.id("signin_button"))).click();
        return new LoginPage(driver);
    }

    public void typeOnSearch(String text) {
       wait.until(visibilityOfElementLocated(By.id("searchTerm"))).click();
    }

    public boolean userIsLoggedIn() {
        return wait.until(visibilityOfElementLocated(By.id("settingsBox"))).isDisplayed();
    }

    public boolean errorOnSignIn() {
        return wait.until(visibilityOfElementLocated(By.className("alert-error"))).isDisplayed();
    }







}

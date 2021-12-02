package tests;

import driverManager.Hooks;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.ForgottenPasswordPage;
import pages.HomePage;
import pages.LoginPage;

import static io.qameta.allure.SeverityLevel.BLOCKER;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LoginTest extends Hooks {

    @Severity(BLOCKER)
    @Description("Test that verifies sign in")
    @Test
    public void loginTest() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickOnSignIn();
        AccountPage accountPage = loginPage.loginWithTestUser("username", "password");
        assertThat("An error occurred when login in", accountPage.userIsLoggedIn(), is(true));
    }

    @Severity(BLOCKER)
    @Description("Test that verifies a user cannot sign in with wrong password")
    @Test
    public void wrongUserLoginTest() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickOnSignIn();
        loginPage.loginWithTestUser("username", "wrong_password");

        assertThat("There was an error when trying to log in with wrong password", loginPage.errorOnSignIn(), is(true));
    }

    @Severity(BLOCKER)
    @Description("Test that verifies users are able to recover their password")
    @Test
    public void forgottenPasswordTest() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickOnSignIn();
        ForgottenPasswordPage forgottenPasswordPage = loginPage.clickOnForgotPassword();

        assertThat("The page to recover password is not reached", forgottenPasswordPage.forgottenPasswordPageIsVisible());
    }





}

package tests;



import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class NavigationTest extends TestBase {

    @Test
    public void test() {
        driver.get("http://zero.webappsecurity.com/index.html");

        driver.findElement(By.id("onlineBankingMenu")).click();
        assertThat("The section of the online banking is not displayed", driver.findElement(By.id("online_banking_features")).isDisplayed(), is(true));




    }

}

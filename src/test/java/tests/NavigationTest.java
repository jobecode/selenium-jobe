package tests;


import org.testng.annotations.Test;

public class NavigationTest extends TestBase {

    @Test
    public void mainPageCanBeReached() {
        getDriver().get("http://zero.webappsecurity.com/index.html");
    }

}

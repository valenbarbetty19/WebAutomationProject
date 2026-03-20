package selenium.pom.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;
import selenium.pom.pages.*;

import java.util.HashMap;
import java.util.Map;

public class LogoutSteps extends BaseTest{

    private LoginPage loginPage;
    @BeforeMethod
    public void init(){
        setUp();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void logoutTest(){

        InventoryPage inventory = loginPage.login("standard_user", "secret_sauce");
        LoginPage login = inventory.logout();
        Assert.assertTrue(
                driver.getCurrentUrl().contains("saucedemo"),
                "User was not redirected to login page"
        );
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
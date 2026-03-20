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

public class CartSteps extends BaseTest{

    private LoginPage loginPage;

    @BeforeMethod
    public void init(){
        setUp();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void removeItemsTest(){

        InventoryPage inventory = loginPage.login("standard_user", "secret_sauce");
        inventory.addFirstThreeProducts();
        CartPage cart = inventory.goToCart();
        cart.removeAllItems();
        Assert.assertTrue(cart.isCartEmpty());
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
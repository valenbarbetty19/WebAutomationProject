package selenium.pom.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import selenium.pom.pages.*;

public class PurchaseSteps extends BaseTest {

    private LoginPage loginPage;

    @BeforeMethod
    public void init(){
        setUp();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void purchaseFlowTest(){
        InventoryPage inventory = loginPage.login("standard_user", "secret_sauce");
        inventory.addProduct();
        CartPage cart = inventory.goToCart();
        CheckoutPage checkout = cart.clickCheckout();
        checkout.fillForm();
        CompletePage complete = checkout.finishPurchase();
        Assert.assertTrue(complete.getMessage().contains("Thank you"));
    }

    @AfterMethod
    public void clean(){
        tearDown();
    }
}
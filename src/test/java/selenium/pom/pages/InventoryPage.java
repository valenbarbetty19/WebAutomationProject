package selenium.pom.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class InventoryPage extends BasePage {

    @FindBy(className = "inventory_item")
    private List<WebElement> products;

    @FindBy(id = "shopping_cart_container")
    private WebElement cart;
    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuBtn;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutBtn;
    public InventoryPage(WebDriver driver){
        super(driver);
    }

    public void addProduct(){
        products.get(0).findElement(By.tagName("button")).click();
    }
    public CartPage goToCart(){
        cart.click();
        return new CartPage(driver);
    }
    public void addFirstThreeProducts(){
        for (int i = 0; i < 3; i++) {
            products.get(i).findElement(By.tagName("button")).click();
        }
    }
    public LoginPage logout(){
        menuBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(logoutBtn));

        logoutBtn.click();

        wait.until(ExpectedConditions.urlContains("saucedemo"));
        return new LoginPage(driver);
    }


}
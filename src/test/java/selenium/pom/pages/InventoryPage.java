package selenium.pom.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class InventoryPage extends BasePage {

    @FindBy(className = "inventory_item")
    private List<WebElement> products;

    @FindBy(id = "shopping_cart_container")
    private WebElement cart;

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

}
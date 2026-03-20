package selenium.pom.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginBtn;

    public LoginPage(org.openqa.selenium.WebDriver driver){
        super(driver);
    }

    public InventoryPage login(String email, String password){
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        loginBtn.click();
        return new InventoryPage(driver);
    }
}
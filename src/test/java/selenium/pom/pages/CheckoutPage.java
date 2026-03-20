package selenium.pom.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage extends BasePage{

    @FindBy(id = "first-name")
    private WebElement firstName;

    @FindBy(id = "last-name")
    private WebElement lastName;

    @FindBy(id = "postal-code")
    private WebElement zip;

    @FindBy(id = "continue")
    private WebElement continueBtn;

    @FindBy(id = "finish")
    private WebElement finishBtn;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void fillForm(){
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.visibilityOf(firstName));
        firstName.sendKeys("Vale");
        lastName.sendKeys("Test");
        zip.sendKeys("12345");
    }

    public CompletePage finishPurchase(){
        continueBtn.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(finishBtn));
        finishBtn.click();
        return new CompletePage(driver);
    }
}
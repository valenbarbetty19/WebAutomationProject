package selenium.pom.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompletePage extends BasePage{

    @FindBy(className = "complete-header")
    private WebElement message;

    public CompletePage(WebDriver driver) {
        super(driver);
    }
    public String getMessage(){
        return message.getText();
    }
}
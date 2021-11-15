package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginToFPage extends BasePage{
    public LoginToFPage(WebDriver driver) {
        super(driver);
    }

    @FindBy()
    private WebElement login;

    @FindBy()
    private WebElement password;

    @FindBy()
    private WebElement signInBtn;
}

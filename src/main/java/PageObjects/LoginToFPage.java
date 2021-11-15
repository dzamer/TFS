package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginToFPage extends BasePage{
    public LoginToFPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "userNameInput")
    private WebElement loginInput;

    @FindBy(id = "passwordInput")
    private WebElement passwordInput;

    @FindBy(id = "submitButton")
    private WebElement signInBtn;

    public HomePage loginToFTFS(String loginEmail, String password){
        waitForInputAndSendKeys(loginInput, loginEmail);
        passwordInput.sendKeys(password);
        signInBtn.click();
        return new HomePage(getDriver());
    }
}

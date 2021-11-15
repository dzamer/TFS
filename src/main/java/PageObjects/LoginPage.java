package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "username")
    private WebElement userID;

    @FindBy(css = ".col-xs-12 button")
    private WebElement submitBtn;

    @FindBy(css = ".col-xs-12 a[href=\"javascript:void(0)\"]")
    private WebElement externalLoginBtn;

    public LoginToFPage loginToTfs(String login){
        userID.sendKeys(login);
        submitBtn.click();
        waitForButtonAndClick(externalLoginBtn);
        waitForButtonAndClick(submitBtn);
        return new LoginToFPage(getDriver());
    }
}

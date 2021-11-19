package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationPage extends BasePage{
    public NavigationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "sysparm_search")
    private WebElement searchInput;

    public SearchedObjectPage searchElement(String elementToSearch){
        waitForInputAndSendKeys(searchInput, elementToSearch);
        searchInput.submit();
        return new SearchedObjectPage(getDriver(), elementToSearch);
    }
}

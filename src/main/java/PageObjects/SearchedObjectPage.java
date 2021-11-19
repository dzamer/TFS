package PageObjects;

import PageObjects.SelectsEnums.TaskState;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchedObjectPage extends BasePage{
    public SearchedObjectPage(WebDriver driver,String elementToSearch) {
        super(driver);
        this.element=elementToSearch;
    }

    private String element;

    @FindBy(css = "navbar-title-display-value")
    private WebElement searchedElement;

    @FindBy(css = "input[id=\"sys_display.sc_task.assigned_to\"]")
    private WebElement assignTo;
    @FindBy(css = ".col-xs-10 .form-control[name=\"sc_task.state\"]")
    private WebElement state;
    @FindBy(css = ".sn-string-textarea[id=\"activity-stream-work_notes-textarea\"]")
    private WebElement workNotes;

    public SearchedObjectPage changeIFrameOnSearchedEl(){
        getDriver().switchTo().frame("gsft_main");
        return this;
    }

    public void fillAndCloseTask(String name, TaskState state, String workNotes){
        if(searchedElement.getText().equals(this.element)){

        }
    }

}

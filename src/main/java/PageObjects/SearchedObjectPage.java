package PageObjects;

import PageObjects.SelectsEnums.TaskState;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

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
    @FindBy(css = "input[id=\"sys_display.sc_task.assigned_to\"][aria-expanded=\"false\"]")
    private WebElement assignToExp;
    @FindBy(css = "button[id=\"sysverb_update_and_stay\"]")
    private WebElement saveBtn;

    public SearchedObjectPage changeIFrameOnSearchedEl(){
        getDriver().switchTo().frame("gsft_main");
        return this;
    }

    public void fillAndSaveTask(String name, TaskState state, String workNote){
        if(searchedElement.getText().equals(this.element)){
            assignTo.sendKeys(name);
            waitForElementToBeVisible(assignToExp);
            assignTo.sendKeys(Keys.TAB);
            workNotes.sendKeys(workNote);
            Select stateSelect = new Select(this.state);
            switch (state){
                case OPEN -> stateSelect.selectByVisibleText("Open");
                case PENDING -> stateSelect.selectByVisibleText("Pending");
                case CLOSE_COMPLETE -> stateSelect.selectByVisibleText("Close Complete");
                case CLOSED_INCOMPLETE -> stateSelect.selectByVisibleText("Clsoe Incomplete");
                case WORK_IN_PROGRESS -> stateSelect.selectByVisibleText("Work in Progress");
                case AWAITING_CUSTOMER_INFORMATION -> stateSelect.selectByVisibleText("Awaiting Customer Information");
            }
            saveBtn.click();
        }
    }

}

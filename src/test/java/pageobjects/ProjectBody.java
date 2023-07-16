package pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ProjectBody {
    private SelenideElement addNewBacklogTask = $x("//th[@class='board-column-header board-column-header-73']//i[@class='fa fa-plus fa-fw js-modal-large']");
    private SelenideElement addedNewTask = $x("//div[@class='task-board draggable-item task-board-status-open task-board-recent color-green ui-sortable-handle']//div[@class='task-board-title']/a");
    public void clickAddNewBacklogTask(){
        getAddNewBacklogTask().click();
    }
    public String getTextOfNewlyCreatedTask(){
        return getAddedNewTask().shouldBe(Condition.visible).text();
    }
    public void clickOnNewTaskTitle(){
        getAddedNewTask().click();
    }

    public SelenideElement getAddNewBacklogTask() {
        return addNewBacklogTask;
    }

    public SelenideElement getAddedNewTask() {
        return addedNewTask;
    }
}

package pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class ProjectBody {
    private SelenideElement addNewBacklogTask = $x("//a[contains(text(), 'Backlog')]/parent::span/parent::span/preceding-sibling::div");
    private SelenideElement addedNewTask = $x("//div[@class='task-board-title']/a");
    @Step("Add a new backlog task")
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

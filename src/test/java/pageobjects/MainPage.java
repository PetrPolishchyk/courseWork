package pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private SelenideElement userMenu = $x("//div[@class='dropdown']//div[@class='avatar-letter']");
    private SelenideElement logoutButton = $x("//ul[@class='dropdown-submenu-open']/li[10]/a");
    private SelenideElement dashboardElement = $x("//*[@href='/dashboard']");
    private SelenideElement newProjectButton = $x("//div[@class='page-header']//a[@href='/project/create']");
    private SelenideElement myProjects = $x("//a[text()='My projects']");
    private SelenideElement projectTitle = $x("//span[@class='table-list-title ']/a");
    private SelenideElement myTasks = $x("//a[text()='My tasks']");
    private SelenideElement taskTitle = $x("//div[@class = 'task-board-title']/a");
    private SelenideElement textOfEmptyTasks = $x("//p[@class='alert']");

    public void openUserMenu(){
        getUserMenu().click();
    }
    public void clickLogout(){
        getLogoutButton().click();
    }
    public void clickNewProjectButton(){
        getNewProjectButton().shouldBe(Condition.visible).click();
    }
    public void clickOnMyProjects(){
        getMyProjects().click();
    }
    public String getProjectTitleText(){
        return getProjectTitle().shouldBe(Condition.visible).text();
    }
    public void clickOnProjectTitle(){
        getProjectTitle().click();
    }
    public void clickOnMyTasks(){
        getMyTasks().shouldBe(Condition.visible).click();
    }
    public void openTask(){
        getTaskTitle().shouldBe(Condition.visible).click();
    }
    public String getAlertTextIfNoAnyTasks(){
        return getTextOfEmptyTasks().shouldBe(Condition.visible).text();
    }

    //getters
    public SelenideElement getUserMenu() {
        return userMenu;
    }

    public SelenideElement getLogoutButton() {
        return logoutButton;
    }

    public SelenideElement getDashboardElement() {
        return dashboardElement;
    }

    public SelenideElement getNewProjectButton() {
        return newProjectButton;
    }

    public SelenideElement getMyProjects() {
        return myProjects;
    }
    public SelenideElement getProjectTitle() {
        return projectTitle;
    }
    public SelenideElement getMyTasks() {
        return myTasks;
    }
    public SelenideElement getTaskTitle() {
        return taskTitle;
    }

    public SelenideElement getTextOfEmptyTasks() {
        return textOfEmptyTasks;
    }
}

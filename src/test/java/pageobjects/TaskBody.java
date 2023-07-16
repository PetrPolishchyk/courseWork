package pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class TaskBody {
    private SelenideElement descriptionText = $x("//div[@class='accordion-content']/article");
    private SelenideElement addComment = $x("//div[@class='sidebar sidebar-icons']/ul[2]/li[6]/a");
    private SelenideElement closeThisTask = $x("//div[@class='sidebar sidebar-icons']/ul[2]/li[14]/a");
    private SelenideElement createdCommentText = $x("//div[@id='comments']//div[@class='comment-content']//p");
    private SelenideElement dashboard = $x("//a[@href='/dashboard']");

    public String getDescriptionTextOfTask(){
        return getDescriptionText().text();
    }
    public void clickAddComment(){
        getAddComment().shouldBe(Condition.visible).click();
    }
    public String getFullTextOfCreatedComment(){
        return getCreatedCommentText().shouldBe(Condition.visible).text();
    }
    public void clickCloseThisTaskButton(){
        getCloseThisTask().shouldBe(Condition.visible).click();
    }
    public void goToDashboard(){
        getDashboard().click();
    }

    //getters
    public SelenideElement getDescriptionText() {
        return descriptionText;
    }

    public SelenideElement getAddComment() {
        return addComment;
    }

    public SelenideElement getCreatedCommentText() {
        return createdCommentText;
    }

    public SelenideElement getCloseThisTask() {
        return closeThisTask;
    }

    public SelenideElement getDashboard() {
        return dashboard;
    }
}

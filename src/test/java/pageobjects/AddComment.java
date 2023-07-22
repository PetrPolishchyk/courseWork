package pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class AddComment {
    private SelenideElement commentBody = $x("//div[@id='modal-content']//textarea[@name='comment']");
    private SelenideElement saveButton = $x("//div[@id='modal-content']//button[@type='submit']");

    public void setComment(String comment){
        getCommentBody().shouldBe(Condition.visible).clear();
        getCommentBody().sendKeys(comment);
    }
    public void clickSaveComment(){
        getSaveButton().click();
    }

    public SelenideElement getCommentBody() {
        return commentBody;
    }
    public SelenideElement getSaveButton() {
        return saveButton;
    }
}

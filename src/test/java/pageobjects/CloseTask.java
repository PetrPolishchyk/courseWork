package pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class CloseTask {
    public SelenideElement confirmToCloseTaskButton = $x("//button[@id='modal-confirm-button']");

    @Step("Confirm to close the task")
    public void clickConfirmToCloseTask(){
        getConfirmToCloseTaskButton().shouldBe(Condition.visible).click();
    }

    public SelenideElement getConfirmToCloseTaskButton() {
        return confirmToCloseTaskButton;
    }
}

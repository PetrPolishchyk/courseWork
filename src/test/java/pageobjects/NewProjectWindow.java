package pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class NewProjectWindow {
    private SelenideElement nameField = $("#form-name");
    private SelenideElement identifierField = $("#form-identifier");
    private SelenideElement saveButton = $x("//button[text()='Save']");

    @Step("Set the name")
    public void setNameField(String name){
        getNameField().shouldBe(Condition.visible).clear();
        getNameField().sendKeys(name);
    }
    @Step("Set the identifier")
    public void setIdentifierField(String identifier){
        identifier.toUpperCase();
        getIdentifierField().shouldBe(Condition.visible).clear();
        getIdentifierField().sendKeys(identifier);
    }
    @Step("Press the save button")
    public void pressSaveButton(){
        getSaveButton().click();
    }

    public SelenideElement getNameField() {
        return nameField;
    }

    public SelenideElement getIdentifierField() {
        return identifierField;
    }

    public SelenideElement getSaveButton() {
        return saveButton;
    }
}

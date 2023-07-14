package pageobjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ConfigureThisProject {
    private SelenideElement assertText = $x("//ul[@class='panel']/li[1]");
    private SelenideElement removeButton = $x("//a[text()='Remove']");
    private SelenideElement confirmRemoveYes = $x("//button[text()='Yes']");

    public String getProjectMainTitleText(){
        return getAssertText().text();
    }
    public void pressRemoveProject(){
        getRemoveButton().click();
    }
    public void confirmRemoving(){
        getConfirmRemoveYes().click();
    }

    public SelenideElement getRemoveButton() {
        return removeButton;
    }
    public SelenideElement getAssertText() {
        return assertText;
    }
    public SelenideElement getConfirmRemoveYes() {
        return confirmRemoveYes;
    }
}


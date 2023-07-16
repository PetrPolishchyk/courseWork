package pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CreateNewTask {
    private SelenideElement title = $x("//input[@name='title']");
    private SelenideElement description = $x("//textarea[@name='description']");
    private SelenideElement saveButton = $x("//button[@type='submit']");
    private SelenideElement colorOption = $x("//div[@class='color-picker-option']");

    //methods
    public void setTitleToNewTask(String title){
        getTitle().shouldBe(Condition.visible).clear();
        getTitle().sendKeys(title);
    }
    public void setDescription(String description){
        getDescription().shouldBe(Condition.visible).clear();
        getDescription().sendKeys(description);
    }
    public void selectColor(String color){
        getColorOption().shouldBe(Condition.visible).selectOption(color);
    }
    public void clickSave(){
        getSaveButton().shouldBe(Condition.visible).click();
    }

    //getters
    public SelenideElement getTitle() {
        return title;
    }
    public SelenideElement getDescription() {
        return description;
    }
    public SelenideElement getSaveButton() {
        return saveButton;
    }
    public SelenideElement getColorOption() {
        return colorOption;
    }
}

package pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    private SelenideElement userName = $("#form-username");
    private SelenideElement password = $("#form-password");
    private SelenideElement signInButton = $x("//button[text()='Sign in']");
    private SelenideElement rememberMeCheckbox = $x("//input[@name='remember_me']");
    private SelenideElement alertError = $x("//p[@class='alert alert-error']");

    public void setUserName(String name){
        getUserName().shouldBe(Condition.visible).clear();
        getUserName().sendKeys(name);
    }
    public void setPassword(String pass){
        getPassword().shouldBe(Condition.visible).clear();
        getPassword().sendKeys(pass);
    }
    public void pressSignInButton(){
        getSignInButton().shouldBe(Condition.visible).click();
    }
    public void uncheckRememberMe(){
        getRememberMeCheckbox().setSelected(false);
    }
    public String getAlertErrorText(){
        return getAlertError().text();
    }

    public SelenideElement getUserName() {
        return userName;
    }

    public SelenideElement getPassword() {
        return password;
    }

    public SelenideElement getSignInButton() {
        return signInButton;
    }

    public SelenideElement getRememberMeCheckbox() {
        return rememberMeCheckbox;
    }

    public SelenideElement getAlertError() {
        return alertError;
    }
}

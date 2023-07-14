package pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private SelenideElement userMenu = $x("//div[@class='avatar-letter']");
    private SelenideElement logoutButton = $x("//ul[@class='dropdown-submenu-open']/li[10]/a");
    private SelenideElement dashboardElement = $x("//*[@href='/dashboard']");
    private SelenideElement newProjectButton = $x("//div[@class='page-header']//a[@href='/project/create']");

    public void openUserMenu(){
        getUserMenu().click();
    }
    public void clickLogout(){
        getLogoutButton().click();
    }
    public void clickNewProjectButton(){
        getNewProjectButton().shouldBe(Condition.visible).click();
    }

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
}

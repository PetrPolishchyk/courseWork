package tests;

import baseclasses.BaseWorkingClass;
import baseclasses.DataProviders;
import baseclasses.SignIn;
import com.beust.jcommander.Parameter;
import com.codeborne.selenide.Condition;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.MainPage;

//1. Вхід: два-три негативних і один позитивний кейс.
public class TestSignIn extends BaseWorkingClass {
    SignIn signIn = new SignIn();
    MainPage mainPage = new MainPage();
    private String alertErrorText = "Bad username or password";

    @Test(priority = 0)
    @Description("Log in test with wrong password")
    public void testWrongPassword(){
        //setUpChrome();
        setUpDinamicallyBrowser();
        signIn.signInDynamically("admin", "noAdmin");

        Assert.assertEquals(signIn.loginPage.getAlertErrorText(), alertErrorText, "Alert error has not shown");
        cleanUp();
    }

    @Test(priority = 1)
    @Description("Log in test with wrong user name")
    public void testWrongUserName(){
        //setUpChrome();
        setUpDinamicallyBrowser();
        signIn.signInDynamically("wrongAdmin", "admin");

        Assert.assertEquals(signIn.loginPage.getAlertErrorText(), alertErrorText, "Alert error has not shown");
        cleanUp();
    }
    @Test(dataProvider = "systemExistUsers", dataProviderClass = DataProviders.class, priority = 2)
    @Description("Log in test with 3 different users")
    public void testCorrectLogIn(String userName, String password){
        //setUpChrome();
        setUpDinamicallyBrowser();
        signIn.signInDynamically(userName, password);

        mainPage.getDashboardElement().shouldBe(Condition.visible);
        cleanUp();
    }
    @Test(priority = 3)
    @Description("Log out test")
    public void testLogOut(){
        //setUpChrome();
        setUpDinamicallyBrowser();
        signIn.signInAsAdmin();
        mainPage.openUserMenu();
        mainPage.clickLogout();
        cleanUp();
    }
}

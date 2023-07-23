package baseclasses;

import io.qameta.allure.Step;
import pageobjects.LoginPage;

public class SignIn {
    public LoginPage loginPage = new LoginPage();

    @Step("Sign in as Admin")
    public void signInAsAdmin(){
        loginPage.setUserName("admin");
        loginPage.setPassword("admin");
        loginPage.uncheckRememberMe();
        loginPage.pressSignInButton();
    }
    @Step("Sign in as user")
    public void signInDynamically(String username, String password){
        loginPage.setUserName(username);
        loginPage.setPassword(password);
        loginPage.uncheckRememberMe();
        loginPage.pressSignInButton();
    }
}

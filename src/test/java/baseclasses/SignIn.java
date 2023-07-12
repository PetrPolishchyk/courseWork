package baseclasses;

import pageobjects.LoginPage;

public class SignIn {
    public LoginPage loginPage = new LoginPage();

    public void signInAsAdmin(){
        loginPage.setUserName("admin");
        loginPage.setPassword("admin");
        loginPage.uncheckRememberMe();
        loginPage.pressSignInButton();
    }
    public void signInDynamically(String username, String password){
        loginPage.setUserName(username);
        loginPage.setPassword(password);
        loginPage.uncheckRememberMe();
        loginPage.pressSignInButton();
    }
}

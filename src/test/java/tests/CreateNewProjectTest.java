package tests;

import baseclasses.BaseWorkingClass;
import baseclasses.SignIn;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.ConfigureThisProject;
import pageobjects.LoginPage;
import pageobjects.MainPage;
import pageobjects.NewProjectWindow;

//2. Користувач може створити проект.
public class CreateNewProjectTest extends BaseWorkingClass {
    SignIn signIn = new SignIn();
    MainPage mainPage = new MainPage();
    NewProjectWindow newProjectWindow = new NewProjectWindow();
    ConfigureThisProject configureThisProject = new ConfigureThisProject();
    private String checkingText = "This project is open";

    @Test
    @Description("Create, open and delete a new Project by Admin")
    public void createNewProject(){
        //setUpChrome();
        setUpDinamicallyBrowser();
        signIn.signInAsAdmin();
        mainPage.clickNewProjectButton();
        newProjectWindow.setNameField("Test Project Name Created By UI");
        newProjectWindow.setIdentifierField("adminproject");
        newProjectWindow.pressSaveButton();

        Assert.assertEquals(configureThisProject.getProjectMainTitleText(), checkingText,"The project was nat created");

        configureThisProject.pressRemoveProject();
        configureThisProject.confirmRemoving();
        cleanUp();
    }
}

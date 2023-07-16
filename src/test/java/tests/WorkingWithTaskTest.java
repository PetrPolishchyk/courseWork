package tests;

import apitests.TestAddProjectToUser;
import apitests.TestProjectCreate;
import apitests.TestUserCreate;
import baseclasses.BaseWorkingClass;
import baseclasses.SignIn;
import com.codeborne.selenide.Condition;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.*;

public class WorkingWithTaskTest extends BaseWorkingClass {
    private Integer newUserId;
    private String userName = "NewUserTest";
    private String userPassword = "102030";
    private Integer newProjectId;
    private String newProjectName = "Test project to add a new task";
    private String titleOfNewTask = "New task test";
    private String descriptionOfNewTask = "the description of a newly created task";
    private String textOfComment = "This is a new comment in the tested task";

    SignIn signIn = new SignIn();
    MainPage mainPage = new MainPage();
    TestUserCreate userCreate = new TestUserCreate();
    TestProjectCreate projectCreate = new TestProjectCreate();
    TestAddProjectToUser addProjectToUser = new TestAddProjectToUser();
    ProjectBody projectBody = new ProjectBody();
    CreateNewTask newTask = new CreateNewTask();
    TaskBody taskBody = new TaskBody();
    AddComment addComment = new AddComment();

    @Test(priority = 0)
    @Description("Test of a task creation")
    public void createNewTask(){
        setUpChrome();
        //create user and project, add project to the user
        newUserId = userCreate.createUser(userName, userPassword);
        newProjectId = projectCreate.createProject(newProjectName);
        Assert.assertTrue(addProjectToUser.addProjectToUser(newUserId, newProjectId));
        //sign in as a newly created user
        signIn.signInDynamically(userName, userPassword);
        mainPage.clickOnMyProjects();
        Assert.assertEquals(mainPage.getProjectTitleText(), newProjectName, "Project was created with different title");
        mainPage.clickOnProjectTitle();
        //create a new backlog task
        projectBody.clickAddNewBacklogTask();
        newTask.setTitleToNewTask(titleOfNewTask);
        newTask.setDescription(descriptionOfNewTask);
        newTask.selectColor("Green");
        newTask.clickSave();
        //check the task creation
        Assert.assertEquals(projectBody.getTextOfNewlyCreatedTask(), titleOfNewTask, "The task was not created with correct name");
        //logout
        mainPage.openUserMenu();
        mainPage.clickLogout();
        cleanUp();
    }
    @Test(priority = 1)
    @Description("Test of adding a comment to the task")
    public void addCommentToTaskTest(){
        setUpChrome();
        //sign in and open the tasks
        signIn.signInDynamically(userName, userPassword);
        mainPage.clickOnMyTasks();
        //open the task and check the description
        mainPage.openTask();
        Assert.assertEquals(taskBody.getDescriptionTextOfTask(), descriptionOfNewTask, "The task was not found");
        //add a new comment
        taskBody.clickAddComment();
        addComment.setComment(textOfComment);
        addComment.clickSaveComment();
        Assert.assertEquals(taskBody.getFullTextOfCreatedComment(), textOfComment, "Comment was not created");
        //logout
        mainPage.openUserMenu();
        mainPage.clickLogout();
        cleanUp();
    }
    @Test(priority = 2)
    @Description("Test of the task closing")
    public void closeTask(){
        setUpChrome();
        //sign in and open the tasks
        signIn.signInDynamically(userName, userPassword);
        mainPage.clickOnMyTasks();
        //open the task
        mainPage.openTask();
        //close this task
        taskBody.clickCloseThisTaskButton();
        new CloseTask().clickConfirmToCloseTask();
        //go to dashboard
        taskBody.goToDashboard();
        Assert.assertEquals(mainPage.getTextOfEmptyTasks(), "There is nothing assigned to you.", "The tasks list is not empty");
        //logout
        mainPage.openUserMenu();
        mainPage.clickLogout();
        cleanUp();
        //clean project and user
        addProjectToUser.deleteProjectToUser(newUserId, newProjectId);
        projectCreate.deleteProject(newProjectId);
        userCreate.deleteUser(newUserId);
    }

}

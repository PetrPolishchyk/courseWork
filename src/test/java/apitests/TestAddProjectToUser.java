package apitests;

import apiobjects.CreateRequest;
import apiobjects.Params;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAddProjectToUser extends BasicAPIConfiguration{
    private Integer newProjectId = 0;
    private Integer newUserId = 0;

    TestUserCreate testUserCreate = new TestUserCreate();
    TestProjectCreate testProjectCreate = new TestProjectCreate();

    @Test(priority = 0)
    @Description("Test of adding a new user to new project")
    public void addNewUserToNewProject(){
        newUserId = testUserCreate.createUser("User7", "102366");
        newProjectId = testProjectCreate.createProject("Project from test creation", 5);
        Assert.assertTrue(addProjectToUser(newUserId, newProjectId));
    }
    @Test(priority = 1)
    @Description("Test of removing a new user from new project")
    public void removeNewUserFromNewProject(){
        Assert.assertTrue(deleteProjectToUser(newUserId, newProjectId));
        testUserCreate.deleteUser(newUserId);
        testProjectCreate.deleteProject(newProjectId);
    }

    @Step("Add the project to the user")
    public Boolean addProjectToUser(Integer userId, Integer projectId){
        CreateRequest addProjectToUser = new CreateRequest().builder()
                .jsonrpc("2.0")
                .method("addProjectUser")
                .id("1797076613")
                .params(Params.builder().project_id(projectId).user_id(userId).role("project-viewer").build())
                .build();
        Response response = RestAssured.given()
                .auth().basic(getUserAdmin(), getToken())
                .body(addProjectToUser)
                .post(BASE_URL);
        response.prettyPrint();
        return response.jsonPath().get("result");
    }

    @Step("Delete the link between project and user")
    public Boolean deleteProjectToUser(Integer userId, Integer projectId){
        CreateRequest removeProjectToUser = new CreateRequest().builder()
                .jsonrpc("2.0")
                .method("removeProjectUser")
                .id("1797076613")
                .params(Params.builder().project_id(projectId).user_id(userId).build())
                .build();
        Response response = RestAssured.given()
                .auth().basic(getUserAdmin(), getToken())
                .body(removeProjectToUser)
                .post(BASE_URL);
        response.prettyPrint();
        return response.jsonPath().get("result");
    }
}

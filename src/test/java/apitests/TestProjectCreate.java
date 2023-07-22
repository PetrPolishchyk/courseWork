package apitests;

import apiobjects.CreateRequest;
import apiobjects.Params;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

// 3. Створення та видалення проекту.
public class TestProjectCreate extends BasicAPIConfiguration{
    private Integer newProjectId = 0;

    @Test(priority = 0)
    @Description("Create a new Project test")
    public void createNewProject(){
        newProjectId = createProject("Test project creation", 5);
        Assert.assertNotSame(newProjectId, 0, "New Project was not created");
    }
    @Test(priority = 1)
    @Description("Delete the created Project test")
    public void deleteNewProject(){
        Assert.assertTrue(deleteProject(newProjectId));
    }

    public Integer createProject(String projectName, Integer owner){
        CreateRequest newProject = new CreateRequest().builder()
                .jsonrpc("2.0")
                .method("createProject")
                .id("1797076613")
                .params(Params.builder().name(projectName).description("test project description")
                        .owner_id(owner).identifier("IDENTR").build())
                .build();
        Response response = RestAssured.given()
                .auth().basic(getUserAdmin(), getToken())
                .body(newProject)
                .post(BASE_URL);
        response.prettyPrint();
        return response.jsonPath().get("result");
    }

    public Boolean deleteProject(Integer projectId){
        new CreateRequest();
        CreateRequest deleteProject = CreateRequest.builder()
                .jsonrpc("2.0")
                .method("removeProject")
                .id("1518863035")
                .params(Params.builder().project_id(projectId).build())
                .build();
        Response response = RestAssured.given()
                .auth().basic(getUserAdmin(), getToken())
                .body(deleteProject)
                .post(BASE_URL);
        response.prettyPrint();
        return response.jsonPath().get("result");
    }
}

package apitests;

import apiobjects.CreateRequest;
import apiobjects.Params;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.apache.commons.lang3.ObjectUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestProjectCreate extends BasicAPIConfiguration{
    private Integer newProjectId = 0;

    @Test(priority = 0)
    @Description("Create a new Project test")
    public void createNewProject(){
        newProjectId = createProject("Test project creation");
        Assert.assertNotSame(newProjectId, 0, "New Project was not created");
    }
    @Test(priority = 1)
    @Description("Delete the created Project test")
    public void deleteNewProject(){
        Assert.assertTrue(deleteProject(newProjectId));
    }

    public Integer createProject(String projectName){
        CreateRequest newProject = new CreateRequest().builder()
                .jsonrpc("2.0")
                .method("createProject")
                .id("1797076613")
                .params(Params.builder().name(projectName).description("test project description")
                        .owner_id(5).identifier("IDENTR").build())
                .build();
        Response response = RestAssured.given()
                .auth().basic(getUSER_ADMIN(), getTOKEN())
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
                .auth().basic(getUSER_ADMIN(), getTOKEN())
                .body(deleteProject)
                .post(BASE_URL);
        response.prettyPrint();
        return response.jsonPath().get("result");
    }
}

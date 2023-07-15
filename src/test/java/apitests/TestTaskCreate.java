package apitests;

import apiobjects.CreateRequest;
import apiobjects.Params;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestTaskCreate extends BasicAPIConfiguration {

    private Integer projectId = 1;
    private Integer newTaskId = 0;

    TestUserCreate testUserCreate = new TestUserCreate();
    TestProjectCreate testProjectCreate = new TestProjectCreate();


    @Test(priority = 0)
    @Description("Create new task test")
    public void createNewTask(){
        newTaskId = createTask("New task", projectId);
        Assert.assertNotSame(newTaskId, 0, "New task was not created");
    }
    @Test(priority = 1)
    @Description("Remove the task test")
    public void removeTaskTest(){
        Assert.assertTrue(deleteTask(newTaskId));
    }

    public Integer createTask(String title, Integer projectId){
        CreateRequest newTask = new CreateRequest().builder()
                .jsonrpc("2.0")
                .method("createTask")
                .id("1176509098")
                .params(Params.builder().owner_id(1)
                        .creator_id(0).description("test").category_id(0)
                        .score(0).title(title).project_id(projectId)
                        .color_id("Green").column_id(0).recurrence_status(0)
                        .recurrence_trigger(0).recurrence_factor(0).recurrence_timeframe(0)
                        .recurrence_basedate(0).build())
                .build();
        Response response = RestAssured.given()
                .auth().basic(getUSER_ADMIN(), getTOKEN())
                .body(newTask)
                .post(BASE_URL);
        response.prettyPrint();
        return response.jsonPath().get("result");
    }

    public Boolean deleteTask(Integer taskId){
        new CreateRequest();
        CreateRequest deleteTask = CreateRequest.builder()
                .jsonrpc("2.0")
                .method("removeTask")
                .id("1518863035")
                .params(Params.builder().task_id(taskId).build())
                .build();
        Response response = RestAssured.given()
                .auth().basic(getUSER_ADMIN(), getTOKEN())
                .body(deleteTask)
                .post(BASE_URL);
        response.prettyPrint();
        return response.jsonPath().get("result");
    }
}

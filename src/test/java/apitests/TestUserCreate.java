package apitests;

import apiobjects.CreateRequest;
import apiobjects.Params;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

// 1. Створення та видалення користувача
public class TestUserCreate extends BasicAPIConfiguration {
    private Integer newUserId = 0;

    @Test(priority = 0)
    @Description("Create a new user test")
    public void createUserTest(){
        newUserId = createUser("UserTestP", "450d870");
        Assert.assertNotSame(newUserId, 0, "New user was not created");
    }
    @Test(priority = 1)
    @Description("Delete the created user test")
    public void deleteUserTest(){
        Assert.assertTrue(deleteUser(newUserId));
    }

    public Integer createUser(String username, String password){
        new CreateRequest();
        CreateRequest createNewUser = CreateRequest.builder()
                .jsonrpc("2.0")
                .method("createUser")
                .id("1518863035")
                .params(Params.builder()
                        .username(username)
                        .password(password)
                        .name(username)
                        .email(username + "@gmail.com")
                        .role("app-admin").build())
                .build();
        Response response = RestAssured.given()
                .auth().basic(getUserAdmin(), getToken())
                .body(createNewUser)
                .post(BASE_URL);
        response.prettyPrint();
        return response.jsonPath().get("result");
    }

    public Boolean deleteUser(Integer userId){
        new CreateRequest();
        CreateRequest createRequest = CreateRequest.builder()
                .jsonrpc("2.0")
                .method("removeUser")
                .id("1518863035")
                .params(Params.builder().user_id(userId).build())
                .build();
        Response response = RestAssured.given()
                .auth().basic(getUserAdmin(), getToken())
                .body(createRequest)
                .post(BASE_URL);
        response.prettyPrint();
        return response.jsonPath().get("result");
    }
}

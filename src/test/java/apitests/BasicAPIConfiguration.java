package apitests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;

public class BasicAPIConfiguration {
    private final String USER_ADMIN = "jsonrpc";
    private final String TOKEN = "5224cf739fb64619065df66162ad96de2b1822585411538251dbee3136f8";
    public final String BASE_URL = "http://localhost:80/jsonrpc.php";

    public String getUSER_ADMIN() {
        return USER_ADMIN;
    }

    public String getTOKEN() {
        return TOKEN;
    }
}

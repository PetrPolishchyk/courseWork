package apitests;

public class BasicAPIConfiguration {
    private String userAdmin = "jsonrpc";
    private String token = "5224cf739fb64619065df66162ad96de2b1822585411538251dbee3136f8";
    public final String BASE_URL = "http://localhost:80/jsonrpc.php";

    public String getUserAdmin() {
        return userAdmin;
    }

    public String getToken() {
        return token;
    }
}

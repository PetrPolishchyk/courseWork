package baseclasses;

import org.testng.annotations.DataProvider;

public class DataProviders {
    @DataProvider(name = "systemExistUsers")
    public Object[][] systemExistUsers(){
        return new Object[][] {{"admin", "admin"},
                {"Peter", "PeterPol"},
                {"Alex", "AlexPass"}};
    }
}

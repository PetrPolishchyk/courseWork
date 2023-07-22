package baseclasses;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.Parameters;

public class BaseWorkingClass {
    public void setUpChrome(){
        Configuration.browser = "chrome";
        Selenide.open("http://localhost/login");
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }
    public void setUpFirefox(){
        Configuration.browser = "firefox";
        Selenide.open("http://localhost/login");
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }
    public void setUpChromeHeadless(){
        Configuration.browser = "chrome";
        Configuration.headless = true;
        Selenide.open("http://localhost/login");
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }
    public void cleanUp(){
        Selenide.closeWindow();
        Selenide.closeWebDriver();
    }

    public void setUpDinamicallyBrowser(){
        String browserType = System.getProperty("browser");
        if (browserType == "chrome"){
            Configuration.browser = "chrome";
        } else if (browserType == "firefox"){
            Configuration.browser = "firefox";
        } else {
            Configuration.browser = "chrome";
            Configuration.headless = true;
        }
        Selenide.open("http://localhost/login");
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }
}

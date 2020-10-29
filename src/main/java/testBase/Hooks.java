package testBase;

import io.github.bonigarcia.wdm.WebDriverManagerException;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.Before;
import cucumber.api.java.After;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.SeleniumDriver;

public class Hooks {
    static WebDriver driver = null;
    static String browser = "chrome";
    static String baseUrl = "https://takemuch.co.za/index.php?route=common/home";

    @Before(value = "@rest")
    public static void setAPI() {
        System.out.println("The BEFORE HOOKS will runs After Background and Scenarios --REST");
       // baseUrl=restAPI;
    }

    @Before(value = {"@web2","@regression"})
    public static void setWeb() throws WebDriverManagerException {
        System.out.println("The BEFORE HOOKS will runs After Background and Scenarios--WEB");
        WebDriverManager.chromedriver().setup();
        SeleniumDriver.launchBrowser(browser,baseUrl);
    }



    WebDriver getDriver(){
        return driver;
    }
    @After
    public void tearDown() throws WebDriverException {
        try {
            System.out.println("The AFTER HOOKS will runs After Background and Scenarios");
            Thread.sleep(2000);
            getDriver().close();
        } catch (WebDriverException ex) {
            System.out.println(ex.getAdditionalInformation());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }catch (NullPointerException nullPointerException){
            System.out.println("closing browser");
        }
    }
}

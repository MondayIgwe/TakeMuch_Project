package testBase;

import cucumber.api.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriver_Factory {

    public WebDriver driver;
    WebDriverWait webDriverWait;
    static String restAPI = "https://reqres.in/api/";
    public WebDriver_Factory(WebDriver driver){
        this.driver=driver;
    }

    /**
     * * This function is to invoke Selenium Webdriver
     * *
     * * @throws MalformedURLException
     * * @throws InterruptedException
     */

    public void launchBrowser(final String browserID, String baseUrlID) throws WebDriverException {
        if (browserID.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            driver.get(baseUrlID);
            driver.manage().window().maximize();
        } else if (browserID.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else {
            System.out.println("Invalid Browser:'");
        }
    }

    public WebDriver getDriver(){
        return driver;
    }

}

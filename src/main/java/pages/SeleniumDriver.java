package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumDriver {

    static WebDriver driver;
    WebDriverWait webDriverWait;
    static String restAPI = "https://reqres.in/api/";

    /**
     * * This function is to invoke Selenium Webdriver
     * *
     * * @throws MalformedURLException
     * * @throws InterruptedException
     */
    public static void launchBrowser(final String browserID, String baseUrlID) throws WebDriverException {
        if (browserID.equalsIgnoreCase("chrome")) {
            openURL(baseUrlID);
        } else if (browserID.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
            openURL(baseUrlID);
        } else {
            System.out.println("Invalid Browser:'");
        }
    }

    static void openURL(String baseUrlID) throws WebDriverException {
        driver = new ChromeDriver();
        driver.get(baseUrlID);
        driver.manage().window().maximize();
    }
}

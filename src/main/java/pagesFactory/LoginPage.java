package pagesFactory;
import static org.junit.Assert.assertEquals;

import commonLibs.HelperUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testBase.WebDriver_Factory;

public class LoginPage extends WebDriver_Factory {
    /**
     * All locators will be mentioned here
     *
     * For this example i am not using properties file for
     reading locators
     */

    By topLink = By.xpath("//*[@id='top-links']/ul");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void caller() throws Exception {
        setTopLink();
    }

    void setTopLink() throws Exception {
        WebElement ele = getDriver().findElement(topLink);
        HelperUtilities.highLighterMethod(getDriver(),ele);
    }



}

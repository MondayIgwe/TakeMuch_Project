package AppiumFactory;
import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumFactory {
    public static AndroidDriver androidDriver;
    public static WebDriverWait webDriverWait;

    /**
     * This function is to invoke Appium
     *
     * @throws MalformedURLException
     * @throws InterruptedException
     */

    public void createDriver()throws MalformedURLException{
        try {
            final File classRootPath = new File(System.getProperty("user.dir"));
            final File appDir = new File(classRootPath, "src/main/resources/apk");
            final File apk = new File(appDir, "ApiDemos-debug");

            final DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("deviceName", "Android Emulator");
            capabilities.setCapability("platformVersion", "4.4");
            capabilities.setCapability("apk", apk.getAbsoluteFile());
            androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        }catch (Exception fi){
            throw (fi);
        }
    }
}

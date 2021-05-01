package autotest;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.net.MalformedURLException;

public class TestUtilities {
    public static RemoteWebDriver driver;
    public static DesiredCapabilities capabilities;
    public void launchBrowser(){
        try {
            capabilities = new DesiredCapabilities();
            capabilities.setBrowserName("chrome");
            driver = new RemoteWebDriver(new URL("http://hub:4444/wd/hub"), capabilities);
            driver.manage().window().maximize();
        }catch(MalformedURLException ex){
            System.out.println("URL malformed");
        }
    }

    public void tearDown() {
        driver.quit();
    }

}

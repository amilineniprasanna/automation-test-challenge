package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.net.MalformedURLException;

public class Hooks {
    public static RemoteWebDriver driver;
    public static DesiredCapabilities capabilities;

    @After
    public void afterScenario(Scenario scenario) {
        scenario.attach(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES), "image/png", scenario.getName());
        driver.close();
        driver.quit();
    }

   @Before
    public void beforeScenario() {
        try {
            capabilities = new DesiredCapabilities();
            capabilities.setBrowserName("chrome");
            driver = new RemoteWebDriver(new URL("http://hub:4444/wd/hub"), capabilities);
            driver.manage().window().maximize();
        }catch(MalformedURLException ex){
            System.out.println("URL malformed");
        }
    }

}

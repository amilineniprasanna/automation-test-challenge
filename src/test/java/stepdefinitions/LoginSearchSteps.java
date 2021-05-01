package autotest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.junit.Assert.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import java.util.concurrent.TimeUnit;

public class LoginSearchSteps extends TestUtilities {
    public static WebDriverWait wait;

    @Before
    public void beforeScenario() {
        launchBrowser();
    }

    @Given("user is on login page")
    public void user_is_on_login_page() {
        driver.get("https://login.wordpress.org/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,30);
    }

    @When("enters username {string} password {string} and clicks login")
    public void login(String username, String password) {
        driver.findElement(By.id("user_login")).sendKeys(username);
        driver.findElement(By.id("user_pass")).sendKeys(password);
        driver.findElement(By.id("wp-submit")).click();
    }

    @Then("user should be able to perform search")
    public void verifyHomepage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("global-search"))).sendKeys("test\n");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("resInfo-0")));
    }

    @Then("it should display login error")
    public void verifyLoginError() {
        assertTrue("Login error expected", wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login_error-0"))).isDisplayed());
    }

    @After
    public void afterScenario() {
        tearDown();
    }
}

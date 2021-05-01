package autotest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:tatget/cucumber-report.html"}, features = "src/test/resources/autotest")
public class CucumberRunner {

}

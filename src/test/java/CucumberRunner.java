import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/cucumber-report.html"},  glue = {"stepdefinitions"}, features = {"src/test/resources/uifeatures"})
public class CucumberRunner {

}

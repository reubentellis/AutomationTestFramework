package runners;
import org.junit.Before;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/features/"
        , glue = {"stepDefinitions"}
         //, tags =  {"@LoginTests"}
         ,tags =  {"@SecondScenario"}
        ,plugin = { "pretty", "html:target/cucumber-reports" }
        //, tags =  {"@End2End"}
        , monochrome = true
)
public class TestRunner
{

}

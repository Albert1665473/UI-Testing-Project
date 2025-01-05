
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/searchnearshops.feature", glue = "steps")
public class RunSearchNearShopsTest extends AbstractTestNGCucumberTests{
}

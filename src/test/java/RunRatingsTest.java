
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/seeratings.feature", glue = "steps")
public class RunRatingsTest extends AbstractTestNGCucumberTests{
	
}

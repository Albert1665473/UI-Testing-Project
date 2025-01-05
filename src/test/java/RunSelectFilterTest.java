import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/selectfilter.feature", glue = "steps")
public class RunSelectFilterTest extends AbstractTestNGCucumberTests{
	
}

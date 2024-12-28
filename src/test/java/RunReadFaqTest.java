import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/readfaq.feature", glue = "steps")
public class RunReadFaqTest extends AbstractTestNGCucumberTests{
}

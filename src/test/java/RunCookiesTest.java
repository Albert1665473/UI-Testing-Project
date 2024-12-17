import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/acceptcookies.feature", glue = "steps")
public class RunCookiesTest extends AbstractTestNGCucumberTests{
}

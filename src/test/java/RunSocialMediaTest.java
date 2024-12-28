import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/socialmedia.feature", glue = "steps")
public class RunSocialMediaTest extends AbstractTestNGCucumberTests{
}

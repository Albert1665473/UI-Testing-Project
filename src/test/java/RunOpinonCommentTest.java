import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/opinioncomment.feature", glue = "steps")
public class RunOpinonCommentTest extends AbstractTestNGCucumberTests{
}

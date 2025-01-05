import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/discountedsection.feature", glue = "steps")
public class RunDiscountedSectionTest extends AbstractTestNGCucumberTests{
}

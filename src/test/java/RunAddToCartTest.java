import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/addtocart.feature", glue = "steps")
public class RunAddToCartTest extends AbstractTestNGCucumberTests{
}

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/searchbycaterogy.feature", glue = "steps")
public class RunSearchCategoryTest extends AbstractTestNGCucumberTests{

}

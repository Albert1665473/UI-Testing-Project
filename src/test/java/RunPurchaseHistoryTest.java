import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/purchasehistory.feature", glue = "steps")
public class RunPurchaseHistoryTest extends AbstractTestNGCucumberTests{
}
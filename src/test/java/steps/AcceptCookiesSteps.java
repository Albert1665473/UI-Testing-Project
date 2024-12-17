package steps;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AcceptCookiesSteps {
	static WebDriver driver;
	
	@Given("the user is in the home page")
	public static void theUserIsInTheHomePage() {
		System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.navigate().to("https://www.pccomponentes.com");
	}
	
	@When("the user clicks in the accept cookies option")
	public void theUserClicksInTheAcceptCookiesOption() {
		driver.findElement(By.id("cookiesAcceptAll")).click();
	}
	
	@Then("the home page appears")
	public void theHomePageAppears() {
		WebElement body = driver.findElement(By.id("root"));
		assertTrue(body != null);
		
		WebElement header = driver.findElement(By.id("header-top"));
		assertTrue(header != null);
				
		WebElement div1 = driver.findElement(By.xpath("/html/body/div[2]/div[1]"));
		assertTrue(div1 != null);
		
		WebElement div2 = driver.findElement(By.xpath("/html/body/div[2]/main"));
		assertTrue(div2 != null);
	}
	
	@Then("the accept cookies box disappears")
	public void theAcceptCookiesBoxDisappears() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
		
		Boolean cookies =  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("cookiesAcceptAll")));
		assertTrue(cookies);
	}
	
	public static WebDriver getDriver() {
		if(driver == null) {
			theUserIsInTheHomePage();
		}
		return driver;
	}
	
}

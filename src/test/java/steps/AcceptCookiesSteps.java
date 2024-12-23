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
		driver.navigate().to("https://www.decathlon.es/es/");
	}
	
	@When("the user clicks in the accept cookies option")
	public void theUserClicksInTheAcceptCookiesOption() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("didomi-notice-agree-button")));
		
		driver.findElement(By.id("didomi-notice-agree-button")).click();
	}
	
	@Then("the home page appears")
	public void theHomePageAppears() {
		WebElement body = driver.findElement(By.xpath("/html/body/div[2]/main"));
		assertTrue(body != null);
		
		WebElement header = driver.findElement(By.id("header"));
		assertTrue(header != null);
				
		WebElement div1 = driver.findElement(By.id("Productos-recomendados-home"));
		assertTrue(div1 != null);
		
		WebElement div2 = driver.findElement(By.xpath("/html/body/div[2]/main/section[8]/div"));
		assertTrue(div2 != null);
		
		WebElement footer = driver.findElement(By.xpath("/html/body/div[2]/footer"));
		assertTrue(footer != null);
	}
	
	@Then("the accept cookies box disappears")
	public void theAcceptCookiesBoxDisappears() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
		Boolean cookies =  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("didomi-notice-agree-button")));
		assertTrue(cookies);
	}
	
	public static WebDriver getDriver() {
		if(driver == null) {
			theUserIsInTheHomePage();
		}
		return driver;
	}
	
}

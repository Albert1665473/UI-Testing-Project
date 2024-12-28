package steps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SocialMediaSteps {
	
	WebDriver driver = AcceptCookiesSteps.getDriver();
	
	@When("clicks on the intagram social media")
	public void clicksOnTheIntagramSocialMedia() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		
		driver.findElement(By.xpath("/html/body/div[2]/footer/section/div[3]/section/div[2]/div/div[1]/span/a/span")).click();
	}
	
	@Then("the decathlon instagram appears")
	public void thDecathlonInstagramAppears() throws InterruptedException {

		// Guardar l'identificador de la pestanya actual
		String originalTab = driver.getWindowHandle();

		// Esperar que s'obri la nova pestanya
		Set<String> allTabs = driver.getWindowHandles();
		for (String tab : allTabs) {
		    if (!tab.equals(originalTab)) {
		        // Canviar el control a la nova pestanya
		        driver.switchTo().window(tab);
		        break;
		    }
		}

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[5]/div[1]/div/div[2]/div/div/div/div/div[2]/div/button[1]")));
		
		driver.findElement(By.xpath("/html/body/div[5]/div[1]/div/div[2]/div/div/div/div/div[2]/div/button[1]")).click();
		
		Thread.sleep(3000);

		WebElement instagramName = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div[1]/div[2]/div/div[2]/section/main/div/header/section/div[1]/div[1]/h2"));
		assertTrue(instagramName != null);
		
		String i = instagramName.getText();
		assertEquals("decathlon_espana", i);
		
		WebElement posts = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div[1]/div[2]/div/div[2]/section/main/div/div[3]"));
		assertTrue(posts != null);
	}
	
}

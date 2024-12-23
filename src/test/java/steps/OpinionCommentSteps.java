package steps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OpinionCommentSteps {
	WebDriver driver = AcceptCookiesSteps.getDriver();	
	
	@When("the user clicks on the lateral button")
	public void theUserClicksOnTheLateralButton() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nebula_div_btn")));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("nebula_div_btn")));
		
		WebElement commentLabel = driver.findElement(By.id("nebula_div_btn"));
		commentLabel.click();
	}
	
	@Then("the form appears at the lateral")
	public void theFormAppearsAtTheLateral() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("KampyleAnimationContainer")));
	
		WebElement lateralIframe = driver.findElement(By.id("kampyleFormAnimation19335"));
		assertTrue(lateralIframe != null);
	}
	
	@When("the user does the form")
	public void theUserDoesTheForm() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement iframeElement = driver.findElement(By.id("kampyleFormAnimation19335"));
		driver.switchTo().frame(iframeElement);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/form")));
		
		driver.findElement(By.xpath("/html/body/div/form/main/fieldset[3]/div/div[1]/div[4]")).click();
		
		driver.findElement(By.id("466315")).click();
		
		driver.findElement(By.xpath("/html/body/div/form/main/fieldset[4]/div/select/option[3]")).click();
		
		driver.findElement(By.xpath("/html/body/div/form/main/fieldset[5]/span/ul/li[1]/label/span[1]")).click();
		
		WebElement text = driver.findElement(By.id("466347"));
		
		text.clear();
		
		text.sendKeys("He notado que en ocasiones la disponibilidad de ciertos productos populares es limitada. "
				+ "Quizá un sistema de reserva o una mayor previsión de stock podría ser útil para asegurar "
				+ "que los clientes encuentren lo que buscan.");
	}
	
	@When("the user sends the form")
	public void theUserSendsTheForm() {
		
		driver.findElement(By.xpath("/html/body/div/form/footer/div[1]/div[2]/button")).click();
	}
	
	@Then("the opinion comment is sent")
	public void theOpinionCommentIsSent() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/form/main/div")));

		WebElement thankMsg = driver.findElement(By.xpath("/html/body/div/form/main/div/div[2]/div/p/span"));
		assertTrue(thankMsg != null);
		
		String t = thankMsg.getText();
		assertEquals("¡Gracias por compartir tus comentarios con nosotros!", t);
		
		WebElement closeButton = driver.findElement(By.xpath("/html/body/div/form/footer/div[1]/div/button"));
		assertTrue(closeButton != null);
		
		closeButton.click();
	}
}

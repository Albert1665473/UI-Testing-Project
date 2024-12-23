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

public class RegisterSteps {
	
	WebDriver driver = AcceptCookiesSteps.getDriver();
	
	@When("the user clicks on register button")
	public void theUserClicksOnRegisterButton() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[2]/div/div[1]")));
		
		driver.findElement(By.id("create-account")).click();
	}
	
	@Then("the user is at the sign in page")
	public void theUserIsAtTheSignInPage() {
		//Esperem a que carregui la pagina de login
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[2]/div/div[1]/div")));
		
		//Comporvem que l'apartat de introduir el correu es mostra correctament
		WebElement LoginSection = driver.findElement(By.id("content_page"));
		assertTrue(LoginSection != null);
		
		WebElement form = driver.findElement(By.id("form-sign-up"));
		assertTrue(form != null);
	
		WebElement mailSection = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[2]/div/div[1]/div/form/div[1]/div/label"));
		assertTrue(mailSection != null);
		
		String m = mailSection.getText();
		assertEquals("Correo electrónico", m);
		
		WebElement register = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[2]/div/div[1]/div/div[1]/h3"));
		assertTrue(register != null);
		
		String s = register.getText();
		assertEquals("Crea tu cuenta", s);
				
	}
	
	@When("the user registers his email")
	public void theUserRegistersHisEmail() throws InterruptedException {

		driver.findElement(By.id("input-email")).click();;
		
		WebElement email = driver.findElement(By.id("input-email"));
		
		email.clear();
		
		email.sendKeys("albert.vacass@gmail.com");
		
		driver.findElement(By.id("lookup-btn-signup")).click();
		
	}
	
	@When("the user creates a password")
	public void theUserCreatesAPassword() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[2]/div/div[1]/form/div/div[1]/div")));
		
		WebElement password = driver.findElement(By.id("input-password"));
		password.click();
		
		password.clear();
		
		password.sendKeys("UI-Testing2");

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[2]/div/div[1]/form/button")));
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[2]/div/div[1]/form/button")).click();
	}
	
	@Then("the user has to accept the terms")
	public void theUserHasToAcceptTheTerms() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("global-consents")));
		
		WebElement text = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[2]/div/div[1]/div[1]/h1"));
		assertTrue(text != null);
		
		String t = text.getText();
		assertEquals("¡Casi lo tienes!", t);
		
		WebElement terms = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[2]/div/div[1]/div[2]/div/div/div/div[1]/label"));
		assertTrue(terms != null);
		
		String e = terms.getText();
		assertEquals("RECIBIRÁS POR MAIL TUS CHEQUES DE DESCUENTO E INFORMACIÓN DE EVENTOS "
				+ "Y NOVEDADES SOBRE NUESTROS PRODUCTOS Y SERVICIOS.", e);
		
		WebElement button = driver.findElement(By.id("consents-button-submit"));
		assertTrue(button != null);
		
	}
	

}

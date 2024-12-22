package steps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogInSteps {
	WebDriver driver = AcceptCookiesSteps.getDriver();
	
	WebElement contrasenyaIncorrecta = null;
	
	@When("the user clicks in the account button")
	public void theUserClicksInTheAccountButton() {
		driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/nav/ul/li[3]/div/a")).click();
	}
	
	@Then("the user is at the login page")
	public void theUserIsAtTheLoginPage() {
		
		//Esperem a que carregui la pagina de login
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[2]/div/div[1]")));
		
		//Comporvem que l'apartat de introduir el correu es mostra correctament
		WebElement LoginSection = driver.findElement(By.id("content_page"));
		assertTrue(LoginSection != null);
		
		WebElement form = driver.findElement(By.id("form-sign-in"));
		assertTrue(form != null);
	
		WebElement mailSection = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[2]/div/div[1]/form/div[1]/div/label"));
		assertTrue(mailSection != null);
		
		String m = mailSection.getText();
		assertEquals("Correo electrónico", m);
		
	}

	@When("the user enters the correct email")
	public void theUserEntersTheCorrectEmail() {
		driver.findElement(By.id("input-email")).click();
		
		WebElement search = driver.findElement(By.id("input-email"));

		search.clear();
		search.sendKeys("albeert.vm8@gmail.com");
		
		if(!driver.findElements(By.id("lookup-btn")).isEmpty()) {
			driver.findElement(By.id("lookup-btn")).click();
		}
	}
	
	@When("the user enters the correct password")
	public void theUseEntersTheCorrectPassword() {
		
		//Esperem a que carregui el camp d'introduïr contrasenya
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[2]/div/div[1]/form/div[2]")));
		
		WebElement search = driver.findElement(By.id("input-password"));

		search.clear();
		search.sendKeys("UI-Test4");
		
		driver.findElement(By.id("signin-button")).click();
		
	}
	
	@Then("the login was made successfuly")
	public void theLoginWasMadeSuccessfuly() {
		
		//Esperem a que carregui el camp de configuració de perfil
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/div/section/section/div")));
		
		WebElement WelcomeSection = driver.findElement(By.xpath("/html/body/div[2]/main/div/section/section/div"));
		assertTrue(WelcomeSection != null);
		
		WebElement WelcomeMssg = driver.findElement(By.xpath("/html/body/div[2]/main/div/section/section/div/div/h1"));
		assertTrue(WelcomeMssg != null);
		
		String w = WelcomeMssg.getText();
		assertEquals("¡Bienvenido/a!", w);
		
		WebElement AccountInfo = driver.findElement(By.id("accountComplete"));
		assertTrue(AccountInfo != null);
		
	}
	
	@When("the user enters the wrong email")
	public void theUserEntersTheWrongEmail() {
		
		driver.findElement(By.id("input-email")).click();
		
		WebElement search = driver.findElement(By.id("input-email"));

		search.clear();
		search.sendKeys("wrongemail@gmail.com");
		
		driver.findElement(By.id("lookup-btn")).click();
		
	}
	
	@Then("the email is not correct")
	public void theEmailIsNotCorrect() {
		
		//Esperem a que carregui el camp de error
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[2]/div/div[1]/form/div[1]/div/div[2]/p")));
		
		//Comporvem que el missatge d'error s'imprimeix correctament
		WebElement error = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[2]/div/div[1]/form/div[1]/div/div[2]/p"));
		assertTrue(error != null);
		
		String e = error.getText();
		assertEquals("No podemos encontrar ninguna cuenta con este correo electrónico. "
				+ "Inicia sesión con otra dirección de correo electrónico o puedes crear una cuenta.", e);
	}

	@When("the user enters the wrong password")
	public void theUserEntersTheWrongPassword() {
		//Esperem a que carregui el camp d'introduïr contrasenya
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[2]/div/div[1]/form/div[2]/div[1]")));
		
		driver.findElement(By.id("input-password")).click();
		WebElement search = driver.findElement(By.id("input-password"));

		search.clear();
		search.sendKeys("password1234");
	    
		driver.findElement(By.id("signin-button")).click();
		
				
	}
	
	@Then("the password is not correct")
	public void thePasswordIsNotCorrect() {
		
		/*
		WebElement error = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[2]/div/div[1]/form/div[2]/div[2]/p"));
		assertTrue(error != null);
				
		String e = error.getText();
		assertEquals("Contraseña no válida", e);
		*/
		
		//Comprovem que la pagina de modificació de dades del compte que es mostra despres d'iniciar sessió no es visible
		boolean accountLogged = driver.findElements(By.id("accountComplete")).isEmpty();
		assertTrue(accountLogged);
		
		//Comporvem que la pagina de login es torna a mostrar ja que la contraseña es incorrecte
		boolean loginForm = driver.findElements(By.id("form-sign-in")).isEmpty();
		assertFalse(loginForm);
		
	}
}

package steps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ReadFaqSteps {
	WebDriver driver = AcceptCookiesSteps.getDriver();
	
	@When("the user clicks on the FAQ button")
	public void theUserClicksOnTheFAQButton(){
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		
		WebElement help = driver.findElement(By.xpath("/html/body/div[2]/footer/section/div[2]/section/div/div[2]/div[2]/div/div[1]/span/a"));
		help.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/main/section[5]/section/span/button")));
		
		js.executeScript("window.scrollTo(0, 600);");
		
		driver.findElement(By.xpath("/html/body/div[2]/main/section[5]/section/span/button")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cp-iframe")));
		
		WebElement iFrame = driver.findElement(By.id("cp-iframe"));
		driver.switchTo().frame(iFrame);
	}
	
	@Then("the FAQ forum shows")
	public void theFAQForumShows() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rn_TopAnswers_6")));
		
		WebElement title = driver.findElement(By.xpath("/html/body/div[4]/h1"));
		assertTrue(title != null);
		
		String t = title.getText();
		assertEquals("¿Cómo podemos ayudarte?", t);
		
		WebElement search = driver.findElement(By.id("rn_search_box_5_SearchForm"));
		assertTrue(search != null);
		
		WebElement question = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div[1]/div[2]/ul/div/li[1]/a/div"));
		assertTrue(question != null);
		
		String q = question.getText();
		assertEquals("¿Cómo puedo solicitar el alquiler de un producto en suscripción?", q);
		
		WebElement FAQ = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div[1]/div[1]/h2"));
		assertTrue(FAQ != null);
		
		String f = FAQ.getText();
		assertEquals("Preguntas frecuentes", f);
		
		WebElement contactHelp = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div[3]/div/div[1]/h2"));
		assertTrue(contactHelp != null);
		
		String c = contactHelp.getText();
		assertEquals("Contacta con el Centro Relación Usuario", c);
		
		WebElement primaryCategories = driver.findElement(By.id("rn_PrimaryCategories_7"));
		assertTrue(primaryCategories != null);
	}
	
	@When("the user consults one question")
	public void theUserConsultsOneQuestion() {
		
		driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div[1]/div[2]/ul/div/li[3]/a")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[2]/div[1]/div[2]/div/div[1]")));
		
	}
	
	@Then("the question shows")
	public void theQuestionShows() {
		
		WebElement question = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[1]/div[2]/div/h3"));
		assertTrue(question != null);
		
		String q = question.getText();
		assertEquals("¿Cómo puedo modificar mi pedido?", q);
		
		WebElement answer = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[1]/div[2]/div/div[1]/div[1]"));
		assertTrue(answer != null);
		
		String a = answer.getText();
		assertEquals("La modificación del pedido podrá llevarse a cabo siempre y cuando se trate de un cambio en la dirección de entrega y el estado de la preparación del pedido lo permita. En caso de necesitar cambiar un artículo deberás proceder con la cancelación del pedido y realizar una nueva compra. Puedes conocer el procedimiento de cancelación del pedido pinchando en el siguiente enlace ¿Cómo puedo cancelar mi pedido?.", a);
		
		WebElement contact = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[1]/div[2]/div/div[2]/div[2]/div/a"));
		assertTrue(contact != null);
		
		String c = contact.getText();
		assertEquals("CONTACTA CON NUESTRO EQUIPO", c);
		
		WebElement relatedAnswers = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[1]/div[4]/div/div[1]/h2"));
		assertTrue(relatedAnswers != null);
		
		String r = relatedAnswers.getText();
		assertEquals("Respuestas relacionadas", r);
		
		WebElement contactHelp = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[2]/div/div/div[1]/h2"));
		assertTrue(contactHelp != null);
		
		String h = contactHelp.getText();
		assertEquals("Contacta con el Centro Relación Usuario", h);
		
	}
	
}

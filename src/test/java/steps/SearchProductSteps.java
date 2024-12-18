package steps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchProductSteps {
	
	WebDriver driver = AcceptCookiesSteps.getDriver();
	
	@When("the user types the product in the search bar")
	public void theUserTypesTheProductInTheSearchBar() {
		
		driver.findElement(By.id("search_search_text")).click();
		
		WebElement search = driver.findElement(By.id("search_search_text"));

		search.clear();
		search.sendKeys("iphone 16 256gb");
	}
	
	@When("the user clicks the search button")
	public void theUserClicksTheSearchButton() {
		driver.findElement(By.xpath("/html/body/header/div[2]/div/div/form/div/div[2]/div[1]/button")).click();
	}
	
	
	@Then("the product list appears")
	public void theProductListAppears() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div/div[3]/div/div/div[2]/div[2]")));
		
		WebElement products = driver.findElement(By.xpath("/html/body/div[4]/div/div[3]/div/div/div[2]/div[2]"));
		WebElement ul = products.findElement(By.tagName("ul"));
		List<WebElement> links = ul.findElements(By.tagName("li"));
		assertFalse(links.isEmpty());
		
		WebElement h1 = driver.findElement(By.xpath("/html/body/div[4]/div/div[3]/div/div/div[2]/div[1]/div[1]"));
		assertTrue(h1 != null);
		
		String text = h1.getText();
		assertTrue(text.contains("Coinciden "));
		assertTrue(text.contains("artículos"));
		
		WebElement h2 = driver.findElement(By.xpath("/html/body/div[4]/div/div[1]"));
		assertTrue(h2 != null);
		
		String text2 = h2.getText();
		assertTrue(text2.contains("RESULTADOS PARA IPHONE 16 256GB"));
		
		WebElement results = driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/ul/li[1]/a"));
		assertTrue(results != null);
		
		String text3 = results.getText();
		assertTrue(text3.contains("29 PRODUCTOS"));

		
		boolean anyElementSearched = driver.findElements(By.xpath("/html/body/div[4]/div/div[2]/div")).isEmpty();
		assertTrue(anyElementSearched);
	
	}
	
	@When("the user clicks on product container")
	public void theUserClicksOnProductContainer() {
		
		//Esperem a que els elements resultants de la cerca carreguin
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div/div[3]/div/div/div[2]/div[2]")));
		
		driver.findElement(By.xpath("/html/body/div[4]/div/div[3]/div/div/div[2]/div[2]/ul/li[2]/div[2]/div[1]/div[1]/h3/a")).click();
	}
	
	@Then("the product detail info appears")
	public void theProductDetailInfoAppears() {
		
		//Esperem a que el product detail carregui
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]")));
		
		//Comprovem que existeix l'article
		WebElement offer = driver.findElement(By.id("activeOffer"));
		assertTrue(offer != null);
		
		//Comprovem que el titol apareix i es correcte
		WebElement title = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[1]/h1"));
		assertTrue(title != null);
		
		String text = title.getText();
		assertTrue(text.contains("Apple iPhone 16 Pro Max 256GB Negro Titanio ."));
		
		//Comprovem que el preu es el correcte i apareix
		WebElement price = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[2]/div[3]/aside/div[1]/div"));
		assertTrue(price != null);
		
		String p = price.getText();
		assertTrue(p.contains("1 461€95"));
		
		//Comprovem que la imatge carrega
		WebElement img = driver.findElement(By.id("ctl00_cphMainContent_ImgProduct"));
		assertTrue(img != null);
		
		//Comprovem que la descripció del producte apareix
		WebElement description = driver.findElement(By.id("description"));
		assertTrue(description != null);

		//Comprovem que el botó del carret apareix
		WebElement button = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[2]/div[3]/aside/div[2]/div[2]/button[1]"));
		assertTrue(button != null);
				
	}
	
}

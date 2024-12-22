package steps;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchProductSteps {
	
	WebDriver driver = AcceptCookiesSteps.getDriver();
	
	@When("the user types the product in the search bar")
	public void theUserTypesTheProductInTheSearchBar() {
		
		driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/nav/div[1]/div/form/div/input")).click();
		
		WebElement search = driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/nav/div[1]/div/form/div/input"));

		search.clear();
		search.sendKeys("powerade");
	}
	
	@When("the user clicks the search button")
	public void theUserClicksTheSearchButton() {
		driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/nav/div[1]/div/form/div/button")).click();
	}
	
	
	@Then("the product list appears")
	public void theProductListAppears() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/div[2]")));
		
		WebElement products = driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/section[2]/div"));
		List<WebElement> div = products.findElements(By.tagName("div"));
		assertFalse(div.isEmpty());
		
		WebElement resultsBanner = driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/div/div/div[1]"));
		assertTrue(resultsBanner != null);
		
		String text = resultsBanner.getText();
		assertTrue(text.contains("Resultados para:"));
		
		WebElement elementSearched = driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/div/div/div[2]/q"));
		assertTrue(elementSearched != null);
		
		String text2 = elementSearched.getText();
		assertTrue(text2.contains("powerade"));
		
		WebElement results = driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/div/div/div[3]/span"));
		assertTrue(results != null);
		
		String text3 = results.getText();
		assertTrue(text3.contains(" productos"));
		
		WebElement resultsNum = driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/section[2]/nav[1]/div[1]/div/span[2]"));
		assertTrue(resultsNum != null);
		
		String text4 = resultsNum.getText();
		assertTrue(text4.contains("Productos"));
		
		WebElement filters = driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/section[1]/div/div"));
		assertTrue(filters != null);
		
		boolean anyElementSearched = driver.findElements(By.xpath("/html/body/div[2]/main/div[1]/div/div/div[4]")).isEmpty();
		assertTrue(anyElementSearched);
	
	}
	
	@When("the user clicks on product container")
	public void theUserClicksOnProductContainer() {
		
		//Esperem a que els elements resultants de la cerca carreguin
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/div[2]/section[2]/div")));
		
		driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/section[2]/div/div[2]/div[3]/div[1]/div/a")).click();
	}
	
	@Then("the product detail info appears")
	public void theProductDetailInfoAppears() {
		
		//Esperem a que el product detail carregui
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main")));
		
		//Comprovem que existeix l'article
		WebElement offer = driver.findElement(By.xpath("/html/body/div[2]/main/article"));
		assertTrue(offer != null);
		
		//Comprovem que el titol apareix i es correcte
		WebElement title = driver.findElement(By.xpath("/html/body/div[2]/main/article/div[2]/section/h1"));
		assertTrue(title != null);
		
		String text = title.getText();
		assertTrue(text.contains("Bebida Isotónica Powerade Ice Storm 500 Ml"));
		
		//Comprovem que el preu es el correcte i apareix
		WebElement price = driver.findElement(By.xpath("/html/body/div[2]/main/article/div[2]/section/div[1]/div/div/div/span"));
		assertTrue(price != null);
		
		String p = price.getText();
		assertTrue(p.contains("1,49 €"));
		
		//Comprovem que la imatge carrega
		WebElement img = driver.findElement(By.xpath("/html/body/div[2]/main/article/div[1]/div/div/ul/li/button/img"));
		assertTrue(img != null);
		
		//Comprovem que les caracteristiques del producte apareixen
		WebElement caracteristics = driver.findElement(By.id("ProductBenefits-f5a0be5b313a926e1b2cce79f6b16c828db4dd5a"));
		assertTrue(caracteristics != null);
		
		
		//Comprovem que la informació del producte apareix i el titol es correcte
		WebElement info = driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div[2]/h2"));
		assertTrue(info != null);
		
		String i = info.getText();
		assertTrue(i.contains("Información técnica"));
		
		//Comprovem que el botó del carret apareix
		WebElement button = driver.findElement(By.xpath("/html/body/div[2]/main/article/div[2]/section/div[6]/div/button"));
		assertTrue(button != null);
				
	}
	
}
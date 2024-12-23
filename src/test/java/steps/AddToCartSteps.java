package steps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class AddToCartSteps {
	WebDriver driver = AcceptCookiesSteps.getDriver();
	
	@When("the user selects size")
	public void theUserSelectsSize(){
		
        JavascriptExecutor js = (JavascriptExecutor) driver;
        
		js.executeScript("window.scrollTo(0, 500);");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("kampyleButtonContainer")));
		
        WebElement sizeSelect = driver.findElement(By.id("sku-selector"));
        sizeSelect.click();      
        
        WebElement s = driver.findElement(By.id("sku-2"));
        s.click();
        
	}
	
	@Then("the size product is selected")
	public void theSizeProductIsSelected() {
		WebElement size = driver.findElement(By.xpath("/html/body/div[2]/main/article/div[2]/section/div[4]/div[2]/button/span"));
		assertTrue(size != null);
		
		String s = size.getText();
		assertEquals(s, "M");
		
	}
	
	@When("the user adds product to cart")
	public void theUserAddsProductToCart() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/main/article/div[2]/section/div[8]/div/button")));
		
		WebElement cart = driver.findElement(By.xpath("/html/body/div[2]/main/article/div[2]/section/div[8]/div/button"));
		cart.click();
	}
	
	@Then("the product is added to cart")
	public void theProductIsAddedToCart() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/aside/section/div/div")));
		
		WebElement lateralContainerInfo = driver.findElement(By.id("popin-cross-sell"));
		assertTrue(lateralContainerInfo != null);
		
		WebElement addedToCart = driver.findElement(By.xpath("/html/body/aside/section/header/div/span"));
		assertTrue(addedToCart != null);
		
		String a = addedToCart.getText();
		assertTrue(a.contains("Añadido a la cesta"));
		
		WebElement infoCart = driver.findElement(By.xpath("/html/body/aside/section/div/div/div/section[1]/div[1]/span"));
		assertTrue(infoCart != null);
		
		String i = infoCart.getText();
		assertEquals(i, "Subtotal de tu cesta\n1");
		
		WebElement subtotal = driver.findElement(By.xpath("/html/body/aside/section/div/div/div/section[1]/div[1]/strong"));
		assertTrue(subtotal != null);
		
		String s = subtotal.getText();
		assertEquals("39,99 €", s);
		
	}
	
	@When("the user clicks on the cart button")
	public void theUserClicksOnTheCartButton() {
		WebElement goToCart = driver.findElement(By.xpath("/html/body/aside/section/div/div/div/section[1]/div[2]/span/button"));
		goToCart.click();
		
	}
	@Then("the cart info shows with added products")
	public void theCartInfoShowsWithAddedProducts() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/main/div/div[2]/article")));
		
		WebElement cartMenu = driver.findElement(By.xpath("/html/body/div/main/div/div[2]/article"));
		assertTrue(cartMenu != null);
		
		WebElement cart = driver.findElement(By.xpath("/html/body/div/main/div/div[2]/article/section[1]/h1"));
		assertTrue(cart != null);
		
		String c = cart.getText();
		assertEquals("Mi cesta", c);
		
		WebElement article = driver.findElement(By.xpath("/html/body/div/main/div/div[2]/article/section[1]/div/section/article/div[2]/div[1]/a/span"));
		assertTrue(article != null);
		
		String a = article.getText();
		assertEquals("Chaqueta de esquí y nieve impermeable Hombre Wedze Ski-P JKT100", a);
		
		WebElement price = driver.findElement(By.xpath("/html/body/div/main/div/div[2]/article/section[2]/div[1]/div/span/div[5]/div/span"));
		assertTrue(price != null);
		
		String p = price.getText();
		assertEquals("39,99 €", p);
		
		WebElement subtotal = driver.findElement(By.xpath("/html/body/div/main/div/div[2]/article/section[2]/div[1]/div/span/div[1]/div/div/div/span[2]"));
		assertTrue(subtotal != null);
		
		String s = subtotal.getText();
		assertEquals("(1 artículo)", s);
		
		WebElement cartInfo = driver.findElement(By.xpath("/html/body/div/main/div/div[2]/article/section[1]/div/section"));
		List<WebElement> div = cartInfo.findElements(By.tagName("article"));
		assertFalse(div.isEmpty());

		boolean cartEmpty = driver.findElements(By.xpath("/html/body/div/main/div/div[2]/article/section[1]/div/section/p[1]")).isEmpty();
		assertTrue(cartEmpty);

	}
	
}

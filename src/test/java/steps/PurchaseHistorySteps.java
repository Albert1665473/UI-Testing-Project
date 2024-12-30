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

public class PurchaseHistorySteps {
	WebDriver driver = AcceptCookiesSteps.getDriver();
	
	@When("the user clicks on the purchase history")
	public void theUserClicksOnThePurchaseHistory() {
		driver.findElement(By.xpath("/html/body/div[2]/main/div/section/div/div/div[2]/div/div[1]/div[3]/span/a")).click();
		
	}
	
	@When("the user clicks on the last purchase")
	public void theUserClicksOnTheLastPurchase() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/div/section/div/div/div[2]/div/div[5]/div/div")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/main/div/section/div/div/div[2]/div/div[5]/div/div[2]/div[2]/div/span/a")));
		
		driver.findElement(By.xpath("/html/body/div[2]/main/div/section/div/div/div[2]/div/div[5]/div/div[2]/div[2]/div/span/a")).click();
	}
	
	@Then("the purchase information shows")
	public void thePurchaseInformationShows() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/div/div/div/div/div/div/div[2]/section[3]/div/div[1]/div")));
		
		WebElement products = driver.findElement(By.xpath("/html/body/div[2]/main/div/div/div/div/div/div/div[2]/section[3]/h2"));
		assertTrue(products != null);
		
		String p = products .getText();
		assertEquals("Producto/s del pedido", p);
		
		WebElement wristband = driver.findElement(By.xpath("/html/body/div[2]/main/div/div/div/div/div/div/div[2]/section[3]/div/div[1]/div/div[3]/div[2]/div[1]/p[2]"));
		assertTrue(wristband != null);
		
		String w = wristband.getText();
		assertEquals("Muñequera de Tenis Artengo TP 100 Negro", w);
		
		WebElement wPrice = driver.findElement(By.xpath("/html/body/div[2]/main/div/div/div/div/div/div/div[2]/section[3]/div/div[1]/div/div[3]/div[2]/div[2]/div[1]/span[3]/span/div/div/div/div/span"));
		assertTrue(wPrice != null);
		
		String wp = wPrice.getText();
		assertEquals("5,99 €", wp);
		
		WebElement socks = driver.findElement(By.xpath("/html/body/div[2]/main/div/div/div/div/div/div/div[2]/section[3]/div/div[1]/div/div[4]/div[2]/div[1]/p[2]"));
		assertTrue(socks != null);
		
		String s = socks.getText();
		assertEquals("Calcetines altos de tenis Pack de 3 Artengo RS 100 Blanco", s);
		
		WebElement pSocks = driver.findElement(By.xpath("/html/body/div[2]/main/div/div/div/div/div/div/div[2]/section[3]/div/div[1]/div/div[4]/div[2]/div[2]/div[1]/span[3]/span/div/div/div/div/span"));
		assertTrue(pSocks != null);
		
		String ps = pSocks.getText();
		assertEquals("3,99 €", ps);
		
		WebElement totalPrice = driver.findElement(By.xpath("/html/body/div[2]/main/div/div/div/div/div/div/div[2]/section[3]/div/div[6]/p[2]/span/div/div/div/div/span"));
		assertTrue(totalPrice != null);
		
		String t = totalPrice.getText();
		assertEquals("9,98 €", t);
		
		WebElement payMethod = driver.findElement(By.xpath("/html/body/div[2]/main/div/div/div/div/div/div/div[2]/section[4]/div/p"));
		assertTrue(payMethod != null);
		
		String m = payMethod.getText();
		assertEquals("Tarjeta bancaria\n9,98 €", m);
		
	}
	
}

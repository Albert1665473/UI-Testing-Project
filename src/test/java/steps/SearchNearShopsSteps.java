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
import org.openqa.selenium.Keys;

public class SearchNearShopsSteps {

	WebDriver driver = AcceptCookiesSteps.getDriver();
	
    @When("the user clicks on the shops option")
    public void theUserClicksOnTheShopsOption() {
    	
    	driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/nav/ul/li[2]/div/a")).click();
    
    }
    
    @When("the user writes the city in the search bar and selects the first option")
    public void theUserWritesTheCityInTheSearchBar() throws InterruptedException {
        // Escribimos la localizacion de la tienda que deseamos por ejemplo una de barcelona
    	driver.findElement(By.xpath("//*[@id=\"autocomplete-input\"]")).click();
		
		WebElement search = driver.findElement(By.xpath("//*[@id=\"autocomplete-input\"]"));
		
		
		search.clear();
		search.sendKeys("Barcelona");
		
		Thread.sleep(2000);
	    
		search.sendKeys(Keys.ARROW_DOWN);
	    search.sendKeys(Keys.ENTER);
    }


    @When("the user selects the store")
    public void theUserSelectsTheStore() throws InterruptedException {
    	 // Localizamos y seleccionamos la tienda
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div[2]/div/div/div[3]/div[1]/div[2]/div/div[3]/div[2]/img")).click();
    
    }
    
    @When("the user clicks on the see more button")
    public void theUserClicksOnTheSeeMoreButton() {
    	 // Localizamos y hacemos en el boton de ver mas
    	driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div[1]/div[2]/ul/button[1]/li/span[2]/a")).click();
    
    }
    
    @Then("the shop of the desired location appears")
    public void theShopOfTheDesiredLocationAppears() {
        // Verificamos que se muestra la pagina indicada
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement desiredShop = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/div[2]")));
        assertTrue(desiredShop.isDisplayed(), "La página de de la tienda se cargó correctamente");
     
        WebElement results = driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div[1]/div[1]/h1"));
      	String text1 = results.getText();
		assertTrue(text1.contains("Ciutat Vella - Barcelona"));
     
   
      	WebElement img = driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div[2]/img"));
      	assertTrue(img != null);
     
      
      	WebElement results2 = driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div[1]/article/h2"));
      	String text2 = results2.getText();
		assertTrue(text2.contains("Contacta con la tienda"));
		
		WebElement results3 = driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div[1]/article/div[1]/a"));
      	String text3 = results3.getText();
		assertTrue(text3.contains("+34933426161"));
		
		WebElement results4 = driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div[1]/article/div[2]/span[2]/a"));
      	String text4 = results4.getText();
		assertTrue(text4.contains("Contacta con nuestro equipo"));
		
		WebElement results5 = driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div[1]/div[2]/article/h2"));
      	String text5 = results5.getText();
		assertTrue(text5.contains("Horario comercial"));
		
		WebElement results6 = driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div[1]/article/div[3]/div/address"));
      	String text6 = results6.getText();
		assertTrue(text6.contains("C/ de La Canuda nº 20, Barcelona, Cataluña, 08002 Barcelona"));
		
      
    }
}
	


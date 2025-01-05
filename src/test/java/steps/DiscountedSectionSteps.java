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

public class DiscountedSectionSteps {

	WebDriver driver = AcceptCookiesSteps.getDriver();
	
    @When("the user clicks on the category of discounted products section")
    public void theUserClicksOnTheCategoryOfDiscountedProductsSection() {
    	// Vamos a la seccion de descuentos
    	driver.findElement(By.xpath("/html/body/div[2]/header/nav[1]/ul[1]/li[7]/a")).click();
    
    }
    
    @When("the user selects see all the discounts")
    public void theUserSelectsTheSubcategoryOfDiscountedProducts(){
        // Le damos a ver todos los descuentos que hay en la pagina
    	driver.findElement(By.xpath("/html/body/div[2]/main/section[5]/section/span/button")).click();
		
    }

    
    @Then("the list of discounted products appears")
    public void theProductIsInTheCart() {
        // Verificamos que se muestran todos los descuentos
   
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement list = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/div[2]/section[2]")));
        assertTrue(list.isDisplayed(), "El carrito se cargó correctamente");
        
        WebElement results = driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/section[2]/nav[1]/div[1]/button/span[2]"));
      	String text1 = results.getText();
		assertTrue(text1.contains("Muestra solamente los productos disponibles en la tienda"));
		
		WebElement results2 = driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/section[2]/div[1]/div[1]/div[1]/div"));
	    String text2 = results2.getText();
	    assertTrue(text2.contains("PROMOCIÓN"));
	    
	    WebElement results3 = driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/section[2]/nav[1]/div[4]/div/div/span"));
	    String text3 = results3.getText();
	    assertTrue(text3.contains("Ordenar por"));
		
		WebElement filtro = driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/section[1]/div/div/div[1]/article/details/summary/div"));
      	assertTrue(filtro != null);
   
      	WebElement filtroColor = driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/section[1]/div/div/div[3]/article/details/summary/div/div/span"));
      	assertTrue(filtroColor != null);
      
      	WebElement results4 = driver.findElement(By.xpath("/html/body/div[2]/main/header/div/h1"));
	    String text4 = results4.getText();
	    assertTrue(text4.contains("Descuentos"));
		
      
    }
}
	


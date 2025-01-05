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

public class SearchByCategorySteps {

	WebDriver driver = AcceptCookiesSteps.getDriver();

    @When("the user clicks on the category section")
    public void theUserClicksOnTheCategorySection() {
       
    	driver.findElement(By.xpath("//*[@id=\"header\"]/nav[1]/ul[1]/li[1]/button")).click();
    
    }

    @When("the user selects the sport")
    public void theUserSelectsTheSport() {
        // Localizamos y hacemos clic en la categoría Ciclismo
    	driver.findElement(By.xpath("//*[@id=\"DynamicComponent-BlockImageWithMultipleLinksES-14Xnw\"]/section/div[1]/div/div/ul/li[1]")).click();
    }


 
    @When("the user selects helmet category")
    public void theUserSelectsHelmetCategory() {
    	 // Localizamos y hacemos clic en la sección de cascos
    	driver.findElement(By.xpath("/html/body/div[5]/div/section[1]/nav/div[3]/ul/li[7]/a")).click();
    
    }
    
    
    @Then("the helmet section page appears")
    public void theHelmetSectionPageAppears() {
        // Verificamos que estamos en la página de Ciclismo
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement categoryHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/header/div/h1")));
        assertTrue(categoryHeader.isDisplayed(), "La página de Cascos se cargó correctamente");
     
       
      	WebElement results = driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/section[2]/nav[1]/div[1]/button/span[2]"));
      	String text1 = results.getText();
		assertTrue(text1.contains("Muestra solamente los productos disponibles en la tienda"));
      
		WebElement subcategoria = driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/nav/div/a[3]"));
      	assertTrue(subcategoria != null);
   
      	WebElement Equipment = driver.findElement(By.xpath("/html/body/div[2]/header/nav[1]/ul[1]/li[5]/button"));
      	assertTrue(Equipment != null);
      
      	WebElement helmet2 = driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/section[2]/div[1]/div[4]/div[3]/div[1]/div/a/img"));
      	assertTrue(helmet2 != null);
      
      	WebElement results2 = driver.findElement(By.xpath("/html/body/div[2]/main/header/div/div/div/b"));
      	String text2 = results2.getText();
		assertTrue(text2.contains("cascos de bicicleta"));
		
		WebElement results3 = driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/section[2]/nav[1]/div[4]/div/div/span"));
      	String text3 = results3.getText();
		assertTrue(text3.contains("Ordenar por"));
		
		WebElement results4 = driver.findElement(By.xpath("/html/body/div[2]/main/header/a/div/span"));
      	String text4 = results4.getText();
		assertTrue(text4.contains("¿Cómo elegir casco bicicleta?"));
		
		
       
    }
}
	


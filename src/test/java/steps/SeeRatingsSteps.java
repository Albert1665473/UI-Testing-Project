package steps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SeeRatingsSteps {

	WebDriver driver = AcceptCookiesSteps.getDriver();


    @When("the user searches the product")
    public void theUserSearchesTheProduct() throws InterruptedException {
        // Buscamos el producto que queremos en este caso proteina whey
    	
    	driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/nav/div[1]/div/form/div/input")).click();
		
		WebElement search = driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/nav/div[1]/div/form/div/input"));
		
		
		search.clear();
		search.sendKeys("proteina whey");
		
		Thread.sleep(2000);
	    
		driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/nav/div[1]/div/form/div/button")).click();

    	
    }


    @When("the user clicks on the product which wants to see the ratings")
    public void theUserClicksOnTheProductWhichWantsToSeeTheRatings() {
    	 // le damos al producto el cual queremos ver las opiniones
    	driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/section[2]/div/div[1]/div[3]/div[1]/div/a/img")).click();
    
    }
    
    
    @When("the user clicks on the button to see the ratings")
    public void theUserClicksOnTheButtonToSeeTheRatings() {
    	 // Le damos al boton de leer opiniones
    	driver.findElement(By.xpath("/html/body/div[2]/main/article/div[2]/section/div[2]/button/div[2]/span")).click();
    
    }
    
    
    @Then("the rating of the desired product appears")
    public void theRatingOfTheDesiredProductAppears() {
        // Aparecen las opiniones y verificamos que estamos en la seccion de opiniones
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement ratingHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ProductReviews-2e5befe05496426ba3880b32d904b46d7c8a9ba2\"]")));
        assertTrue(ratingHeader.isDisplayed(), "Las valoraciones se cargaron correctamente");
     
        WebElement results = driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div[8]/h2/span"));
      	String text1 = results.getText();
		assertTrue(text1.contains("Opiniones de usuarios"));
		
     
    }
}
	


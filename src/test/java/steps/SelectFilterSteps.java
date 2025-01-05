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

public class SelectFilterSteps {
	
	WebDriver driver = AcceptCookiesSteps.getDriver();

    @When("the user clicks on the sports button")
    public void theUserClicksOnTheSportsButton() {
       
    	driver.findElement(By.xpath("//*[@id=\"header\"]/nav[1]/ul[1]/li[1]/button")).click();
    
    }

    @When("the user clicks on the category swimming")
    public void theUserClicksOnTheCategorySwimming() {
        // Localizamos y hacemos clic en la categoría natación
    	driver.findElement(By.xpath("//*[@id=\"DynamicComponent-BlockImageWithMultipleLinksES-14Xnw\"]/section/div[1]/div/div/ul/li[6]/span/a")).click();
    }


 
    @When("the user selects flip flops section")
    public void theUserSelectsFlipFlopsSection() {
    	 // Localizamos y hacemos clic en la sección de chanclas
    	driver.findElement(By.xpath("//*[@id=\"DynamicComponent-BrickStacker-LEEHB\"]/div/div/div/div[2]/a")).click();
    
    }
    
    @When("the user selects the filter by color")
    public void theUserSelectsTheFilterByColor() {
    	 // Localizamos y hacemos clic en el filtro de color negro de chanclas
    	driver.findElement(By.xpath("//*[@id=\"app\"]/main/div[2]/section[1]/div/div/div[3]/article/details/div/div/div/div/a[1]")).click();
    
    }
    @Then("the flip flops with the color selected appears")
    public void theFlipFlopsWithTheColorSelectedAppears() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement sectionFiltered = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/main/div[2]/section[2]")));
        assertTrue(sectionFiltered.isDisplayed(), "La página de Flip flops con el color correcto se cargó correctamente");
    	
    }
	
}
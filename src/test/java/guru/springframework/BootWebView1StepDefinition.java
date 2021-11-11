package guru.springframework;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BootWebView1StepDefinition {
	
	WebDriver driver;
	
	@Given("To launch web site")
	public void to_launch_web_site() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("http://localhost:8089/");

		String title = driver.findElement(By.xpath("/html/body/div/div/div[1]/div/h2")).getText();
		Assert.assertEquals(title, "Spring Framework Guru");
	}
	
	@When("Click the first product button")
	public void click_the_first_product_button() {
		
		WebElement productButton = driver.findElement(By.linkText("Products"));
		productButton.click();
		
	}
	
	@When("Click the first view")
	public void click_the_first_view() {
	    driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr[2]/td[5]/a")).click();
	}
	@Then("Get text of first URL and type to google search")
	public void get_text_of_first_url_and_type_to_google_search() {
	   WebElement url = driver.findElement(By.xpath("/html/body/div/div[2]/form/div[4]/div/p"));
	   String urlText = url.getText();
	   driver.navigate().to(urlText);
	}
	
	@When("Click the second product button")
	public void click_the_second_product_button() {
		driver.findElement(By.linkText("Products")).click();
	}
	@When("Click the second view")
	public void click_the_second_view() {
	    driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr[3]/td[5]/a")).click();
	}
	@Then("Get text of second URL and type to google search")
	public void get_text_of_second_url_and_type_to_google_search() {
	   WebElement url = driver.findElement(By.xpath("/html/body/div/div[2]/form/div[4]/div/p"));
	   String urlText = url.getText();
	   driver.navigate().to(urlText);
	}

}

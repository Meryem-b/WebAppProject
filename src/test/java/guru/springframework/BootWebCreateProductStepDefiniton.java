package guru.springframework;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BootWebCreateProductStepDefiniton {
	
WebDriver driver;
	
	@Given("Launch web site")
	public void launch_web_site() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("http://localhost:8089/");

		String title = driver.findElement(By.xpath("/html/body/div/div/div[1]/div/h2")).getText();
		Assert.assertEquals(title, "Spring Framework Guru");
	}
	
	@When("Click the create product button")
	public void click_the_create_product_button() {
	    driver.findElement(By.linkText("Create Product")).click();
	}
	
	@When("Fill the data table")
	public void fill_the_data_table(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> columns : rows) {
            driver.findElement(By.id(columns.get("Fields"))).sendKeys(columns.get("Values"));
        }
	}
	
	@Then("Submit button")
	public void submit_button() {
	    driver.findElement(By.xpath("/html/body/div/div[2]/form/div[5]/button")).click();
	}

}

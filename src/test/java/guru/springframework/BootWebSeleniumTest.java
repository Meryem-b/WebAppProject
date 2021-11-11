package guru.springframework;

import static org.testng.Assert.assertEquals;


import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BootWebSeleniumTest {
	
	WebDriver driver;
	String text;
	
	@BeforeClass
	public void browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://localhost:8089/");
	}

	@Test
	public void mainPage() {
		text = driver.findElement(By.xpath("/html/body/div/div/div[1]/div/h2")).getText();
		assertEquals(text, "Spring Framework Guru");

		text = driver.findElement(By.xpath("/html/body/div/div/div[1]/div/h3")).getText();
		assertEquals(text, "Spring Boot Web App");
	}

}

package itemCart;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Filter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lappy\\Desktop\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.id("search-field")).sendKeys("ri");
		List<WebElement> veggies = driver.findElements(By.xpath("//tr/td[1]")).stream().collect(Collectors.toList());
		
		List<WebElement> veggiesFilter=veggies.stream().filter(s->s.getText().contains("Rice")).collect(Collectors.toList());
		
		
	}

}

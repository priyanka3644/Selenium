package itemCart;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class webTableSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lappy\\Desktop\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		// Element Sort
		
		driver.findElement(By.xpath("//table/thead/tr/th[1]")) .click();
		List<WebElement> elementList = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
		List<String> originalList= elementList.stream().map(x->x.getText()).collect(Collectors.toList());
		
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		
		Assert.assertTrue(originalList.equals(sortedList));
		System.out.println("Text sorted");
		
		
		// scan the name and if it matches with Rice, get price
		List<String> priceList;
		do {
			elementList = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));	
		priceList =elementList.stream().filter(s-> s.getText().equalsIgnoreCase("STRAWBERRY")).map(s-> getPrice(s)).collect(Collectors.toList());
		priceList.forEach(s->System.out.println(s));	
		
		if(priceList.size()<1)
		{
			driver.findElement(By.cssSelector("[aria-label='Next']")).click();
		}
		}while(priceList.size()<1);
		
		
		
	}

	private static String getPrice(WebElement s) {
		// TODO Auto-generated method stub

		String price = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price;
	}

}

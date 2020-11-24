package itemCart;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lappy\\Desktop\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		// Thread.sleep(3000L);
		String[] itemsToBeAddedToCart = { "Cucumber", "Carrot", "Beetroot", "Brinjal" };

		addItems(driver, itemsToBeAddedToCart);

		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");

		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();

		WebDriverWait w = new WebDriverWait(driver, 5);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']")));
		System.out.println(driver.findElement(By.xpath("//span[@class='promoInfo']")).getText());
		
		driver.findElement(By.xpath("//div[@class='promoWrapper']/parent::div/button")).click();
		
		Select s= new Select(driver.findElement(By.xpath("//div[@class='products']/div/div/select")));
		s.selectByValue("India");
		
		driver.findElement(By.xpath("//input[@class='chkAgree']")).click();
		
		driver.findElement(By.xpath("//button[contains(text(),'Proceed')]")).click();

	}

	public static void addItems(WebDriver driver, String[] itemsToBeAddedToCart) {

		int noOfItems = itemsToBeAddedToCart.length;

		List<String> itemsNeeded = Arrays.asList(itemsToBeAddedToCart);

		List<WebElement> productsAvailable = driver.findElements(By.xpath("//h4[@class='product-name']"));

		System.out.println("Total Products Available: " + productsAvailable.size());

		int counter = 0;
		for (int i = 0; i < productsAvailable.size(); i++) {
			String[] product = productsAvailable.get(i).getText().split("-");
			String productName = product[0].trim();

			for (String item : itemsNeeded) {
				if (productName.contains(item)) {
					counter++;
					driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
					System.out.println(item + " added to cart");
					break;
				}
			}

			if (counter == noOfItems)
				break;

		}

	}

}

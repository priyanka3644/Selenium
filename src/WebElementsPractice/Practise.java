package WebElementsPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Practise {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\psanka\\Desktop\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		/*******************************
		 * Radio Buttons
		 ********************************************/

		Assert.assertFalse(driver.findElement(By.xpath("//input[@value='radio2']")).isSelected());
		System.out.println("Initially Radio button is not selected");
		driver.findElement(By.xpath("//input[@value='radio2']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//input[@value='radio2']")).isSelected());
		System.out.println("Now Radio button is  selected");

		/*******************************
		 * Check Boxes
		 ********************************************/

		Assert.assertFalse(driver.findElement(By.xpath("//label[@for='bmw']/input")).isSelected());
		System.out.println("Initially Check box is not selected");
		driver.findElement(By.xpath("//label[@for='bmw']/input")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//label[@for='bmw']/input")).isSelected());
		System.out.println("Now Check box is selected");

		/****************************************
		 * Static Dropdowns
		 ******************************/

		Select s = new Select(driver.findElement(By.id("dropdown-class-example")));
		// s.selectByValue("option3");
		Thread.sleep(2000L);
		s.selectByIndex(2);
		// Thread.sleep(2000L);
		// s.selectByVisibleText("Option1");

		/*********************************
		 * Auto Suggestive dropdowns
		 ****************************/

		driver.findElement(By.id("autocomplete")).sendKeys("Al");
		Thread.sleep(3000L);
		List<WebElement> options = driver.findElements(By.xpath("//li[@class='ui-menu-item']/div"));

		int count = 0;
		for (WebElement option : options) {
			count++;

		}
		System.out.println("Total items matching search " + count);

		String Value = null;
		for (WebElement option : options) {
			Value = option.getText();
			if (Value.equalsIgnoreCase("Australia")) {
				option.click();
				break;
			}

		}

		/************************************
		 * Alerts
		 ********************************************/

		String text = "Priya";
		driver.findElement(By.id("name")).sendKeys(text);
		driver.findElement(By.id("alertbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();

		driver.findElement(By.id("confirmbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();

		driver.close();

	}

}

package Assignmengts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Assignment8 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lappy\\Desktop\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();	
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("autocomplete")).sendKeys("UNI");
		Thread.sleep(2000L);
		String textToBeSelected = "Tunisia";
		
		Actions a = new Actions(driver);
		String value= "XXX";
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		
		while(!value.equalsIgnoreCase(textToBeSelected))
		{
			a.moveToElement(driver.findElement(By.id("autocomplete"))).sendKeys(Keys.DOWN).build().perform();
			String script = "return document.getElementById('autocomplete').value";
			value= (String) js.executeScript(script);
		}
		
		a.moveToElement(driver.findElement(By.id("autocomplete"))).sendKeys(Keys.ENTER).build().perform();
		
		Assert.assertEquals(value, textToBeSelected);
		System.out.println("Selected Value is :"+value);
		
		
		
		
	}

}

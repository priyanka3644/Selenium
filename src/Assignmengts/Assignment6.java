package Assignmengts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lappy\\Desktop\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();	
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("checkBoxOption1")).click();
		String text= driver.findElement(By.xpath("//label[@for='bmw']")).getText().trim();
		
		Select s= new Select(driver.findElement(By.id("dropdown-class-example")));
		s.selectByVisibleText(text);
		String selectedValue= s.getFirstSelectedOption().getText().trim();
		Assert.assertEquals(selectedValue, text);
		
		
		driver.findElement(By.id("name")).sendKeys(text);
		driver.findElement(By.id("alertbtn")).click();
		String AlertText= driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		if(AlertText.contains(text))
		{
			System.out.println("Passed");
		}
		else
		{
			System.out.println("Failed");
		}
		
		
	}

}

package Assignmengts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\psanka\\Desktop\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		 driver.findElement(By.id("checkBoxOption1")).click();
		 boolean isSelected1= driver.findElement(By.id("checkBoxOption1")).isSelected();
		 Assert.assertTrue(isSelected1);
		 driver.findElement(By.id("checkBoxOption1")).click();
		 boolean isSelected2= driver.findElement(By.id("checkBoxOption1")).isSelected();
		 Assert.assertFalse(isSelected2);

		 int count= driver.findElements(By.xpath("//input[@type='checkbox']")).size();
		 Assert.assertEquals(count, 3);

		 
		 
		

	}

}

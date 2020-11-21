package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.chrome.ChromeDriver;

public class locators1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\psanka\\Desktop\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://salesforce.com");
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.xpath("//*[@id=\'username\']")).sendKeys("Priya");
		driver.findElement(By.name("pw")).sendKeys("priya");
		driver.findElement(By.id("Login")).click();
		String text= driver.findElement(By.cssSelector("div#error")).getText();
		String text1= "Please check your username and password. If you still can't log in, contact your Salesforce administrator."; 
		if(text.equals(text1))
		{
			System.out.println("Testcase passed");
		}
		
		}
	
}

package alertHandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String text="Priya";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\psanka\\Desktop\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("name")).sendKeys(text);
		driver.findElement(By.cssSelector("[id='alertbtn']")).click();
		System.out.println(driver.switchTo().alert().getText());
		Thread.sleep(2000L);
		driver.switchTo().alert().accept();
		
		driver.findElement(By.xpath("//input[@id='confirmbtn']")).click();
		System.out.println(driver.switchTo().alert().getText());
		Thread.sleep(2000L);

		driver.switchTo().alert().dismiss();
		

	}

}

package windowMaximiseAndCookieDeletion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowMaximiseAndCookieDeletion {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lappy\\Desktop\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		//driver.manage().deleteCookieNamed("360yield.com");
		driver.get("https://www.facebook.com");
		driver.findElement(By.id("email")).sendKeys("priyankasanka@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("God is great@400");
		driver.findElement(By.xpath("//button[@name='login']")).click();
		Thread.sleep(3000L);
		driver.manage().deleteAllCookies();
		Thread.sleep(3000L);
		driver.findElement(By.id("email")).sendKeys("priyanka");

		
		
	}

}

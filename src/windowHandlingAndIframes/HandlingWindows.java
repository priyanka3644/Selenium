package windowHandlingAndIframes;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingWindows {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lappy\\Desktop\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("openwindow")).click();
		Set<String> ids=driver.getWindowHandles();
		System.out.println(ids.size());
		Iterator<String> it = ids.iterator();
		String parentId= it.next();
		String ChildId= it.next();
		driver.switchTo().window(ChildId);
		System.out.println(driver.getTitle());
		Thread.sleep(3000L);
		driver.close();
		driver.switchTo().window(parentId);
		System.out.println(driver.getTitle());
		driver.findElement(By.id("name")).sendKeys("PRIYA");
		
	}
	

}

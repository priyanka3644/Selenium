package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChildLocators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\psanka\\Desktop\\drivers\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    driver.get("http://google.com");
	    driver.findElement(By.xpath("//div[@class='SDkEP']/div[2]/input")).sendKeys("redbus");
	    driver.findElement(By.cssSelector("div[class*='FPdoLc']/center/input")).click();
	}

}

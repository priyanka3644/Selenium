package javascriptExec;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExec {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lappy\\Desktop\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();	
		driver.get("https://ksrtc.in/oprs-web/");
		driver.findElement(By.id("fromPlaceName")).sendKeys("BAN");
		Thread.sleep(2000L);
		//driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.DOWN);
		//driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.DOWN);
		//driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.DOWN);
		//driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.ENTER);
		//System.out.println("text is "+driver.findElement(By.id("fromPlaceName")).getText());

		String cityToBeSelected = "BANGALORE";
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		String fromPlace = "return document.getElementById('fromPlaceName').value";
		String value = (String) js.executeScript(fromPlace);
		
	
		
		while(!value.equalsIgnoreCase(cityToBeSelected))
		{
			driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.DOWN);
			value=(String) js.executeScript(fromPlace);
		}
		
		
		driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.ENTER);
		
		System.out.println("Value is "+value);
		
		
	}

}

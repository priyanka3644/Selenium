package multipleLinkClicks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lappy\\Desktop\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		WebElement footer = driver.findElement(By.id("gf-BIG"));
		String url= footer.findElement(By.cssSelector("a[href*='broken']")).getAttribute("href");
		
		HttpURLConnection conn= (HttpURLConnection)new URL(url).openConnection();		
		conn.setRequestMethod("HEAD");
		conn.connect();
		int responseCode = conn.getResponseCode();
		System.out.println(responseCode);
		/*List<WebElement> links = footer.findElements(By.tagName("a"));
		int linkCount = links.size();
		for(int i=0;i<linkCount;i++)
		{
			String keyValues = Keys.chord(Keys.CONTROL,Keys.ENTER); 
			links.get(i).sendKeys(keyValues);
		}*/
		
		
	}

}

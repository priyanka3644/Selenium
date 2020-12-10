package multipleLinkClicks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.*;
import org.testng.asserts.SoftAssert;

public class MultipleBrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lappy\\Desktop\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		WebElement footer = driver.findElement(By.id("gf-BIG"));
		List<WebElement> links=footer.findElements(By.cssSelector("li[class='gf-li'] a"));
		SoftAssert softAssertion= new SoftAssert() ;
		
		for(WebElement link: links)
		{
			String url=link.getAttribute("href");
			HttpURLConnection conn= (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int response = conn.getResponseCode();
			System.out.println(response);
			softAssertion.assertTrue(response<400, "The Link with text "+link.getText()+" is broken with response code: "+response);
		}
		
		softAssertion.assertAll();
		
		
	}

}

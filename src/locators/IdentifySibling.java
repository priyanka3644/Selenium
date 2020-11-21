package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IdentifySibling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\psanka\\Desktop\\drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("http://book.theautomatedtester.co.uk/");
		driver.findElement(By.xpath("//div[@class='mainbody']/ul/li[1]/following-sibling::li[2]/a")).click(); //to find siblings
		driver.findElement(By.xpath("//div[@class='mainbody']/ul/li[1]/parent::ul/li[2]")).click(); //to find parent
		driver.findElement(By.xpath("//*[text()='Chapter1']")); //to find object using text

		
	}

}

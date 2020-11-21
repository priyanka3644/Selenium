package seleniumpkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDrivers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Hello");
	
		System.setProperty("webdriver.chrome.driver","C:\\Users\\psanka\\Desktop\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://google.com");
		System.out.println(driver.getTitle());
		String currentUrl= driver.getCurrentUrl();
		//System.out.println(driver.getPageSource());
		System.out.println(currentUrl);

		driver.get("http://yahoo.com");
		System.out.println(driver.getTitle());

		driver.navigate().back();
		driver.quit();
	}

}
	
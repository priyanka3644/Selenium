package seleniumpkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEDrivers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.ie.driver", "C:\\Users\\psanka\\Desktop\\drivers\\IEDriverServer.exe");
		WebDriver driver =new InternetExplorerDriver();
		driver.get("http://google.com");
		System.out.println(driver.getTitle());
		

	}

 
}

package sslHandling;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SSLHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// General chrome profile
		DesiredCapabilities dc= DesiredCapabilities.chrome();
		dc.acceptInsecureCerts();
		dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		
		// Local Chrome profile --used to set local chrome settings
		ChromeOptions c = new ChromeOptions();
		c.merge(dc);
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lappy\\Desktop\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(c);
		driver.get("www.google.com");
		
	}

}

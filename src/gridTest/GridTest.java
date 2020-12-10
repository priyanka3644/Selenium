package gridTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GridTest {
	
	public static void main(String[] args) throws MalformedURLException
	{
	
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName("chrome");
		dc.setPlatform(Platform.WINDOWS);
		
		
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:5555/wd/hub"),dc);
		driver.get("http://www.google.com");
	}

}

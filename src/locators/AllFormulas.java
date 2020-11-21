package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllFormulas {
	
	public static void main(String[] args) {
	 
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\psanka\\Desktop\\drivers\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    driver.get("http://rediff.com");
	    driver.findElement(By.cssSelector("a[href*='login']")).click();
	    driver.findElement(By.xpath("//input[@name='login']")).sendKeys("priya");
	    driver.findElement(By.cssSelector("input[type='password']")).sendKeys("priya");
	    driver.findElement(By.xpath("//input[contains(@value,'Sign')]")).click();
	    System.out.println(driver.findElement(By.cssSelector("div#div_login_error.div_login_error")).getText());
	    
	    /*driver.findElement(By.id(id));
	    driver.findElement(By.name(name));
	    driver.findElement(By.linkText(linkText));
	    driver.findElement(By.className(className));
	    driver.findElement(By.xpath("//tagname[@attribute='value']")); //xpath
	    driver.findElement(By.xpath("//tagname[contains(@attribute,'value')]")); // xpath reg expression
	    driver.findElement(By.cssSelector("tagname[attribute='value']")); // css
	    driver.findElement(By.cssSelector("tagname[attribute*='value']")); //css reg expression */
	    
	
	}

}

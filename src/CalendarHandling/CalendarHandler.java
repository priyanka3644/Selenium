package CalendarHandling;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarHandler {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lappy\\Desktop\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();	
		driver.get("https://www.path2usa.com/travel-companions");
		Thread.sleep(3000L);
		driver.findElement(By.id("travel_date")).click();
		String monthRequired = "March";
		String yearRequired = "2021";
		String mmyy = monthRequired + " " + yearRequired;
		String dateRequired = "26"; 
		
		String value = driver.findElement(By.cssSelector("div[class='datepicker-days'] [class='datepicker-switch']")).getText();
		System.out.println(value);
		while(!value.equalsIgnoreCase(mmyy))
		{
			driver.findElement(By.cssSelector("div[class='datepicker-days'] [class='next']")).click();
			value=driver.findElement(By.cssSelector("div[class='datepicker-days'] [class='datepicker-switch']")).getText();
			System.out.println(value);
		}
		List<WebElement> days= driver.findElements(By.className("day"));
		int daysCount= days.size();
		for(int i=0;i<daysCount;i++)
		{
			String text= days.get(i).getText();
			if(text.equalsIgnoreCase(dateRequired))
			{
				String className= days.get(i).getAttribute("class");
				System.out.println("text is "+text+" AND class name is "+className);
				if(className.contains("disabled"))
				{
					continue;
				}
				else
				{
					days.get(i).click();
					break;
				}
			}
		}
	}

}

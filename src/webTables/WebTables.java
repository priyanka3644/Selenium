package webTables;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double sum=0;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lappy\\Desktop\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();	
		driver.get("http://demo.guru99.com/test/web-table-element.php");
		WebElement table= driver.findElement(By.xpath("//table[@class='dataTable']"));
		List<WebElement> column3= table.findElements(By.xpath("//tr/td[3]"));
		int length= column3.size();
		for(int i=0; i<length; i++)
		{
			String text=column3.get(i).getText();
			//System.out.println(text);
			double value= Double.parseDouble(text);
			sum+=value;
			
		}
		
		System.out.println(sum);
	}

}

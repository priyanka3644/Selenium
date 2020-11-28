package Assignmengts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lappy\\Desktop\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();	
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='product']//tr"));
		List<WebElement> columns = driver.findElements(By.xpath("//table[@id='product']//tr/th"));
		System.out.println("No of Rows including header: "+rows.size());
		System.out.println("No of Columns: "+columns.size());
		
		
		
		for(int i=0;i<columns.size();i++)
		{
			List<WebElement> columnValues = driver.findElements(By.xpath("//table[@id='product']//tr[3]/td"));
			System.out.println(columnValues.get(i).getText());
		}
		
		
		
		
		/*for(int i=2;i<=rows.size();i++)
		{
			System.out.println("------------------ "+ i +" -------------------------");
			List<WebElement> columnValues= driver.findElements(By.xpath("//table[@id='product']//tr["+i+"]/td"));
			for(int j=0;j<columns.size();j++)
			{
				System.out.println(columnValues.get(j).getText());
			}
		}
		*/
		
		
		

	}

}

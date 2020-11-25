package Assignmengts;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Practise {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lappy\\Desktop\\drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		
		/************************************* Radio Buttons ******************************************/
		
		
		
		/************************************ Check Boxes *********************************************/
		
		

		/************************************ Static dropdowns ***************************************/
		
		
		
		/************************************ Auto Suggestive dropdowns *******************************/
		
		
		
		/***************************************  Alerts **********************************************/
		
		
		
		/****************************************  Switch Window ********************************************/
		
		
		
		
		/****************************************** Switch Tab *********************************************/
		
		
		
		
		/******************************************  Mouse Hover ****************************************/
		
		
		
		/******************************************* Frames *****************************************/
		
		
		
		/******************************* Find Total links in Web Page *******************************/
		
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println("Total links in page: "+links.size());
	
		
		/***************************** Find links in Footer section - Method 1 ***********************************/
		
		WebElement footerSection = driver.findElement(By.id("gf-BIG"));
		List<WebElement> footerLinks = footerSection.findElements(By.tagName("a"));
		System.out.println("Total links in footer section - Method 1: "+footerLinks.size());
		
		/***************************** Find links in Footer section - Method 2 ***********************************/
		
		List<WebElement> footerLinks2 = footerSection.findElements(By.xpath("//div[@id='gf-BIG']//a"));
		System.out.println("Total links in footer section - Method 2: "+footerLinks2.size());
		
	
		/************************** Find Links in Footer First column *****************************************/
		
		System.out.println("/***************************************************************************/");
		List<WebElement> rows = driver.findElements(By.xpath("//div[@id='gf-BIG']//tr"));
		System.out.println("Total rows in fotter section: "+rows.size());
		
		List<WebElement> columns = driver.findElements(By.xpath("//div[@id='gf-BIG']//tr/td"));
		System.out.println("Total columns in row: "+columns.size());
		
		int incr = 0;
		for(WebElement element: columns)
		{
			incr++;
			List<WebElement> linkList = element.findElements(By.tagName("a"));
			int count= linkList.size();
			System.out.println("No of links in column "+incr + ": "+count);
			for(int i=1;i<count;i++)
			{
				String clickLink = Keys.chord(Keys.CONTROL,Keys.ENTER);
				linkList.get(i).sendKeys(clickLink);				
			}
		}
		
		
		Thread.sleep(10000L);
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
		 
		
		
		
		
		
		
		
		/******************** click on each link in 1st column and check if pages are opening ******************/
		
		System.out.println("/***************************************************************************/");
		
		
		
		
	}

}

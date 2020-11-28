package PractisePkg;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class PractiseClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lappy\\Desktop\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		Actions a= new Actions(driver);
		
		/*************************************** Check Box ******************************************/
		//get total number of check boxes and click on 3rd checkbox
		
		List<WebElement> checkBoxes= driver.findElements(By.xpath("//input[@type='checkbox']"));
		System.out.println("Total checkboxes " +checkBoxes.size());
		
		driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).click();
		System.out.println(driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).isSelected());
		String text = driver.findElement(By.xpath("(//input[@type='checkbox'])[3]/parent::label")).getText();
		System.out.println("Option selected is "+text);
		
		System.out.println("***************************************************************************");
		
		/************************************** Radio Buttons ****************************************/

		//click Radio2
		driver.findElement(By.xpath("//input[@value='radio2']")).click();
		
		System.out.println("***************************************************************************");

				
		/*********************************** Static Dropdowns ****************************************/
		//select the value which was selected in checkbox
		WebElement element = driver.findElement(By.id("dropdown-class-example"));
		Select s= new Select(element);
		s.selectByVisibleText(text.trim());
		
		System.out.println("***************************************************************************");

		
		/********************************* AutoComplete Dropdowns **********************************/
		
		a.moveToElement(driver.findElement(By.id("autocomplete"))).click().keyDown(Keys.SHIFT).sendKeys("un").build().perform();
		String textToBeSelected= "Tunisia";
		String value = "XXX";
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		while(!value.equalsIgnoreCase(textToBeSelected))
		{
			a.moveToElement(driver.findElement(By.id("autocomplete"))).sendKeys(Keys.DOWN).build().perform();
			String script = "return document.getElementById('autocomplete').value";
			value= (String) js.executeScript(script);
		}
		
		a.moveToElement(driver.findElement(By.id("autocomplete"))).click().build().perform();
		System.out.println("Value Selected is "+value);
		Assert.assertEquals(value, textToBeSelected);
		
		System.out.println("***************************************************************************");


		
		/******************************** Alerts **************************************************/
		
		driver.findElement(By.id("name")).sendKeys("PRIYA");
		driver.findElement(By.id("alertbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
		driver.findElement(By.id("confirmbtn")).click();
		driver.switchTo().alert().dismiss();
		
		System.out.println("***************************************************************************");

		
		/******************************** Switch Window *******************************************/
		
		driver.findElement(By.id("openwindow")).click();
		Set<String> ids= driver.getWindowHandles();
		int count = ids.size();
		System.out.println("Total no of windows opened including parent window: "+count);
		
		Iterator<String> it = ids.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();
		
		driver.switchTo().window(childWindow);
		System.out.println("Child Window Title is: "+driver.getTitle());
		driver.close();
		
		driver.switchTo().window(parentWindow);
		System.out.println("Parent Window Title is: "+driver.getTitle());
		
		System.out.println("***************************************************************************");

		
		
		/****************************** Switch Tab *************************************************/
		
		driver.findElement(By.id("opentab")).click();
		Set<String> tabIds = driver.getWindowHandles();
		int tabsCount = tabIds.size();
		System.out.println("Total no of tabs opened: "+tabsCount);
		
		Iterator<String> it1 = tabIds.iterator();
		String parentTab = it1.next();
		String childTab = it1.next();
		
		driver.switchTo().window(childTab);
		System.out.println("ChildTab Title is: "+driver.getTitle());
		driver.close();
		
		driver.switchTo().window(parentTab);
		System.out.println("ParentTab title is "+driver.getTitle());
		
		System.out.println("***************************************************************************");

		
		
		/************************************** Mouse Hover *************************************/
		
		a.moveToElement(driver.findElement(By.id("mousehover"))).build().perform();
		driver.findElement(By.xpath("//div[@class='mouse-hover-content']/a[1]")).click();
		System.out.println(driver.getCurrentUrl());
		
		System.out.println("***************************************************************************");

		
		/********************************** Iframes ************************************************/
		
		driver.switchTo().frame(driver.findElement(By.id("courses-iframe")));
		System.out.println(driver.findElement(By.xpath("//*[text()='Home']")).getText());
		driver.switchTo().defaultContent();
		System.out.println(driver.getTitle());
		
		System.out.println("***************************************************************************");

		
		/****************************************** Web Tables **********************************/
		
		//Find No of rows and columns and print out last row details
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='product']//tr"));
		System.out.println("No of Rows in table: "+rows.size());
		List<WebElement> columns = rows.get(0).findElements(By.tagName("th"));
		System.out.println("No of columns in table: "+columns.size());
		
		WebElement lastRow = rows.get((rows.size())-1);
		for(int i=0;i<columns.size();i++)
		{
			String column = lastRow.findElements(By.tagName("td")).get(i).getText();
			System.out.println(column);
		}
		
		System.out.println("***************************************************************************");

		
		/******************************* Total Links in web page *********************************/
		
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		/**************************** Total Links in header section *****************************/
		
		WebElement header = driver.findElement(By.tagName("header"));
		List<WebElement> links= header.findElements(By.tagName("a"));
		System.out.println("Links in header: "+links.size());
		
		
		
		/*********************** click all links in header section and get titles *****************/
	
		String clickLink= Keys.chord(Keys.CONTROL,Keys.ENTER);
				
		for(int i=0;i<links.size();i++)
		{
			links.get(i).sendKeys(clickLink);
		}
		
		Set<String> ids2 = driver.getWindowHandles();
		Iterator<String> it2 = ids2.iterator();
		while(it2.hasNext())
		{
			driver.switchTo().window(it2.next());
			System.out.println(driver.getTitle());
			driver.close();
			
		}
		
		
		
		
	
	}
	

}

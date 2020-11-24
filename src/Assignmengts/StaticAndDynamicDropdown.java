package Assignmengts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class StaticAndDynamicDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\psanka\\Desktop\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise");
		
		/***************************Auto Suggestive DropDowns*************************************/
		
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(3000L);
		List<WebElement> options=driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		for(WebElement option: options)
		{
			if(option.getText().equalsIgnoreCase("India"))
			{
				option.click();
				break;
			}
		}
		
		/************************************** Radio Buttons*****************************************/
		
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		String RoundTripvalue= driver.findElement(By.id("Div1")).getAttribute("style");
		boolean isroundTripEnabled=false;
		if(RoundTripvalue.contains("1"))
		{
			isroundTripEnabled=true;
			System.out.println("On selecting round trip, return date is enabled");
		}
		else
		{
			isroundTripEnabled=false;
			System.out.println("On selecting round trip, return date is not enabled");

		}
		
			
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		String OneTripvalue= driver.findElement(By.id("Div1")).getAttribute("style");
		boolean isOneTripEnabled=false;
		if(OneTripvalue.contains("1"))
		{
			isOneTripEnabled=true;
			System.out.println("On selecting one way trip, return date is not disabled");
		}
		else
		{
			isOneTripEnabled=false;
			System.out.println("On selecting one way trip, return date is disabled");

		}
		
		
		
	
		
		/*************************check boxes ******************************************************/
		
		boolean isSelectedInitial= driver.findElement(By.cssSelector("input[id*='StudentDiscount']")).isSelected();
		Assert.assertFalse(isSelectedInitial);
		driver.findElement(By.cssSelector("input[id*='StudentDiscount']")).click();
		boolean isSelected= driver.findElement(By.cssSelector("input[id*='StudentDiscount']")).isSelected();
		Assert.assertTrue(isSelected);
		
		int checkboxCount=driver.findElements(By.cssSelector("input[type='checkbox']")).size();
		System.out.println("Check Boxes Count is "+checkboxCount);
		
		/***************************** Departure And Arrival Selection ***************************/
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR']//a[@value='BLR']")).click();
		Thread.sleep(2000L);
		driver.findElement(By.xpath("(//a[@value='AIP'])[2]")).click();
		
		
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		
		
		/****************************Passenger count selection **********************************/
		driver.findElement(By.id("divpaxinfo")).click();
		
	    Thread.sleep(2000L);

		int NoOfAdults= 5;
		int noOfchild = 3;
		int noOfInfants= 1;
		for(int i = 1; i<NoOfAdults;i++)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		//Thread.sleep(2000L);
		/*for(int i = 1; i<=noOfchild;i++)
		{
			driver.findElement(By.id("hrefIncChd")).click();
		}
		for(int i = 1; i<=noOfInfants;i++)
		{
			driver.findElement(By.id("hrefIncInf")).click();
		}*/
		
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		/****************************** Currency selection ****************************************/
		WebElement locator=driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select s= new Select(locator);
		s.selectByValue("USD");
		
		
		/*********************************search click**********************************************/
		
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		
	}

}

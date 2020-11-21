package flightAutomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\psanka\\Desktop\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.cleartrip.com/");
		
		/***************************select passenger counts***********************/
		
		
		Select s= new Select(driver.findElement(By.id("Adults")));
		s.selectByValue("3");
		
		Select s1= new Select(driver.findElement(By.id("Childrens")));
        s1.selectByValue("1");
        
        /**********************************Date Selection ***************************************/
        
        driver.findElement(By.xpath("(//i[contains(@class,'datePicker')])[1]")).click();
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active ")).click();
        
        /************************************More option link click****************************/
        driver.findElement(By.id("MoreOptionsLink")).click();
        
        driver.findElement(By.id("AirlineAutocomplete")).sendKeys("INDI");
        
        /***************************************88Search Flights ************************************/
        driver.findElement(By.id("SearchBtn")).click();
        
        /***********************************Printing Error Message*********************************/
        System.out.println(driver.findElement(By.id("homeErrorMessage")).getText());
        		
        
        

	}

}

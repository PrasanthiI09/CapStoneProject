package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {

public static WebDriver driver;
	
	public Utility()
	{
		
	}
	
	public void initiateDriver(String browser,String url)
	{
		if(browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(browser.equals("edge"))
		{
			driver = new EdgeDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void closeDriver()
	{
		driver.quit();
	}
	public void click(WebElement element)
	{
		element.click();
	}
	public void visibilityofElement(WebElement element,int sec)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}

package pageclass;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificMethod;

public class BookAHotelConfirmationPage extends ProjectSpecificMethod {
	

	public BookAHotelConfirmationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="(//table[2]//table)[2]//tbody//tr")
	List<WebElement> tablerows;
	
	@FindBy(xpath="//td[@class='login_title']")
	public WebElement confirmationtitle;
	
	@FindBy(xpath = "//td[contains(text(),'Last Name')]")
	public WebElement LastNameField;
	
	@FindBy(xpath="//input[@name='last_name']")
	public WebElement LastNameValue;
	
	@FindBy(xpath="//input[@name='room_type']")
	public WebElement RoomTypevalue;
	
	
	public Map<String,String> gettabledata()
	{
		Map <String,String> tabledata = new HashMap<>();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		
		for(int i=0;i<tablerows.size();i++)
		{
			WebElement row = tablerows.get(i);
		try
		{
			wait.until(ExpectedConditions.visibilityOf(row));
			List<WebElement> cells = row.findElements(By.tagName("td"));
			if(cells.size()==2)
			{
				String fieldname =cells.get(0).getText().trim();
				System.out.print(fieldname +" : ");
				WebElement Element = cells.get(1);
				String fieldvalue = "";
				try
				{
					WebElement inputElement = Element.findElement(By.tagName("input"));
					fieldvalue = inputElement.getAttribute("value").trim();
				}
				catch(Exception e)
				{
					
				}
				if(fieldvalue.isEmpty())
				{
					fieldvalue = Element.getText().trim();
				}
				tabledata.put(fieldname,fieldvalue);
				System.out.print(fieldvalue);
				System.out.println();
			}
		}catch(Exception e)
		{
			System.err.println("Error processing row: " + row.getAttribute("outerHTML"));
            e.printStackTrace();
		}
		}
		return tabledata;
	}
	

}

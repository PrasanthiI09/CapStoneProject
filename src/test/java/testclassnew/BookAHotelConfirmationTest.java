package testclassnew;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pageclass.BookAHotelConfirmationPage;

public class BookAHotelConfirmationTest extends ProjectSpecificMethod{

	
	BookAHotelConfirmationPage bookahotelconfirmation;
	 
	@Test(priority=1)
	public void validateBookAHotelConfimationPage()
	
	{
		bookahotelconfirmation = new BookAHotelConfirmationPage(driver); 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(bookahotelconfirmation.confirmationtitle));
		System.out.println("User booked hotel successfully "+ bookahotelconfirmation.confirmationtitle.getText());
	}
	@Test(priority=2)
	public void validateallFiledsandValues()
	{
		try
		{
		Map <String,String> tableData = bookahotelconfirmation.gettabledata();
		System.out.println("Table data captured");
		for(Map.Entry<String, String> entry : tableData.entrySet())
		{
			System.out.println(entry.getKey()+" : "+entry.getValue());
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

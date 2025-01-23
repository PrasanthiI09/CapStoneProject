package testclassnew;

import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import junit.framework.Assert;
import pageclass.BookAHotelConfirmationPage;
import utils.Listener;

public class BookHotelConfirmationLastNameDisplayCheckTest extends ProjectSpecificMethod{

	
	BookAHotelConfirmationPage bookahotelconfirmationpage;
	selectHotelTest selecthoteltest = new selectHotelTest();
	@Test(priority=1)
	public void validateLastName() throws InterruptedException
	{
		Thread.sleep(15);
		bookahotelconfirmationpage = new BookAHotelConfirmationPage(driver);
		String expectedlastname = "Sharma";
		String actuallastname = bookahotelconfirmationpage.LastNameValue.getAttribute("value");
		Assert.assertEquals(expectedlastname, actuallastname);
		System.out.println(bookahotelconfirmationpage.LastNameField.getText()+" : " +bookahotelconfirmationpage.LastNameValue.getAttribute("value"));
	}
	@Test(priority=2)
	public void validateRoomType()
	{
		String expectedRoomType = selecthoteltest.roomtype;
		String actualRoomType = bookahotelconfirmationpage.RoomTypevalue.getAttribute("value");
		System.out.println("RoomType Displayed : "+actualRoomType);
		try
		{
					
		Assert.assertEquals(expectedRoomType, actualRoomType);
		System.out.println("Room Type displayed is equal");
		}
		catch(Throwable t)
		{
			System.out.println("Assertion failed: " + t.getMessage());
			Listener listener = new Listener(driver);
			String destination = "C:\\Users\\prabh\\Documents\\Prasanthi\\Selenium with Java\\Batch2\\CapstoneProject\\DefectScreenshots\\BookHotelConfirmation_RoomTypeMisMatch.png";
			listener.capturedefectScreenshot(destination);
			throw t;
		}
		
	}
}

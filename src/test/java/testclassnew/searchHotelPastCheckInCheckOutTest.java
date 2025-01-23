package testclassnew;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import junit.framework.Assert;
import pageclass.SearchHotelPage;
import utils.ExcelData;
import utils.Listener;

public class searchHotelPastCheckInCheckOutTest extends ProjectSpecificMethod{

	SearchHotelPage searchhotelpage;
	
	@DataProvider(name = "searchHotelPastDatesErrorMessagesTestData")
	public Object[][]getPastDatesErrorMessagesTestData()
	{
		String filePath = "C:\\Users\\prabh\\Documents\\Prasanthi\\Selenium with Java\\Batch2\\CapstoneProject\\InputData\\Data.xlsx";
		String sheetName = "searchHotelPagePastDates";
		return ExcelData.getExcelData(filePath, sheetName);
	}
	@Test(dataProvider="searchHotelPastDatesErrorMessagesTestData")
	public void validatePastDatesErrorMessages(String Location,String Hotels, String RoomType, String NumberofRooms,String CheckIndate,String CheckOutDate,String AdultsperRoom,String ChildrenperRoom,String ExpectedError) throws InterruptedException
	{
		searchhotelpage = new SearchHotelPage(driver);
		if(!Location.isEmpty())
		{
			searchhotelpage.SelectLocation(Location);	
			
		}
       	if(!Hotels.isEmpty())
		{
		searchhotelpage.selectHotels(Hotels);
		}
		if(!RoomType.isEmpty())
		{
		searchhotelpage.selectRoomType(RoomType);
		}
		if(!NumberofRooms.isEmpty())
		{
			searchhotelpage.selectNumberofRooms(NumberofRooms);
		}
		if(!CheckIndate.isEmpty())
		{
			searchhotelpage.CheckInDatetextbox.clear();
		searchhotelpage.SelectCheckInDate(CheckIndate);
		}
		if(!CheckOutDate.isEmpty())
		{
			searchhotelpage.CheckOutDatetextbox.clear();
		searchhotelpage.SelectCheckOutDate(CheckOutDate);
		}
		if(!AdultsperRoom.isEmpty())
		{
			searchhotelpage.SelectadultsperRoom(AdultsperRoom);
		}
		if(!ChildrenperRoom.isEmpty())
		{
		searchhotelpage.SelectChildrenperRoom(ChildrenperRoom);
		}
		
		Thread.sleep(10);
		searchhotelpage.SearchButtonClick();
		System.out.println(ExpectedError);
		
		if(ExpectedError.contains("Please enter valid CheckIn Date"))
		{
			try
			{
				Assert.assertTrue("CheckInDate error not displayed", searchhotelpage.isCheckInDateErrorDisplayed());
				Assert.assertEquals(ExpectedError, searchhotelpage.getCheckInDateErrorMessage());
				System.out.println("CheckInDate Error is dislayed correctly -- "+ExpectedError);
			}
						catch(Exception e)
			{
			System.out.println("Assertion failed: " + e.getMessage());
			Listener listener = new Listener(driver);
			String destination = "C:\\Users\\prabh\\Documents\\Prasanthi\\Selenium with Java\\Batch2\\CapstoneProject\\DefectScreenshots\\SearchHotel_CheckInPastDates.png";
			listener.capturedefectScreenshot(destination);
			throw e;
			}
		}
		else {
			System.out.println("checking");
		}
		
	}
	
}

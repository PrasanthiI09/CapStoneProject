package testclassnew;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import junit.framework.Assert;
import pageclass.SearchHotelPage;
import utils.ExcelData;

public class searchHotelTest extends ProjectSpecificMethod

{
	SearchHotelPage searchhotelpage;
	
	@DataProvider(name = "searchHotelErrorMessagesTestData")
	public Object[][]getSearchHotelErrorMessagesData()
	{
		String filePath = "C:\\Users\\prabh\\Documents\\Prasanthi\\Selenium with Java\\Batch2\\CapstoneProject\\InputData\\Data.xlsx";
		String sheetName = "searchHotelPageErrorMessages";
		return ExcelData.getExcelData(filePath, sheetName);
	}
	@Test(priority =1)
	public void validateSearchHotelElements()
	{
		searchhotelpage = new SearchHotelPage(driver);
		Assert.assertTrue("Not All Fileds are displayed", searchhotelpage.areAlltextsDisplayed());
		Assert.assertTrue("Not all Elements are displayed", searchhotelpage.areAllElementsDisplayed());
		System.out.println("Navigated successfully to Search Hotel Page after Loggingin. All Fields and Elements are  displayed");
	}
	@Test(dataProvider = "searchHotelErrorMessagesTestData",priority=2)
	public void validateSearchHotelElementsErorMessages(String Location,String Hotels, String RoomType, String NumberofRooms,String CheckIndate,String CheckOutDate,String AdultsperRoom,String ChildrenperRoom,String ExpectedError) throws InterruptedException
	{
		
		
		if(!Location.isEmpty())
		{
			searchhotelpage.SelectLocation(Location);	}
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
		if(CheckIndate ==null ||CheckIndate.isEmpty())
		{
			searchhotelpage.CheckInDatetextbox.clear();
		searchhotelpage.SelectCheckInDate(CheckIndate);
		}
		if(CheckOutDate ==null ||CheckOutDate.isEmpty())
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
		
		if(!ExpectedError.isEmpty())
		{
			if(ExpectedError.contains("Location"))
			{
				Assert.assertTrue("Location error not displayed", searchhotelpage.isLocationErrorDisplayed());
				Assert.assertEquals(ExpectedError, searchhotelpage.getLocationError());
				System.out.println("Location Error is dislayed correctly -- "+ExpectedError);
			}
			if(ExpectedError.contains("Total Number of Rooms"))
			{
				Assert.assertTrue("Number of Rooms error not displayed", searchhotelpage.isNumberOfRoomsErrorDisplayed());
				Assert.assertEquals(ExpectedError, searchhotelpage.getnumofRoomsErrorMessage());
				System.out.println("Number of Rooms Error is dislayed correctly -- "+ExpectedError);
			}
			if(ExpectedError.contains("Check-In Date"))
			{
				Assert.assertTrue("CheckInDate error not displayed", searchhotelpage.isCheckInDateErrorDisplayed());
				Assert.assertEquals(ExpectedError, searchhotelpage.getCheckInDateErrorMessage());
				System.out.println("CheckInDate Error is dislayed correctly -- "+ExpectedError);
			}
			if(ExpectedError.contains("Check-Out Date"))
			{
				Assert.assertTrue("CheckOutDate error not displayed", searchhotelpage.isCheckOutDateErrorDisplayed());
				Assert.assertEquals(ExpectedError, searchhotelpage.getCheckOutDateErrorMessage());
				System.out.println("CheckOutDate Error is dislayed correctly -- "+ExpectedError);
			}
			if(ExpectedError.contains("Adults per Room"))
			{
				Assert.assertTrue("Adults per Room error not displayed", searchhotelpage.isAdultsperRoomErrorDisplayed());
				Assert.assertEquals(ExpectedError, searchhotelpage.getAdultsperRoomErrorMessage());
				System.out.println("Adults per Room Error is dislayed correctly -- "+ExpectedError);
			}
			
		}
		
		
	}
	
	
	@DataProvider(name = "searchHotelTestData")
	public Object[][]getTestData()
	{
		String filePath = "C:\\Users\\prabh\\Documents\\Prasanthi\\Selenium with Java\\Batch2\\CapstoneProject\\InputData\\Data.xlsx";
		String sheetName = "searchHotelPageValidInputs";
		return ExcelData.getExcelData(filePath, sheetName);
	}
	@Test(dataProvider="searchHotelTestData",priority=3)
	public void validateSearchHotelPage(String Location,String Hotels, String RoomType, String NumberofRooms,String CheckIndate,String CheckOutDate,String AdultsperRoom,String ChildrenperRoom) throws InterruptedException
	{
		 
		 driver.navigate().to("https://adactinhotelapp.com/SearchHotel.php");
		 Thread.sleep(2000);
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
		
	}


	}

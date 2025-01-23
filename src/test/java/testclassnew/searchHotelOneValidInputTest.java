package testclassnew;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pageclass.SearchHotelPage;
import utils.ExcelData;

public class searchHotelOneValidInputTest extends ProjectSpecificMethod {

SearchHotelPage searchhotelpage;
	
	@DataProvider(name = "searchHotelOneValidInputValidate")
	public Object[][]getOneValidData()
	{
		String filePath = "C:\\Users\\prabh\\Documents\\Prasanthi\\Selenium with Java\\Batch2\\CapstoneProject\\InputData\\Data.xlsx";
		String sheetName = "searchHotelOneValidInput";
		return ExcelData.getExcelData(filePath, sheetName);
	}
	@Test(dataProvider="searchHotelOneValidInputValidate")
	public void validateOneValidInput(String Location,String Hotels, String RoomType, String NumberofRooms,String CheckIndate,String CheckOutDate,String AdultsperRoom,String ChildrenperRoom) throws InterruptedException
		{
			 searchhotelpage = new SearchHotelPage(driver);
			 System.out.println("------------------------------");
			 System.out.println("User navigated to Search Hotel Page after loggingin successfully");
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


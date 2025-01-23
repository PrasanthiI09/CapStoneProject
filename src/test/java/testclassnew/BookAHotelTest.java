package testclassnew;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import junit.framework.Assert;
import pageclass.BookAHotelPage;
import utils.ExcelData;
import utils.Listener;

public class BookAHotelTest extends ProjectSpecificMethod{

	String actualHotelname;
	BookAHotelPage bookahotelpage;
	searchHotelTest searchhoteltest = new searchHotelTest();
	selectHotelTest selecthoteltest = new selectHotelTest();
	logInTest logintest = new logInTest();
	
	@Test(priority=1)
	public void validteBookAHotelPage()
	{
			
		System.out.println("--------------------------------------");
		bookahotelpage = new BookAHotelPage(driver);
		String expectedheader = "Book A Hotel";
		Assert.assertEquals(expectedheader, bookahotelpage.header.getText());
		System.out.println("User Navigated to Book A Hotel Page");
	}
	@Test(priority=2)
	public void validaetBooKAHotelPageFieldsandValues()
	{
		Assert.assertTrue("Hotel Name field is not displayed",bookahotelpage.HotelName.isDisplayed());
		System.out.print("Hotel Name field");
		Assert.assertEquals(selecthoteltest.hotelName,bookahotelpage.actualHotelNameDisplayed);
		System.out.print("and Value displayed Correctly "+bookahotelpage.HotelName.getText()+"  :  "+bookahotelpage.HotelNameDisplayed.getAttribute("value"));
		System.out.println();
		
		Assert.assertTrue("Location field is not displayed",bookahotelpage.Location.isDisplayed());
		System.out.print("Location field");
		String expectedLocation = selecthoteltest.location;
		Assert.assertEquals(expectedLocation, bookahotelpage.actualLocationDisplayed);
		System.out.print("and valueis displayed correctly  "+bookahotelpage.Location.getText()+"  :  "+bookahotelpage.LocationDisplayed.getAttribute("value"));
		System.out.println();
		
		Assert.assertTrue("RoomType field is not displayed", bookahotelpage.RoomType.isDisplayed());
		System.out.print("RoomType field and");
		String expectedRoomType = selecthoteltest.roomtype;
		Assert.assertEquals(expectedRoomType, bookahotelpage.actualRoomTypeDisplayed);
		System.out.print("value is displayed correctly  "+bookahotelpage.RoomType.getText()+"  :  "+bookahotelpage.RoomTypeDisplayed.getAttribute("value"));
	    System.out.println();
		
		Assert.assertTrue("Number of Rooms field is not displayed" , bookahotelpage.NoOfRooms.isDisplayed());
		System.out.print("Number Of Rooms field and ");
		String expectedNoofRooms = selecthoteltest.rooms;
		Assert.assertEquals(expectedNoofRooms, bookahotelpage.actualNumberOfRoomsDisplayed);
		System.out.print("value displayed correctly "+bookahotelpage.NoOfRooms.getText()+"  :  "+bookahotelpage.NoOfRoomsDisplayed.getAttribute("value"));
		System.out.println();
		
		Assert.assertTrue("Total Days field is displayed", bookahotelpage.TotalDays.isDisplayed());
		System.out.print("Total Days field and ");
		String expectedTotalDays = selecthoteltest.noofdays;
		Assert.assertEquals(expectedTotalDays, bookahotelpage.actualTotalDaysDisplayed);
		System.out.print("value is displayed correctly "+bookahotelpage.TotalDays.getText()+"  :  "+bookahotelpage.TotalDaysDisplayed.getAttribute("value"));
		System.out.println();
		
		//Assert.assertEquals(selecthoteltest.pricepernight, bookahotelpage.PricePerNightDisplayed.getAttribute("value"));
		System.out.println("Price per Night is displayed : "+bookahotelpage.PricePerNight.getText()+"  :  "+bookahotelpage.PricePerNightDisplayed.getAttribute("value"));
		//Assert.assertEquals(selecthoteltest.totalprice, bookahotelpage.TotalPriceDisplayed.getAttribute("value"));
		System.out.println("Total Price is displayed : "+bookahotelpage.TotalPrice.getText()+"  :  "+bookahotelpage.TotalPriceDisplayed.getAttribute("value"));
		System.out.println("GST amount is : "+bookahotelpage.GST.getText()+"  :  "+bookahotelpage.GSTDisplayed.getAttribute("value"));
		System.out.println("Final Billed Price : "+bookahotelpage.FinalBilledPrice.getText()+"  :  "+bookahotelpage.FinalBilledPriceDisplayed.getAttribute("value"));
				
	}
	@DataProvider(name = "bookaHotelPageInvaliNameErrorMessagesTestData")
	public Object[][]getInvalidNameinputErrorMessagesTestData()
	{
		String filePath = "C:\\Users\\prabh\\Documents\\Prasanthi\\Selenium with Java\\Batch2\\CapstoneProject\\InputData\\Data.xlsx";
		String sheetName = "InvalidNameErrorMessage";
		return ExcelData.getExcelData(filePath, sheetName);
	}
	@Test(dataProvider="bookaHotelPageInvaliNameErrorMessagesTestData",priority=3)
	public void validateNameInvalidinput(String FirstName,String LastName,String BillingAddress,String CreditCardNo,String CreditCardType,String Month,String Year,String CVV,String ExpectedError) throws InterruptedException
	{
		if(!FirstName.isEmpty()||FirstName==null)
		{
			bookahotelpage.EnterFirstName(FirstName);
		}
		if(!LastName.isEmpty()||LastName==null||LastName.isEmpty())
		{
			bookahotelpage.EnterLastName(LastName);
		}
		if(!BillingAddress.isEmpty()||BillingAddress==null||BillingAddress.isEmpty())
		{
			bookahotelpage.EnterBillingAddress(BillingAddress);
		}
		if(!CreditCardNo.isEmpty()||CreditCardNo==null||CreditCardNo.isEmpty())
		{
			bookahotelpage.EnterCCnum(CreditCardNo);
		}
		if(!CreditCardType.isEmpty())
		{
			bookahotelpage.SelectCCType(CreditCardType);
		}
		if(!Month.isEmpty())
		{
			bookahotelpage.SelectExpMonth(Month);
		}
		if(!Year.isEmpty())
		{
			bookahotelpage.SelectExpYear(Year);
		}
		if(!CVV.isEmpty()||CVV==null||CVV.isEmpty())
		{
			bookahotelpage.enterCVVnum(CVV);
		}
		Thread.sleep(10);
		bookahotelpage.clickBookNow();
		Thread.sleep(10);
		if(!ExpectedError.isEmpty())
		{
			if(ExpectedError.contains("Please Enter Valid Name"))
			{
				try
				{
					Assert.assertTrue("Valid Name Error Message is not displayed", bookahotelpage.isFirstNameErrorMessageDisplayed());
					Assert.assertEquals(ExpectedError, bookahotelpage.getFirstNameErrorMessage());
					System.out.println("FirstName Error Message is displayed "+ExpectedError);
				}
				catch(Exception e)
				{
					System.out.println("Assertion failed: " + e.getMessage());
					Listener listener = new Listener(driver);
					String destination = "C:\\Users\\prabh\\Documents\\Prasanthi\\Selenium with Java\\Batch2\\CapstoneProject\\DefectScreenshots\\BookAHotel_InvalidNamesNOERRORDISPLAYED.png";
					listener.capturedefectScreenshot(destination);
					throw e;
				}
				
			}
				
			
			}
		
	}
	
	
}
	



package testclassnew;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import junit.framework.Assert;
import pageclass.BookAHotelPage;
import utils.ExcelData;
import utils.Listener;

public class BookAHotelInvalidCCYearTest extends ProjectSpecificMethod{

	BookAHotelPage bookahotelpage;
	logInTest logintest;
	searchHotelTest searchhoteltest;
	
	@DataProvider(name = "bookaHotelPageInvaliCCYearErrorMessagesTestData")
	public Object[][]getInvalidCCYearErrorMessagesTestData()
	{
		String filePath = "C:\\Users\\prabh\\Documents\\Prasanthi\\Selenium with Java\\Batch2\\CapstoneProject\\InputData\\Data.xlsx";
		String sheetName = "InvalidCCExpiryYear";
		return ExcelData.getExcelData(filePath, sheetName);
	}
	@Test(dataProvider="bookaHotelPageInvaliCCYearErrorMessagesTestData",priority=5)
	public void validateInvalidCCYearinput(String FirstName,String LastName,String BillingAddress,String CreditCardNo,String CreditCardType,String Month,String Year,String CVV,String ExpectedError) throws InterruptedException
	{
		bookahotelpage = new BookAHotelPage(driver);
	
		if(!FirstName.isEmpty()||FirstName==null||FirstName.isEmpty())
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
			try
			{
				
			
			if(ExpectedError.contains("Select Valid Year"))
			{
				Assert.assertTrue("Valid Year Error Message is not displayed", bookahotelpage.isCCYearErrorMessageDisplayed());
				Assert.assertEquals(ExpectedError, bookahotelpage.getCCYearErrorMessage());
				System.out.println("Valid Year Error Message is displayed "+ExpectedError);
			}
			}
			catch(Exception e)
			{
				System.out.println("Assertion failed: " + e.getMessage());
				Listener listener = new Listener(driver);
				String destination = "C:\\Users\\prabh\\Documents\\Prasanthi\\Selenium with Java\\Batch2\\CapstoneProject\\DefectScreenshots\\BookAHotel_CCExpYearPast.png";
				listener.capturedefectScreenshot(destination);
				throw e;
			}
	}
}
}

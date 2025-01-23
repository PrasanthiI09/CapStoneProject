package testclassnew;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pageclass.BookAHotelPage;
import utils.ExcelData;

public class BookAHotelValidDataTest extends ProjectSpecificMethod {

	BookAHotelPage bookahotelpage;
	logInTest logintest;
	searchHotelTest searchhoteltest;
	
	@DataProvider(name = "enterValidDetails")
	public Object[][]getValidDetailsofBookAHotel()
	{
		String filePath = "C:\\Users\\prabh\\Documents\\Prasanthi\\Selenium with Java\\Batch2\\CapstoneProject\\InputData\\Data.xlsx";
		String sheetName = "BookAHotelValidInputs";
		return ExcelData.getExcelData(filePath, sheetName);
	}
	@Test(dataProvider="enterValidDetails",priority=3)
	public void enterValidData(String FirstName,String LastName,String BillingAddress,String CreditCardNo,String CreditCardType,String Month,String Year,String CVV) throws InterruptedException
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
		Thread.sleep(20);
}
}

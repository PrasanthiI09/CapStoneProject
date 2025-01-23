package testclassnew;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import junit.framework.Assert;
import pageclass.BookAHotelPage;
import utils.ExcelData;

public class BookAHotelErrorMessages extends ProjectSpecificMethod{

	BookAHotelPage bookahotelpage;
	@DataProvider(name = "enterInValidDetails")
	public Object[][]getDetailsofErrorMessages()
	{
		String filePath ="C:\\Users\\prabh\\Documents\\Prasanthi\\Selenium with Java\\Batch2\\CapstoneProject\\InputData\\BookAHotelErrorMessages.xlsx";
		String sheetName = "BookHotelErrorMessages";
		return ExcelData.getExcelData(filePath, sheetName);
	}
	@Test(dataProvider="enterInValidDetails",priority=4)
	public void enterFNDetailsErrorMessages(String FirstName,String LastName,String BillingAddress,String CreditCardNo,String CreditCardType,String Month,String Year,String CVV,String ExpectedError) throws InterruptedException
	{
		bookahotelpage = new BookAHotelPage(driver);
		if(!FirstName.isEmpty()||FirstName.isEmpty()||FirstName==null)
		{
			bookahotelpage.EnterFirstName(FirstName);
		}
		if(!LastName.isEmpty()||LastName.isEmpty()||LastName==null)
		{
			bookahotelpage.EnterLastName(LastName);
		}
		if(!BillingAddress.isEmpty()||BillingAddress.isEmpty()||BillingAddress==null)
		{
			bookahotelpage.EnterBillingAddress(BillingAddress);
		}
		if(!CreditCardNo.isEmpty()||CreditCardNo.isEmpty()||CreditCardNo==null)
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
		if(!CVV.isEmpty()||CVV.isEmpty()||CVV==null)
		{
			bookahotelpage.enterCVVnum(CVV);
		}
		Thread.sleep(10);
		bookahotelpage.clickBookNow();
		Thread.sleep(10);
		if(!ExpectedError.isEmpty())
		{
			if(ExpectedError.contains("Please Enter your First Name"))
			{
				Assert.assertTrue("FirstName Error Message is not displayed", bookahotelpage.isFirstNameErrorMessageDisplayed());
				Assert.assertEquals(ExpectedError, bookahotelpage.getFirstNameErrorMessage());
				System.out.println("FirstName Error Message is displayed "+ExpectedError);
			}
			if(ExpectedError.contains("Please Enter your Last Name"))
			{
				Assert.assertTrue("LastName Error Message is not displayed", bookahotelpage.isLastNameErrorMessageDisplayed());
			    Assert.assertEquals(ExpectedError, bookahotelpage.getLastNameErrorMessage());
			    System.out.println("LastName Error Message is displayed "+ExpectedError);
			}
			if(ExpectedError.contains("Please Enter your Address"))
			{
				Assert.assertTrue("Billing Address is not displayed", bookahotelpage.isBillingAddressErrorMessageDisplayed());
				Assert.assertEquals(ExpectedError, bookahotelpage.getBillingAddressErrorMessage());
				System.out.println("Billing Address Error Message is displayed "+ExpectedError);
			}
			if(ExpectedError.contains("Please Enter your 16 Digit Credit Card Number"))
			{
				Assert.assertTrue("CC number error message is not displayed", bookahotelpage.isCCnumErrorMessageDisplayed());
				Assert.assertEquals(ExpectedError, bookahotelpage.getCCnumErrorMessage());
				System.out.println("CC number Error Message is displayed "+ExpectedError);
			}
			if(ExpectedError.contains("Please Select your Credit Card Type"))
			{
				Assert.assertTrue("CC Type Error message is not displayed", bookahotelpage.isCCTypeErrorMessageDisplayed());
				Assert.assertEquals(ExpectedError, bookahotelpage.getCCTypeErrorMessage());
				System.out.println("CC Type error message is displayed "+ExpectedError);
			}
			if(ExpectedError.contains("Please Select your Credit Card Expiry Month"))
			{
				Assert.assertTrue("CC Expiry Month error message is not displayed", bookahotelpage.isCCMonthErrorMessageDisplayed());
				Assert.assertEquals(ExpectedError, bookahotelpage.getCCMonthErrorMessageDisplayed());
				System.out.println("Cc Expiry Month is displayed "+ExpectedError);
			}
			if(ExpectedError.contains("Please Select your Credit Card Expiry Year"))
			{
				Assert.assertTrue("CC Expiry Year is not displayed", bookahotelpage.isCCYearErrorMessageDisplayed());
				Assert.assertEquals(ExpectedError, bookahotelpage.getCCYearErrorMessage());
				System.out.println("CC Expiry Year is displayed "+ExpectedError);
			}
			if(ExpectedError.contains("Please Enter your Credit Card CVV Number"))
			{
				Assert.assertTrue("CVV number is not displayed", bookahotelpage.isCVVnumErrorMessageDisplayed());
				Assert.assertEquals(ExpectedError, bookahotelpage.getCVVErrorMessage());
				System.out.println("CVV number error message is displayed "+ExpectedError);
     		}
			if(ExpectedError.contains("Please Enter your 16 Digit Credit Card Number"))
			{
				Assert.assertTrue("CC number error message is not displayed", bookahotelpage.isCCnumErrorMessageDisplayed());
				Assert.assertEquals(ExpectedError, bookahotelpage.getCCnumErrorMessage());
				System.out.println("CC number Error Message is displayed "+ExpectedError);
			}
}
	
	}
}
	
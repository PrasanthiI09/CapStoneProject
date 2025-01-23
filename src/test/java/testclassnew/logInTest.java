package testclassnew;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pageclass.LoginPage;
import utils.ExcelData;

public class logInTest extends ProjectSpecificMethod{
	
	LoginPage loginpage;
	
	@DataProvider(name = "logInTestData")
	public Object[][]getlogInData()
	{
		String filePath = "C:\\Users\\prabh\\Documents\\Prasanthi\\Selenium with Java\\Batch2\\CapstoneProject\\InputData\\Data.xlsx";
		String sheetName = "logInData";
		return ExcelData.getExcelData(filePath, sheetName);
	}
	@Test(dataProvider = "logInTestData")
	public void validatelogIn(String username, String password) throws InterruptedException
	{
		loginpage = new LoginPage(driver);
		loginpage.loginusername(username);
		loginpage.loginpassword(password);
		loginpage.clickloginbutton();
		String actualresult = "";
		if(username.isEmpty()&&loginpage.isUserNameErrorDisplayed())
		{
			actualresult = loginpage.getUserNameErrorMessage();
			System.out.println("User Name is Blank -- "+actualresult);
		}
		else if(password.isEmpty()&&loginpage.isPasswordErrorDisplayed())
		{
			actualresult = loginpage.getPasswordErrorMessage();
			System.out.println("Password is blank -- "+actualresult);
		}
		else if(loginpage.isAuthenticationErrorDisplayed())
		{
			actualresult = loginpage.getAuthenticationErrorMessage();
			System.out.println("Authentication Error -- "+actualresult);
			Thread.sleep(10);
		}
		else
		{
			actualresult = "LogIn Successful";
			System.out.println(actualresult);
		}
	}
	
	
	

}

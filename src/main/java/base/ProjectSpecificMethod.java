package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import utils.Utility;

public class ProjectSpecificMethod extends Utility
    {

		@Parameters({"browser","url"})
		@BeforeTest
		public void launchBrowser(String browser,String url)
	      {
	    	  initiateDriver(browser,url);
	      }
		@AfterTest
		public void closeBrowser()
		{
			closeDriver();
		}
	}


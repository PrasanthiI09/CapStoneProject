package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import base.ProjectSpecificMethod;

public class Listener extends ProjectSpecificMethod
		{
			public Listener(WebDriver driver)
			{
				this.driver=driver;
			}
			
			public void capturedefectScreenshot(String filepath)
			{
				
	        try
	          {
		
		      TakesScreenshot Defectscreenshot = (TakesScreenshot) driver;
		      File sourcefile = Defectscreenshot.getScreenshotAs(OutputType.FILE);
		      File destinationfile = new File(filepath);
		      FileUtils.copyFile(sourcefile, destinationfile);
		      System.out.println("Screenshot Saves at destination : "+destinationfile.getAbsolutePath());
		      } 
	        
	        catch (IOException e)
	        {
	        	System.err.println("Failed to save screenshot: " + e.getMessage());
	            e.printStackTrace();
		}
	        catch (Exception e) {
	            System.err.println("Unexpected error while capturing screenshot: " + e.getMessage());
	            e.printStackTrace();
	        }
		
		
	}
}


package pageclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificMethod;

public class LoginPage extends ProjectSpecificMethod
{
	public String actualusername;
	public String actualerrormessage;
	public String actualusernameblankerror;
	public String actualpasswordblankerror;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="username")
	WebElement usernametext;
	
	@FindBy(id="password")
	WebElement passwordtext;
	
	@FindBy(id="login")
	WebElement loginbutton;
	
	@FindBy(xpath="//input[@id='username_show']")
	WebElement usernameshowafterlogin;

	@FindBy(xpath = "//div[@class='auth_error']")
	WebElement authenticationerrormessage;
	
	@FindBy(xpath="//span[@id='username_span']")
	WebElement usernameblankerror;
	
	@FindBy(xpath="//span[@id='password_span']")
	WebElement passwordblankerror;
	
	public void loginusername(String username)
	{
		visibilityofElement(usernametext,5);
		usernametext.clear();
		usernametext.sendKeys(username);
	}
	public void loginpassword(String password)
	{
		passwordtext.clear();
		passwordtext.sendKeys(password);
	}
	public void clickloginbutton()
	{
		loginbutton.click();
	}
	public void validateloggedin()
	{

	visibilityofElement(usernameshowafterlogin,5);
	actualusername = usernameshowafterlogin.getAttribute("value");
	}
	
	public boolean isUserNameErrorDisplayed()
	{
		
		try {
			return usernameblankerror.isDisplayed();
		}
		catch(Exception e)
		{
			return false;
		}
	
	}
	public String getUserNameErrorMessage()
	{
		if(isUserNameErrorDisplayed())
		{
			return usernameblankerror.getText();
		}
		return "";
	}
	public boolean isPasswordErrorDisplayed()
	{
		
		try {
			return passwordblankerror.isDisplayed();
		}
		catch(Exception e)
		{
			return false;
		}
	
	}
	public String getPasswordErrorMessage()
	{
		if(isPasswordErrorDisplayed())
		{
			return passwordblankerror.getText();
		}
		return "";
	}
	
	public boolean isAuthenticationErrorDisplayed()
	{
		try
		{
			return authenticationerrormessage.isDisplayed();
		}
		catch(Exception e)
		{
			return false;
		}
	}
	public String getAuthenticationErrorMessage()
	{
		if(isAuthenticationErrorDisplayed())
		{
			return authenticationerrormessage.getText();
		}
		return "";
	}
}

package pageclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.ProjectSpecificMethod;

public class BookAHotelPage extends ProjectSpecificMethod{

	public String actualheader;
	public String HotelNameField;
	public String actualHotelNameDisplayed;
	public String actualLocationDisplayed;
	public String actualRoomTypeDisplayed;
	public String actualNumberOfRoomsDisplayed;
	public String actualTotalDaysDisplayed;
	public String actualPricePerNightDisplayed;
	public String actualTotalPriceDisplayed;
	public String actualGSTDisplayed;
	public String actualFinalBilledPriceDisplayed;
	public BookAHotelPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//td[@class='login_title'])[2]")
	public WebElement header;
	
	@FindBy(xpath = "//td[contains(text(),'Hotel Name')]")
	public WebElement HotelName;
	
	@FindBy(id="hotel_name_dis")
	public WebElement HotelNameDisplayed;
	
	@FindBy(xpath = "//td[contains(text(),'Location')]")
	public WebElement Location;
	
	@FindBy(id="location_dis")
	public WebElement LocationDisplayed;
	
	@FindBy(xpath = "//td[contains(text(),'Room Type')]")
	public WebElement RoomType;
	
	@FindBy(id="room_type_dis")
	public WebElement RoomTypeDisplayed;
	
	@FindBy(xpath = "//td[contains(text(),'Number of Rooms')]")
	public WebElement NoOfRooms;
	
	@FindBy(id="room_num_dis")
	public WebElement NoOfRoomsDisplayed;
	
	@FindBy(xpath = "//td[contains(text(),'Total Days')]")
	public WebElement TotalDays ;
	
	@FindBy(id="total_days_dis")
	public WebElement TotalDaysDisplayed;
	
	@FindBy(xpath = "//td[contains(text(),'Price per Night')]")
	public WebElement PricePerNight;
	
	@FindBy(id="price_night_dis")
	public WebElement PricePerNightDisplayed;
	
	
	@FindBy(xpath = "//td[contains(text(),'Total Price')]")
	public WebElement TotalPrice;
	
	@FindBy(id="total_price_dis")
	public WebElement TotalPriceDisplayed;
	
	@FindBy(xpath = "//td[contains(text(),'GST')]")
	public WebElement GST;
	
	@FindBy(id="gst_dis")
	public WebElement GSTDisplayed;
	
	@FindBy(xpath = "//td[contains(text(),'Final Billed Price')]")
	public WebElement FinalBilledPrice;
	
	@FindBy(id="final_price_dis")
	public WebElement FinalBilledPriceDisplayed;
	
	@FindBy(xpath = "//td[contains(text(),'First Name')]")
	WebElement FirstName;
	
	@FindBy(xpath="//input[@id='first_name']")
	WebElement FirstNameTextBox;
	
	@FindBy(xpath = "//td[contains(text(),'Last Name')]")
	WebElement LastName;
	
	@FindBy(xpath="//input[@id='last_name']")
	WebElement LastNameTextBox;
	
	@FindBy(xpath = "//td[contains(text(),'Billing Address')]")
	WebElement BillingAddress;
	
	@FindBy(xpath="//textarea[@id='address']")
	WebElement BillingAddressTextArea;
	
	@FindBy(xpath = "//td[contains(text(),'Credit Card No.')]")
	WebElement CreditCardNo;
	
	@FindBy(xpath="//input[@id='cc_num']")
	WebElement CCnoTextBox;
	
	
	@FindBy(xpath = "//td[contains(text(),'Credit Card Type')]")
	WebElement CreditCardType;
	
	@FindBy(xpath="//select[@id='cc_type']")
	WebElement CCtypedropdown;
	
	@FindBy(xpath = "//td[contains(text(),'Expiry Date')]")
	WebElement ExpiryDate;
	
	@FindBy(xpath="//select[@id='cc_exp_month']")
	WebElement expMonthdropdown;
	
	@FindBy(xpath="//select[@id='cc_exp_year']")
	WebElement expYeardropdown;
	
	@FindBy(xpath = "//td[contains(text(),'CVV Number')]")
	WebElement CVVNumberText;
	
	@FindBy(xpath="//input[@id='cc_cvv']")
	WebElement CVVTextBox;
	
	@FindBy(xpath="//input[@value='Book Now']")
	WebElement BookNowButton;
	
	@FindBy(xpath="//input[@value='Cancel']")
	WebElement CancelButton;
	
	@FindBy(xpath="//label[@id='first_name_span']")
	WebElement FirstNameErrorMessage;
	
	@FindBy(xpath="//label[@id='last_name_span']")
	WebElement LastNameErrorMessage;
	
	@FindBy(xpath="//label[@id='address_span']")
	WebElement BillingAddressErrorMessage;
	
	@FindBy(xpath="//label[@id='cc_num_span']")
	WebElement CCNumErrorMessage;
	
	@FindBy(xpath="//label[@id='cc_type_span']")
	WebElement CCTypeErrorMessage;
	
	@FindBy(xpath="//label[@id='cc_expiry_span']")
	WebElement CCExpiryErrorMessage;
	
	@FindBy(xpath="//label[@id='cc_cvv_span']")
	WebElement CVVErrorMessages;
	
	public void EnterFirstName(String FirstName)
	{
		
		FirstNameTextBox.clear();
		FirstNameTextBox.sendKeys(FirstName);
	}
	
	public void EnterLastName(String LastName)
	{
		
		LastNameTextBox.clear();
		LastNameTextBox.sendKeys(LastName);
	}
	public void EnterBillingAddress(String BillingAddress)
	{
		
		BillingAddressTextArea.clear();
		BillingAddressTextArea.sendKeys(BillingAddress);
	}
	
	public void EnterCCnum(String CreditCardNo)
	{
		visibilityofElement(CCnoTextBox,5);
		CCnoTextBox.clear();
		CCnoTextBox.sendKeys(CreditCardNo);
	}
	public void SelectCCType(String CreditCardType)
	{
		Select select = new Select(CCtypedropdown);
		select.selectByVisibleText(CreditCardType);
	}
	
	public void SelectExpMonth(String Month)
	{
		Select select = new Select(expMonthdropdown);
		select.selectByVisibleText(Month);
	}
	public void SelectExpYear(String Year)
	{
		Select select = new Select(expYeardropdown);
		select.selectByVisibleText(Year);
	}
	public void enterCVVnum(String CVVNumber)
	{
		visibilityofElement(CVVTextBox,5);
		CVVTextBox.clear();
		CVVTextBox.sendKeys(CVVNumber);
				}
	public void clickBookNow()
	{
		BookNowButton.click();
	}
	public boolean isFirstNameErrorMessageDisplayed()
	{
		visibilityofElement(FirstNameErrorMessage,5);
	    return FirstNameErrorMessage.isDisplayed();
	}
	public String getFirstNameErrorMessage()
	{
		if(isFirstNameErrorMessageDisplayed())
		{
			return FirstNameErrorMessage.getText();
		}
		return "";
	}
	public boolean isLastNameErrorMessageDisplayed()
	{
		visibilityofElement(LastNameErrorMessage,5);
		return LastNameErrorMessage.isDisplayed();
	}
	public String getLastNameErrorMessage()
	{
		if(isLastNameErrorMessageDisplayed())
		{
			return LastNameErrorMessage.getText();
		}
		return "";
	}
	public boolean isBillingAddressErrorMessageDisplayed()
	{
		visibilityofElement(BillingAddressErrorMessage,5);
		return BillingAddressErrorMessage.isDisplayed();
	}
	public String getBillingAddressErrorMessage()
	{
		if(isBillingAddressErrorMessageDisplayed())
		{
			return BillingAddressErrorMessage.getText();
		}
		return "";
	}
	public boolean isCCnumErrorMessageDisplayed()
	{
		visibilityofElement(CCNumErrorMessage,5);
		return CCNumErrorMessage.isDisplayed();
	}
	public String getCCnumErrorMessage()
	{
		if(isCCnumErrorMessageDisplayed())
		{
			return CCNumErrorMessage.getText();
		}
		return "";
	}
	public boolean isCCTypeErrorMessageDisplayed()
	{
		visibilityofElement(CCTypeErrorMessage,5);
		return CCTypeErrorMessage.isDisplayed();
	}
	public String getCCTypeErrorMessage()
	{
		if(isCCTypeErrorMessageDisplayed())
		{
			return CCTypeErrorMessage.getText();
		}
		return "";
	}
	public boolean isCCMonthErrorMessageDisplayed()
	{
		visibilityofElement(CCExpiryErrorMessage,5);
		return CCExpiryErrorMessage.isDisplayed();
	}
	public String getCCMonthErrorMessageDisplayed()
	{
		if(isCCMonthErrorMessageDisplayed())
		{
			return CCExpiryErrorMessage.getText();
		}
		return "";
	}
	public boolean isCCYearErrorMessageDisplayed()
	{
		visibilityofElement(CCExpiryErrorMessage,5);
		return CCExpiryErrorMessage.isDisplayed();
	}
	public String getCCYearErrorMessage()
	{
		if(isCCYearErrorMessageDisplayed())
		{
			return CCExpiryErrorMessage.getText();
		}
		return "";
	}
	public boolean isCVVnumErrorMessageDisplayed()
	{
		visibilityofElement(CVVErrorMessages,5);
		return CVVErrorMessages.isDisplayed();
	}
	public String getCVVErrorMessage()
	{
		if(isCVVnumErrorMessageDisplayed())
		{
			return CVVErrorMessages.getText();
		}
		return "";
	}
	
}

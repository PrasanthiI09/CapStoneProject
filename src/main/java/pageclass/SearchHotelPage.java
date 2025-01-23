package pageclass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.ProjectSpecificMethod;

public class SearchHotelPage extends ProjectSpecificMethod
{

	public String actuallocationerrormessage;
	public String actualnumberofroomserrormessage;
	public String actualCheckInDateerrormessage;
	public String actualCheckOutDateerrormessage;
	public String actualAdultdperRoomerrormessage;
	
	public SearchHotelPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//td[contains(text(),'Location')]")
	WebElement LocationText;
		
	@FindBy(id="location")
	public	WebElement selectLocationdropdown;
	
	@FindBy(xpath = "//td[contains(text(),'Hotels')]")
	WebElement HotelsText;
	
	@FindBy(id="hotels")
	public 	WebElement selectHotelsdropdown;
	
	@FindBy(xpath="//td[contains(text(),'Room Type')]")
	WebElement RoomTypeText;
	
	@FindBy(id="room_type")
	public	WebElement selectRoomTypedropdown;
	
	@FindBy(xpath="//td[contains(text(),'Number of Rooms')]")
	WebElement NumberofRoomsText;
	
	@FindBy(id="room_nos")
	public WebElement selectNumberofRoomsdropdown;
	
	@FindBy(xpath="//td[contains(text(),'Check In Date')]")
	WebElement CheckInDateText;
	
	@FindBy(id="datepick_in")
	public	WebElement CheckInDatetextbox;
	
	@FindBy(xpath="//td[contains(text(),'Check Out Date')]")
	WebElement CheckOutDateText;
	
	@FindBy(id="datepick_out")
	public WebElement CheckOutDatetextbox;
	
	@FindBy(xpath="//td[contains(text(),'Adults per Room')]")
	WebElement adultsperRoomText;
	
	@FindBy(id="adult_room")
	public WebElement adultsperRoomdropdown;
	
	@FindBy(xpath="//td[contains(text(),'Children per Room')]")
	WebElement ChildrenperRoomText;
	
	@FindBy(id="child_room")
	public WebElement ChildrenperRoomdropdown;
	
	@FindBy(id="location_span")
	WebElement locationErrorMessage;
	
	@FindBy(id="num_room_span")
	public WebElement numofRoomsErrorMessage;
	
	@FindBy(id="checkin_span")
	public WebElement CheckInErrorMessage;
	
	@FindBy(id="checkout_span")
	public WebElement CheckOutErrorMessage;
	
	@FindBy(id="adults_room_span")
	public WebElement AdultsErrorMessage;
	 
	@FindBy(xpath="//input[@type='submit']")
	public WebElement SearchButton;
	
	public void SelectLocation(String Location)
	{
		visibilityofElement(selectLocationdropdown,10);
		Select select = new Select(selectLocationdropdown);
		select.selectByVisibleText(Location);
		
	}
	public void selectHotels(String Hotel)
	{
		Select select = new Select(selectHotelsdropdown);
		select.selectByVisibleText(Hotel);
	}
	public void selectRoomType(String RoomType)
	{
		Select select = new Select(selectRoomTypedropdown);
		select.selectByVisibleText(RoomType);
	}
	public void selectNumberofRooms(String NumberOfRooms)
	{
		Select select = new Select(selectNumberofRoomsdropdown);
		select.selectByVisibleText(NumberOfRooms);
	}
	public void SelectCheckInDate(String CheckInDate)
	{
		CheckInDatetextbox.clear();
		CheckInDatetextbox.sendKeys(CheckInDate);
	}
	public void SelectCheckOutDate(String CheckOutDate)
	{
		CheckOutDatetextbox.clear();
		CheckOutDatetextbox.sendKeys(CheckOutDate);
	}
	public void SelectadultsperRoom(String AdultsperRoom)
	{
		Select select = new Select(adultsperRoomdropdown);
		select.selectByVisibleText(AdultsperRoom);
	}
	public void SelectChildrenperRoom(String ChildrenperRoom)
	{
		Select select = new Select(ChildrenperRoomdropdown);
		select.selectByVisibleText(ChildrenperRoom);
		
	}
	
	public void SearchButtonClick()
	{
		visibilityofElement(SearchButton,10);
		SearchButton.click();
	}
	
	public boolean validtedropdownoptions(List<WebElement> actualoptions, List<String> expectedoptions)
	{
		for(String expectedoption : expectedoptions)
		{
			boolean isFound = false;
			for(WebElement actualoption:actualoptions)
			{
				if(actualoption.getText().equals(expectedoption))
				{
					isFound = true;
					break;
				}
			}
			if(!isFound)
			{
				return false;
			}
		}
		return true;
		
	}
	public boolean isLocationErrorDisplayed()
	{
		return locationErrorMessage.isDisplayed();
	}
	public String getLocationError()
	{
		if(isLocationErrorDisplayed())
		{
			return locationErrorMessage.getText();
		}
		return "";
	}
	public boolean isNumberOfRoomsErrorDisplayed()
	{
		return numofRoomsErrorMessage.isDisplayed();
		
	}
	public String getnumofRoomsErrorMessage()
	{
		if(isNumberOfRoomsErrorDisplayed())
		{
			return numofRoomsErrorMessage.getText();
		}
		return "";
	}
	public boolean isCheckInDateErrorDisplayed()
	{
		return CheckInErrorMessage.isDisplayed();
	}
	public String getCheckInDateErrorMessage()
	{
		if(isCheckInDateErrorDisplayed())
		{
			return CheckInErrorMessage.getText();
		}
		return "";
	}
	public boolean isCheckOutDateErrorDisplayed()
	{
		return CheckOutErrorMessage.isDisplayed();
	}
	public String getCheckOutDateErrorMessage()
	{
		if(isCheckOutDateErrorDisplayed())
		{
			return CheckOutErrorMessage.getText();
		}
		return "";
	}
	public boolean isAdultsperRoomErrorDisplayed()
	{
		return AdultsErrorMessage.isDisplayed();
	}
	public String getAdultsperRoomErrorMessage()
	{
		if(isAdultsperRoomErrorDisplayed())
		{
			return AdultsErrorMessage.getText();
		}
		return "";
	}
	public boolean areAlltextsDisplayed()
	{
		return LocationText.isDisplayed() && 
			   HotelsText.isDisplayed() &&
			   RoomTypeText.isDisplayed() &&
			   NumberofRoomsText.isDisplayed() &&
			   CheckInDateText.isDisplayed() &&
			   CheckOutDateText.isDisplayed() &&
			   adultsperRoomText.isDisplayed() &&
			   ChildrenperRoomText.isDisplayed();
		
	}
	
	public boolean areAllElementsDisplayed()
	{
		return selectLocationdropdown.isDisplayed() &&
			   selectHotelsdropdown.isDisplayed() &&
			   selectRoomTypedropdown.isDisplayed() &&
			   selectNumberofRoomsdropdown.isDisplayed() &&
			   CheckInDatetextbox.isDisplayed() &&
			   CheckOutDatetextbox.isDisplayed() &&
			   adultsperRoomdropdown.isDisplayed() &&
			   ChildrenperRoomdropdown.isDisplayed();
	}
	
	
}

package pageclass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificMethod;

public class SelectHotelPageOLD extends ProjectSpecificMethod{

	public String actualSeletHotelText;
	public String actualNoOfDays;
	public String actualHotelName;
	public String actualLocation;
	public String actualNoOfRooms;
	public String actualArrivalDate;
	public String actualDepartureDate;
	public String actualRoomType;
	public String actualPricePerNight;
	public String actualTotalPriceNoGST;
	
	public SelectHotelPageOLD(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(tagName="td")
	public List<WebElement> allElementsOfSelectHotel;
	
	@FindBy(xpath="//td[@class='login_title']")
	WebElement SelectHotelText; 
		
	@FindBy(tagName = "input")
	public List<WebElement> allValuesofSelectHotel;
	
	@FindBy(xpath = "//strong[contains(text(),'Hotel Name')]")
	WebElement HotelNameField;
	
	@FindBy(xpath="//input[@name='hotel_name_0']")
	WebElement HotelNameValue;
	
	@FindBy(xpath="//strong[contains(text(),'Location')]")
	WebElement LocationField;
	
	@FindBy(id="location_0")
	WebElement LocationValue;
	
	@FindBy(xpath="//strong[contains(text(),'Rooms')]")
	WebElement NoOfRoomsFiled;
	
	@FindBy(id="rooms_0")
	WebElement NoOfRoomsValue;
	
	@FindBy(xpath="//strong[contains(text(),'Arrival Date')]")
	WebElement ArrivalDateFiled;
	
	@FindBy(id="arr_date_0")
	WebElement ArrivalDateValue;
	
	@FindBy(xpath="//strong[contains(text(),'Departure Date')]")
	WebElement DepartureDateField;
	
	@FindBy(id="dep_date_0")
	WebElement DepartureDateValue;
	
	@FindBy(xpath="//strong[contains(text(),'No. of Days')]")
	WebElement NoOfDaysFiled;
	
	@FindBy(id="no_days_0")
	public WebElement NoOfDaysValue;
	
	@FindBy(xpath="//strong[contains(text(),'Rooms Type')]")
	WebElement RoomsTypeField;
	
	@FindBy(id="room_type_0")
	WebElement RoomTypeValue;
	
	@FindBy(xpath="//strong[contains(text(),'Price per Night')]")
	WebElement PricePerNightField;
	
	@FindBy(id="price_night_0")
	WebElement PricePerNightValue;
	
	@FindBy(xpath="//strong[contains(text(),'Total Price (excl. GST)')]")
	WebElement TotalPriceFieldNoGST;
	
	@FindBy(id="total_price_0")
	WebElement TotalPriceValueNoGST;
	
	
	
	public void SelectHotelText()
	{
		visibilityofElement(SelectHotelText,10);
		actualSeletHotelText = SelectHotelText.getText();
	}
	
	public List<WebElement> getAllElementsOfSelectHotel()
	{
		return allElementsOfSelectHotel;
		
	}
	public List<WebElement> getAllValuesOfSelectHotel()
	{
		return allValuesofSelectHotel;
	}
	public void HotelName()
	{
		actualHotelName = HotelNameValue.getAttribute("value");
	}
	public void Location()
	{
		actualLocation = LocationValue.getAttribute("value");
	}
	public void NoOfRooms()
	{
		actualNoOfRooms = NoOfRoomsValue.getAttribute("value");
	}
	public void ArrivalDate()
	{
		actualArrivalDate = ArrivalDateValue.getAttribute("value");
	}
	public void DepartureDate()
	{
		actualDepartureDate = DepartureDateValue.getAttribute("value");
	}
	public void NoofDaysValue()
	{
		actualNoOfDays = NoOfDaysValue.getAttribute("value");
	}
	public void RoomType()
	{
		actualRoomType = RoomTypeValue.getAttribute("value");
	}
	public void PricePerNight()
	{
		actualPricePerNight = PricePerNightValue.getAttribute("value");
	}
	public void TotalPriceNoGST()
	{
		actualTotalPriceNoGST = TotalPriceValueNoGST.getAttribute("value");
	}
	
}

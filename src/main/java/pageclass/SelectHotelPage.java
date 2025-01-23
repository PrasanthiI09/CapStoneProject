package pageclass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificMethod;

public class SelectHotelPage extends ProjectSpecificMethod{

	public SelectHotelPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//table[2]//table[1]//table//tbody")
	public WebElement tabledataBody;
	
	@FindBy(xpath="//table[2]//table[1]//table//tbody/tr")
	public List<WebElement> tabledataRows;
	
	@FindBy(id="radiobutton_0")
	public	WebElement radiobutton;
	
	@FindBy(id="continue")
	public WebElement continuebutton;
	
	public String getCellData(int rowIndex, int collIndex)
	{
		if(rowIndex<0||rowIndex>=tabledataRows.size())
		{
			throw new IndexOutOfBoundsException("Row index out of bounds: " + rowIndex);
		}
		WebElement row = tabledataRows.get(rowIndex);
		List<WebElement> cells = row.findElements(By.tagName("input"));
		if(collIndex<0||collIndex>=cells.size())
		{
			throw new IndexOutOfBoundsException("Column index out of bounds: " + collIndex);
		}
		return cells.get(collIndex).getAttribute("value");
	}
	public String getHotelName(int rowIndex) {
        return getCellData(rowIndex, 2); 
    }

    public String getLocation(int rowIndex) {
        return getCellData(rowIndex, 3);
    }

    public String getNumberOfRooms(int rowIndex) {
        return getCellData(rowIndex, 4);
    }

    public String getArrivalDate(int rowIndex) {
        return getCellData(rowIndex, 5);
    }

    public String getDepartureDate(int rowIndex) {
        return getCellData(rowIndex, 6);
    }
    public String getNoofDays(int rowIndex) {
        return getCellData(rowIndex, 7);
    }

    public String getRoomType(int rowIndex) {
        return getCellData(rowIndex, 8);
    }
    public String getPriceperNight(int rowIndex) {
        return getCellData(rowIndex, 9);
    }
    public String getTotalPriceexlGST(int rowIndex) {
        return getCellData(rowIndex, 10);
    }
    

   public boolean validateHotelNameData(String expectedHotelName, int rowIndex) {
        String actualHotelName = getHotelName(rowIndex);
        return actualHotelName.equals(expectedHotelName);
    }
    public boolean validateLocationData(String expectedLocation, int rowIndex) {
        String actualLocation = getLocation(rowIndex);
        return actualLocation.equals(expectedLocation);
    }

public boolean validateRoomsData(String expectedRooms, int rowIndex) {
    String actualRooms = getNumberOfRooms(rowIndex);
    return actualRooms.equals(expectedRooms);
}
public boolean validateArrivalDateData(String expectedArrivalDate, int rowIndex) {
    String actualArrivalDate = getArrivalDate(rowIndex);
    return actualArrivalDate.equals(expectedArrivalDate);
}
public boolean validateDepartureDateData(String expectedDepartureDate, int rowIndex) {
    String actualDepartureDate = getDepartureDate(rowIndex);
    return actualDepartureDate.equals(expectedDepartureDate);
}
public boolean validateNoofDaysData(String expectedNoofDays, int rowIndex) {
    String actualNoofDays = getNoofDays(rowIndex);
    return actualNoofDays.equals(expectedNoofDays);
}
public boolean validateRoomTypeData(String expectedRoomType, int rowIndex) {
    String actualRoomType = getRoomType(rowIndex);
    return actualRoomType.equals(expectedRoomType);
}
}


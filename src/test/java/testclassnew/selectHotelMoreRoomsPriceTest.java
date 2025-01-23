package testclassnew;

import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import junit.framework.Assert;
import pageclass.SelectHotelPage;
import utils.Listener;

public class selectHotelMoreRoomsPriceTest extends ProjectSpecificMethod{

	
	String numofroomsstr;
	String pricepernightstr;
	double expectedtotalprice;
	String actualtotalpricestr;
	double actualtotalprice;
	SelectHotelPage selecthotelpage;
	
	@Test
	public void MoreDaysTotalPriceofRoom()
	{
	try
	{
	selecthotelpage = new SelectHotelPage(driver);
	numofroomsstr = selecthotelpage.getNumberOfRooms(1);
	pricepernightstr = selecthotelpage.getPriceperNight(1);
	int numofrooms = Integer.parseInt(numofroomsstr.replaceAll("[^0-9]", ""));
	double pricepernight = Double.parseDouble(pricepernightstr.replaceAll("[^0-9]", ""));
	expectedtotalprice = numofrooms*pricepernight+10;
	actualtotalpricestr = selecthotelpage.getTotalPriceexlGST(1);
	double actualtotalprice = Double.parseDouble(actualtotalpricestr.replaceAll("[^0-9]", ""));
	Assert.assertEquals(expectedtotalprice, actualtotalprice);
	System.out.println("Total Price for "+numofrooms+" rooms is displayed correctly as : $"+actualtotalprice);
	
	}
	catch(Throwable t) {
		System.out.println("Assertion failed: " + t.getMessage());
		Listener listener = new Listener(driver);
		String destination = "C:\\Users\\prabh\\Documents\\Prasanthi\\Selenium with Java\\Batch2\\CapstoneProject\\DefectScreenshots\\SelectHotel_HotelPricewhenMoreRooms.png";
		listener.capturedefectScreenshot(destination);
		throw t;
		
	}
	}
}

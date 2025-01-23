package testclassnew;

import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import junit.framework.Assert;
import pageclass.SelectHotelPage;

public class selectHotelMoreDaysPriceTest extends ProjectSpecificMethod{

	String numofdaysstr;
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
	numofdaysstr = selecthotelpage.getNoofDays(1);
	pricepernightstr = selecthotelpage.getPriceperNight(1);
	int numofdays = Integer.parseInt(numofdaysstr.replaceAll("[^0-9]", ""));
	double pricepernight = Double.parseDouble(pricepernightstr.replaceAll("[^0-9]", ""));
	expectedtotalprice = numofdays*pricepernight+10;
	actualtotalpricestr = selecthotelpage.getTotalPriceexlGST(1);
	double actualtotalprice = Double.parseDouble(actualtotalpricestr.replaceAll("[^0-9]", ""));
	Assert.assertEquals(expectedtotalprice, actualtotalprice);
	System.out.println("Total Price for "+numofdays+" days is displayed correctly as : $"+actualtotalprice);
	
	
	
	}
	catch(Exception e) {
		System.out.println("Exception occured");
	}
	}
	
}

package testclassnew;

import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pageclass.SelectHotelPage;

public class selectHotelTest extends ProjectSpecificMethod{

	SelectHotelPage selecthotelpage;
	String hotelName;
	String location;
	String roomtype;
	String rooms;
	String noofdays;
	String pricepernight;
	String totalprice;
	@Test
	public void validateSelectHotelPageFields()
	{
		System.out.println("------------------------------------------");
		try
		{
		selecthotelpage = new SelectHotelPage(driver);
		
		hotelName = selecthotelpage.getHotelName(1);
		location = selecthotelpage.getLocation(1); 
		rooms = selecthotelpage.getNumberOfRooms(1);
        String arrivalDate = selecthotelpage.getArrivalDate(1);
        String departuredate = selecthotelpage.getDepartureDate(1);
        noofdays = selecthotelpage.getNoofDays(1);
        roomtype = selecthotelpage.getRoomType(1);
        pricepernight = selecthotelpage.getPriceperNight(1);
        totalprice = selecthotelpage.getTotalPriceexlGST(1);
        
        if (selecthotelpage.validateHotelNameData("Hotel Sunshine", 1)) {
            System.out.println("Hotel data validation passed! --Hotel Name: " + hotelName);
        } else {
            System.out.println("Hotel data validation failed.");
        }
        if (selecthotelpage.validateLocationData("London", 1)) {
            System.out.println("Location validation passed!-- Location :"+location);
        } else {
            System.out.println("Location validation failed.");
        }
        if (selecthotelpage.validateRoomsData("1 Rooms",1))
        		{
            System.out.println("Rooms validation passed!-- Number of Rooms : "+rooms);
        } else {
            System.out.println("Rooms validation failed.");
        }
        if (selecthotelpage.validateArrivalDateData("24/05/2025", 1)) {
            System.out.println("Arrival Date validation passed!-- Arrival Date :"+arrivalDate);
        } else {
            System.out.println("ArrivalDate validation failed.");
        }
        if (selecthotelpage.validateDepartureDateData("25/05/2025", 1)) {
            System.out.println("Departure Date validation passed!-- Departure Date :"+departuredate);
        } else {
            System.out.println("DepartureDate validation failed.");
        }
        if (selecthotelpage.validateNoofDaysData("1 - One", 1)) {
            System.out.println("NoofDays validation passed!-- Number of Days : "+noofdays);
        } else {
            System.out.println("NoofDays validation failed.");
        }
        if (selecthotelpage.validateRoomTypeData("Standard", 1)) {
            System.out.println("RoomType validation passed!-- Room Type : "+roomtype);
        } else {
            System.out.println("RoomType validation failed.");
        }
        System.out.println("Price per Night is displayed : "+pricepernight);
        System.out.println("Total Price displayed : "+totalprice);
		System.out.println("----------------------------------------------");
		}catch(Exception e)
		{
			System.out.println("Exception occured");
		}
		
		selecthotelpage.radiobutton.click();
		selecthotelpage.continuebutton.click();
	}
}

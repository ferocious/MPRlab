package db.app.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FlightData extends Entity {

	private String flightNo;
	private AirlineData airline;
	private String airplaneType;
	private AirportData flightFrom;
	private AirportData flightTo;
	private Date departureDate;
	private Date arrivalDate;
	private List<PassengerData> passengersList = new ArrayList<>();
	
	
	public String getAirplaneType() {
		return airplaneType;
	}

	public void setAirplaneType(String airplaneType) {
		this.airplaneType = airplaneType;
	}

	public String getFlightNo() {
		return flightNo;
	}
	
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	
	public AirlineData getAirline() {
		return airline;
	}
	
	public void setAirline(AirlineData airline) {
		this.airline = airline;
	}
	
	public AirportData getFlightFrom() {
		return flightFrom;
	}
	
	public void setFlightFrom(AirportData flightFrom) {
		this.flightFrom = flightFrom;
	}
	
	public AirportData getFlightTo() {
		return flightTo;
	}
	
	public void setFlightTo(AirportData flightTo) {
		this.flightTo = flightTo;
	}
	
	public Date getDepartureDate() {
		return departureDate;
	}
	
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	
	public Date getArrivalDate() {
		return arrivalDate;
	}
	
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	
	public List<PassengerData> getPassengersList() {
		return passengersList;
	}
	
	public void setPassengersList(List<PassengerData> passengersList) {
		this.passengersList = passengersList;
	}
	
	
	
}

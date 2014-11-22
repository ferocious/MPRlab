package db.app.domain;

import java.sql.Timestamp;


public class FlightData extends Entity {

	private String flightNo;
	private Timestamp departureDate;
	private Timestamp arrivalDate;
	private Timestamp createDate;
	private AirportData departureAirport;
	private AirportData arrivalAirport;
	private AirlineData airline;
	
	public String getFlightNo() {
		return flightNo;
	}
	
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	
	public Timestamp getDepartureDate() {
		return departureDate;
	}
	
	public void setDepartureDate(Timestamp departureDate) {
		this.departureDate = departureDate;
	}
	
	public Timestamp getArrivalDate() {
		return arrivalDate;
	}
	
	public void setArrivalDate(Timestamp arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	
	public Timestamp getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	
	public AirportData getDepartureAirport() {
		return departureAirport;
	}
	
	public void setDepartureAirport(AirportData departureAirport) {
		this.departureAirport = departureAirport;
	}
	
	public AirportData getArrivalAirport() {
		return arrivalAirport;
	}
	
	public void setArrivalAirport(AirportData arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}
	
	public AirlineData getAirline() {
		return airline;
	}
	
	public void setAirline(AirlineData airline) {
		this.airline = airline;
	}
	
	@Override
	public String toString() {
		return "FlightData [flightNo=" + flightNo + ", departureDate="
				+ departureDate + ", arrivalDate=" + arrivalDate
				+ ", createDate=" + createDate + ", departureAirport="
				+ departureAirport + ", arrivalAirport=" + arrivalAirport
				+ ", airline=" + airline + "]";
	}
	
}

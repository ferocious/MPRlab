package db.app.domain;

public class AirportData extends Entity {

	private String airportCode;
	private String airportCity;
	private String airportAddress;
	private CountryData country;
	
	public String getAirportCode() {
		return airportCode;
	}
	
	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}
	
	public String getAirportCity() {
		return airportCity;
	}
	
	public void setAirportCity(String airportCity) {
		this.airportCity = airportCity;
	}
	
	public String getAirportAddress() {
		return airportAddress;
	}
	
	public void setAirportAddress(String airportAddress) {
		this.airportAddress = airportAddress;
	}

	public CountryData getCountry() {
		return country;
	}

	public void setCountry(CountryData country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "AirportData [airportCode=" + airportCode + ", airportCity="
				+ airportCity + ", airportAddress=" + airportAddress
				+ ", country=" + country + "]";
	}
}

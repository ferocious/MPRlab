package db.app.domain;

public class AirlineData extends Entity {

	private String airlineCode;
	private String name;
	private CountryData airlineCountry;
	
	public String getAirlineCode() {
		return airlineCode;
	}
	
	public void setAirlineCode(String airlineCode) {
		this.airlineCode = airlineCode;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public CountryData getAirlineCountry() {
		return airlineCountry;
	}

	public void setAirlineCountry(CountryData airlineCountry) {
		this.airlineCountry = airlineCountry;
	}

	@Override
	public String toString() {
		return "AirlineData [airlineCode=" + airlineCode + ", name=" + name
				+ ", airlineCountry=" + airlineCountry + "]";
	}
	
}

package db.app.domain;

public class PassengerData extends Entity {

	private String firstName;
	private String lastName;
	private String idType;
	private String idNo;
	private CountryData country;
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getIdType() {
		return idType;
	}
	
	public void setIdType(String idType) {
		this.idType = idType;
	}
	
	public String getIdNo() {
		return idNo;
	}
	
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	
	public CountryData getCountry() {
		return country;
	}
	
	public void setCountry(CountryData country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "PassengerData [firstName=" + firstName + ", lastName="
				+ lastName + ", idType=" + idType + ", idNo=" + idNo
				+ ", country=" + country + "]";
	}
	
}

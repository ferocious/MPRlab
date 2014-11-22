package db.app.domain;

public class CountryData extends Entity {

	private String code;
	private String name;
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CountryData [id=" + getId() + ", code=" + code + ", name=" + name + "]";
	}
}

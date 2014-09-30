package db.app.domain;

public class PassengerData {

	private String name;
	private String reservationNo;
	private String idType;
	private String luggageInfo;
	private String priority;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getReservationNo() {
		return reservationNo;
	}
	
	public void setReservationNo(String reservationNo) {
		this.reservationNo = reservationNo;
	}
	
	public String getIdType() {
		return idType;
	}
	
	public void setIdType(String idType) {
		this.idType = idType;
	}
	
	public String getLuggageInfo() {
		return luggageInfo;
	}
	
	public void setLuggageInfo(String luggageInfo) {
		this.luggageInfo = luggageInfo;
	}
	
	public String getPriority() {
		return priority;
	}
	
	public void setPriority(String priority) {
		this.priority = priority;
	}
	
	
	
}

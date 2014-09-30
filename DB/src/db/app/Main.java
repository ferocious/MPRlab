package db.app;

import db.app.domain.AirlineData;

public class Main {

	public static void main(String[] args){
		System.out.println("Project by Dorota Gmerek");
		System.out.println();
	
		AirlineData airline1 = new AirlineData();
		airline1.setAirlineCode("LH");
		airline1.setAirlineCountry("Germany");
		airline1.setName("Lufthansa");
	
		AirlineData airline2 = new AirlineData();
		airline2.setAirlineCode("WIZZ");
		airline2.setAirlineCountry("Hungary");
		airline2.setName("Wizzair");
		
		AirlineData airline3 = new AirlineData();
		airline3.setAirlineCode("RY");
		airline3.setAirlineCountry("Ireland");
		airline3.setName("Ryanair");
		
		System.out.println("AIRLINES:");
		System.out.println("\n");
		System.out.println("Name: " + airline1.getName() + "\n" + "Code: " + airline1.getAirlineCode() + "\n" + "Country: " + airline1.getAirlineCountry());
		System.out.println("\n");
		System.out.println("Name: " + airline2.getName() + "\n" + "Code: " + airline2.getAirlineCode() + "\n" + "Country: " + airline2.getAirlineCountry());
		System.out.println("\n");
		System.out.println("Name: " + airline3.getName() + "\n" + "Code: " + airline3.getAirlineCode() + "\n" + "Country: " + airline3.getAirlineCountry());
		
	
	
	}
	
}

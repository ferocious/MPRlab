package db.app.repositories.impl;

import java.util.ArrayList;
import java.util.List;

import db.app.domain.AirlineData;
import db.app.domain.AirportData;
import db.app.domain.FlightData;
import db.app.domain.PassengerData;

public class DummyDb {

	public List<AirlineData> airlines = new ArrayList<AirlineData>();
	public List<AirportData> airports = new ArrayList<AirportData>();
	public List<FlightData> flights = new ArrayList<FlightData>();
	public List<PassengerData> passengers = new ArrayList<PassengerData>();
}

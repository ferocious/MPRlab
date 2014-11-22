package db.app.repositories.impl;

import java.util.List;

import db.app.domain.PassengerData;
import db.app.repositories.IPassengerDataRepository;

public class DummyPassengerDataRepository implements IPassengerDataRepository {

	private DummyDb db;
	
	public DummyPassengerDataRepository(DummyDb db) {
		this.db = db;
	}

	@Override
	public void save(PassengerData entity) {
		db.passengers.add(entity);
	}

	@Override
	public void update(PassengerData entity) {
		PassengerData passenger = get(entity.getId());
		
		if (passenger != null) {
			passenger.setIdType(entity.getIdType());
//			passenger.setLuggageInfo(entity.getLuggageInfo());
//			passenger.setName(entity.getName());
//			passenger.setPriority(entity.getPriority());
//			passenger.setReservationNo(entity.getReservationNo());
		}
	}

	@Override
	public void delete(PassengerData entity) {
		db.passengers.remove(entity);
	}

	@Override
	public PassengerData get(int id) {
		for (PassengerData passenger : db.passengers) {
			if (passenger.getId() == id) {
				return passenger;
			}
		}
		
		return null;
	}

	@Override
	public List<PassengerData> getAll() {
		return db.passengers;
	}

	@Override
	public PassengerData withIdNo(String reservationNo) {
//		for (PassengerData passenger : db.passengers) {
//			if (passenger.getReservationNo().equals(reservationNo)) {
//				return passenger;
//			}
//		}
		
		return null;
	}

}

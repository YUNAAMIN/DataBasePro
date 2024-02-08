package application;

import java.time.LocalDate;

public class CarDistribution {

	private Integer CarNumber;	
	private String Location;
	private String CarParkingLocation;	
	private String FleetOfficer;
	private Integer OdometerOnDropOff;
	private LocalDate EntryDate;
	
	public CarDistribution(Integer carNumber, String location, String carParkingLocation, String fleetOfficer,Integer odometerOnDropOff, LocalDate entryDate) {
		CarNumber = carNumber;
		Location = location;
		CarParkingLocation = carParkingLocation;
		FleetOfficer = fleetOfficer;
		OdometerOnDropOff = odometerOnDropOff;
		EntryDate = entryDate;
	}

	public Integer getCarNumber() {
		return CarNumber;
	}

	public void setCarNumber(Integer carNumber) {
		CarNumber = carNumber;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public String getCarParkingLocation() {
		return CarParkingLocation;
	}

	public void setCarParkingLocation(String carParkingLocation) {
		CarParkingLocation = carParkingLocation;
	}

	public String getFleetOfficer() {
		return FleetOfficer;
	}

	public void setFleetOfficer(String fleetOfficer) {
		FleetOfficer = fleetOfficer;
	}

	public Integer getOdometerOnDropOff() {
		return OdometerOnDropOff;
	}

	public void setOdometerOnDropOff(Integer odometerOnDropOff) {
		OdometerOnDropOff = odometerOnDropOff;
	}

	public LocalDate getEntryDate() {
		return EntryDate;
	}

	public void setEntryDate(LocalDate entryDate) {
		EntryDate = entryDate;
	}

}

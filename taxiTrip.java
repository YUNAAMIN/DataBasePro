package application;

import java.time.LocalDate;
import java.util.Date;

public class taxiTrip {
	private int TaxiTripNumber;
	private LocalDate TripDate;
	private String TaxiCompanyName;
	private String PickupLocation;
	private String FleetOfficerName;
	private String Destination;
	private String TripPrice;
	private String Notes;

//	`TaxiTripNumber`,
//	`TripDate`,
//	`TaxiCompanyName`,
//	`PickupLocation`,
//	`FleetOfficerName`,
//	`Destination`,
//	`TripPrice`,
//	`Notes`
	public taxiTrip(int TaxiTripNumber, LocalDate TripDate, String TaxiCompanyName, String PickupLocation,
			String FleetOfficerName, String Destination, String TripPrice, String Notes) {
		this.TaxiTripNumber = TaxiTripNumber;
		this.TripDate = TripDate;
		this.TaxiCompanyName = TaxiCompanyName;
		this.PickupLocation = PickupLocation;
		this.FleetOfficerName = FleetOfficerName;
		this.Destination = Destination;
		this.TripPrice = TripPrice;
		this.Notes = Notes;
	}
	// Getter and Setter methods for each field

	public int getTaxiTripNumber() {
		return TaxiTripNumber;
	}

	public void setTaxiTripNumber(int TaxiTripNumber) {
		this.TaxiTripNumber = TaxiTripNumber;
	}

	public LocalDate getTripDate() {
		return TripDate;
	}

	public void setTripDate(LocalDate TripDate) {
		this.TripDate = TripDate;
	}

	public String getTaxiCompanyName() {
		return TaxiCompanyName;
	}

	public void setTaxiCompanyName(String TaxiCompanyName) {
		this.TaxiCompanyName = TaxiCompanyName;
	}

	public String getPickupLocation() {
		return PickupLocation;
	}

	public void setPickupLocation(String PickupLocation) {
		this.PickupLocation = PickupLocation;
	}

	public String getFleetOfficerName() {
		return FleetOfficerName;
	}

	public void setFleetOfficerName(String FleetOfficerName) {
		this.FleetOfficerName = FleetOfficerName;
	}

	public String getDestination() {
		return Destination;
	}

	public void setDestination(String Destination) {
		this.Destination = Destination;
	}

	public String getTripPrice() {
		return TripPrice;
	}

	public void setTripPrice(String TripPrice) {
		this.TripPrice = TripPrice;
	}

	public String getNotes() {
		return Notes;
	}

	public void setNotes(String Notes) {
		this.Notes = Notes;
	}

	@Override
	public String toString() {
		return "taxiTrip [TaxiTripNumber=" + TaxiTripNumber + ", TripDate=" + TripDate + ", TaxiCompanyName="
				+ TaxiCompanyName + ", PickupLocation=" + PickupLocation + ", FleetOfficerName=" + FleetOfficerName
				+ ", Destination=" + Destination + ", TripPrice=" + TripPrice + ", Notes=" + Notes + "]";
	}

}

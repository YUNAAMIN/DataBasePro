package application;

import java.time.LocalDate;
import java.util.Date;

public class carTrip {
	private int CarTripNumber;
	private String DriverName;
	private String OdometerOnStart;
	private String CarNumber;
	private LocalDate StartTripDate;
	private LocalDate EndTripDate;
	private String FleetOfficerName;
	private String Distance;
	private String Notes;

//CarTripNumber, DriverName, OdometerOnStart, CarNumber, OdometerOnDropOff, StartTripDate, EndTripDate, FleetOfficerName, Distance, Notes
	public carTrip(int CarTripNumber, String DriverName, String OdometerOnStart, String CarNumber,
			LocalDate StartTripDate, LocalDate EndTripDate, String FleetOfficerName, String Distance, String Notes) {
		this.CarTripNumber = CarTripNumber;
		this.DriverName = DriverName;
		this.OdometerOnStart = OdometerOnStart;
		this.CarNumber = CarNumber;
		this.StartTripDate = StartTripDate;
		this.EndTripDate = EndTripDate;
		this.FleetOfficerName = FleetOfficerName;
		this.Distance = Distance;
		this.Notes = Notes;
	}
	// Getter and Setter methods for each field

	public int getCarTripNumber() {
		return CarTripNumber;
	}

	public void setCarTripNumber(int CarTripNumber) {
		this.CarTripNumber = CarTripNumber;
	}

	public String getDriverName() {
		return DriverName;
	}

	public void setDriverName(String DriverName) {
		this.DriverName = DriverName;
	}

	public String getOdometerOnStart() {
		return OdometerOnStart;
	}

	public void setOdometerOnStart(String OdometerOnStart) {
		this.OdometerOnStart = OdometerOnStart;
	}

	public String getCarNumber() {
		return CarNumber;
	}

	public void setCarNumber(String CarNumber) {
		this.CarNumber = CarNumber;
	}

	public LocalDate getStartTripDate() {
		return StartTripDate;
	}

	public void setStartTripDate(LocalDate StartTripDate) {
		this.StartTripDate = StartTripDate;
	}

	public LocalDate getEndTripDate() {
		return EndTripDate;
	}

	public void setEndTripDate(LocalDate EndTripDate) {
		this.EndTripDate = EndTripDate;
	}

	public String getFleetOfficerName() {
		return FleetOfficerName;
	}

	public void setFleetOfficerName(String FleetOfficerName) {
		this.FleetOfficerName = FleetOfficerName;
	}

	public String getDistance() {
		return Distance;
	}

	public void setDistance(String Distance) {
		this.Distance = Distance;
	}

	public String getNotes() {
		return Notes;
	}

	public void setNotes(String Notes) {
		this.Notes = Notes;
	}

	@Override
	public String toString() {
		return "carTrip [CarTripNumber=" + CarTripNumber + ", DriverName=" + DriverName + ", OdometerOnStart="
				+ OdometerOnStart + ", CarNumber=" + CarNumber + ", StartTripDate=" + StartTripDate + ", EndTripDate="
				+ EndTripDate + ", FleetOfficerName=" + FleetOfficerName + ", Distance=" + Distance + ", Notes=" + Notes
				+ "]";
	}

	

}

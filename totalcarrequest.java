package application;


import java.time.LocalDate;
import java.util.Date;

public class totalcarrequest {
	private int RequestNumber;
	private String DriverName;
	private String DepartmentName;
	private String DepartureLocation;
	private String DestinationLocation;
	private String RequestStatus;
	private LocalDate RequestDate;
	private String VehicleType;
	private String FleetOfficerName;

//	 RequestNumber,
//	    DriverName,
//	    DepartmentName,
//	    DepartureLocation,
//	    DestinationLocation,
//	    RequestStatus,
//	    RequestRequestDate,
//	    VehicleType,
//	    FleetOfficerName
	public totalcarrequest(int RequestNumber, String DriverName, String DepartmentName, String DepartureLocation,
			String DestinationLocation, String RequestStatus, LocalDate RequestDate, String VehicleType,
			String FleetOfficerName) {
		this.RequestNumber = RequestNumber;
		this.DriverName = DriverName;
		this.DepartmentName = DepartmentName;
		this.DepartureLocation = DepartureLocation;
		this.DestinationLocation = DestinationLocation;
		this.RequestStatus = RequestStatus;
		this.RequestDate = RequestDate;
		this.VehicleType = VehicleType;
		this.FleetOfficerName = FleetOfficerName;
	}
	// Getter and Setter methods for each field

	public int getRequestNumber() {
		return RequestNumber;
	}

	public void setRequestNumber(int RequestNumber) {
		this.RequestNumber = RequestNumber;
	}

	public String getDriverName() {
		return DriverName;
	}

	public void setDriverName(String DriverName) {
		this.DriverName = DriverName;
	}

	public String getDepartmentName() {
		return DepartmentName;
	}

	public void setDepartmentName(String DepartmentName) {
		this.DepartmentName = DepartmentName;
	}

	public String getDepartureLocation() {
		return DepartureLocation;
	}

	public void setDepartureLocation(String DepartureLocation) {
		this.DepartureLocation = DepartureLocation;
	}

	public String getDestinationLocation() {
		return DestinationLocation;
	}

	public void setDestinationLocation(String DestinationLocation) {
		this.DestinationLocation = DestinationLocation;
	}

	public String getRequestStatus() {
		return RequestStatus;
	}

	public void setRequestStatus(String RequestStatus) {
		this.RequestStatus = RequestStatus;
	}

	public LocalDate getRequestDate() {
		return RequestDate;
	}

	public void setRequestDate(LocalDate RequestDate) {
		this.RequestDate = RequestDate;
	}

	public String getVehicleType() {
		return VehicleType;
	}

	public void setVehicleType(String VehicleType) {
		this.VehicleType = VehicleType;
	}

	public String getFleetOfficerName() {
		return FleetOfficerName;
	}

	public void setFleetOfficerName(String FleetOfficerName) {
		this.FleetOfficerName = FleetOfficerName;
	}

	@Override
	public String toString() {
		return "totalcarrequest [RequestNumber=" + RequestNumber + ", DriverName=" + DriverName + ", DepartmentName="
				+ DepartmentName + ", DepartureLocation=" + DepartureLocation + ", DestinationLocation="
				+ DestinationLocation + ", RequestStatus=" + RequestStatus + ", RequestDate=" + RequestDate
				+ ", VehicleType=" + VehicleType + ", FleetOfficerName=" + FleetOfficerName + "]";
	}

}

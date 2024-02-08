package application;

import java.time.LocalDate;
import java.util.Date;

public class fleetofficer {
	private int EmployeeID;
	private String FleetOfficersName;
	private String PhoneNumber;
	private String Email;
	private String DepartmentName;
	private String WorkLocation;

//EmployeeID, FleetOfficersName, PhoneNumber, Email, DepartmentName, WorkLocation
	public fleetofficer(int EmployeeID, String Name, String PhoneNumber, String Email, String DepartmentName,
			String WorkLocation) {
		this.EmployeeID = EmployeeID;
		this.FleetOfficersName = Name;
		this.PhoneNumber = PhoneNumber;
		this.Email = Email;
		this.DepartmentName = DepartmentName;
		this.WorkLocation = WorkLocation;
	}

	public int getEmployeeID() {
		return EmployeeID;
	}

	public void setEmployeeID(int EmployeeID) {
		this.EmployeeID = EmployeeID;
	}

	public String getFleetOfficersName() {
		return FleetOfficersName;
	}

	public void setFleetOfficersName(String Name) {
		this.FleetOfficersName = Name;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String PhoneNumber) {
		this.PhoneNumber = PhoneNumber;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}

	public String getDepartmentName() {
		return DepartmentName;
	}

	public void setDepartmentName(String DepartmentName) {
		this.DepartmentName = DepartmentName;
	}

	public String getWorkLocation() {
		return WorkLocation;
	}

	public void setWorkLocation(String WorkLocation) {
		this.WorkLocation = WorkLocation;
	}

	@Override
	public String toString() {
		return "fleetOfficer{" + "EmployeeID=" + EmployeeID + ", Name='" + FleetOfficersName + '\'' + ", PhoneNumber='"
				+ PhoneNumber + '\'' + ", Email='" + Email + '\'' + ", DepartmentName='" + DepartmentName + '\''
				+ ", WorkLocation='" + WorkLocation + '\'' + '}';
	}

}

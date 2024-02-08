package application;

import java.time.LocalDate;
import java.util.Date;

public class drivers {
	private int EmployeeNumber;
	private String EmployeeName;
	private String PhoneNumber;
	private String IdentificationCardNumber;
	private LocalDate LicenceStartDate;
	private LocalDate LicenceExpirationDate;
	private String Email;
	private String DepartmentName;
	private String DirectorateName;
	private String ContractType;
	private String WorkLocation;
	private String LivingLocation;
	private LocalDate EntryDate;

//	EmployeeNumber INT PRIMARY KEY,
//    EmployeeName VARCHAR(100) UNIQUE,
//    PhoneNumber VARCHAR(10),
//    IdentificationCardNumber VARCHAR(20),
//    LicenceStartDate DATE,
//    LicenceExpirationDate DATE,
//    Email VARCHAR(255),
//    DepartmentName VARCHAR(100),
//    DirectorateName VARCHAR(100),
//    ContractType VARCHAR(50),
//    WorkLocation VARCHAR(255),
//    LivingLocation VARCHAR(255),
//    EntryDate DATE  ,
	public drivers(int employeeNumber, String EmployeeName, String PhoneNumber, String IdentificationCardNumber,
			LocalDate LicenceStartDate, LocalDate LicenceExpirationDate, String Email, String DepartmentName,
			String DirectorateName, String ContractType, String WorkLocation, String LivingLocation,
			LocalDate EntryDate) {
		this.EmployeeNumber = employeeNumber;
		this.EmployeeName = EmployeeName;
		this.PhoneNumber = PhoneNumber;
		this.IdentificationCardNumber = IdentificationCardNumber;
		this.LicenceStartDate = LicenceStartDate;
		this.LicenceExpirationDate = LicenceExpirationDate;
		this.Email = Email;
		this.DepartmentName = DepartmentName;
		this.DirectorateName = DirectorateName;
		this.ContractType = ContractType;
		this.WorkLocation = WorkLocation;
		this.LivingLocation = LivingLocation;
		this.EntryDate = EntryDate;
	}

	// Getter and Setter methods for each field

	public int getEmployeeNumber() {
		return EmployeeNumber;
	}

	public void setEmployeeNumber(int employeeNumber) {
		this.EmployeeNumber = employeeNumber;
	}

	public String getEmployeeName() {
		return EmployeeName;
	}

	public void setEmployeeName(String EmployeeName) {
		this.EmployeeName = EmployeeName;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String PhoneNumber) {
		this.PhoneNumber = PhoneNumber;
	}

	public String getIdentificationCardNumber() {
		return IdentificationCardNumber;
	}

	public void setIdentificationCardNumber(String IdentificationCardNumber) {
		this.IdentificationCardNumber = IdentificationCardNumber;
	}

	public LocalDate getLicenceStartDate() {
		return LicenceStartDate;
	}

	public void setLicenceStartDate(LocalDate LicenceStartDate) {
		this.LicenceStartDate = LicenceStartDate;
	}

	public LocalDate getLicenceExpirationDate() {
		return LicenceExpirationDate;
	}

	public void setLicenceExpirationDate(LocalDate LicenceExpirationDate) {
		this.LicenceExpirationDate = LicenceExpirationDate;
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

	public String getDirectorateName() {
		return DirectorateName;
	}

	public void setDirectorateName(String DirectorateName) {
		this.DirectorateName = DirectorateName;
	}

	public String getContractType() {
		return ContractType;
	}

	public void setContractType(String ContractType) {
		this.ContractType = ContractType;
	}

	public String getWorkLocation() {
		return WorkLocation;
	}

	public void setWorkLocation(String WorkLocation) {
		this.WorkLocation = WorkLocation;
	}

	public String getLivingLocation() {
		return LivingLocation;
	}

	public void setLivingLocation(String LivingLocation) {
		this.LivingLocation = LivingLocation;
	}

	public LocalDate getEntryDate() {
		return EntryDate;
	}

	public void setEntryDate(LocalDate EntryDate) {
		this.EntryDate = EntryDate;
	}

	@Override
	public String toString() {
		return "Driver [employeeNumber=" + EmployeeNumber + ", EmployeeName=" + EmployeeName + ", PhoneNumber="
				+ PhoneNumber + ", IdentificationCardNumber=" + IdentificationCardNumber + ", LicenceStartDate="
				+ LicenceStartDate + ", LicenceExpirationDate=" + LicenceExpirationDate + ", Email=" + Email
				+ ", DepartmentName=" + DepartmentName + ", DirectorateName=" + DirectorateName + ", ContractType="
				+ ContractType + ", WorkLocation=" + WorkLocation + ", LivingLocation=" + LivingLocation
				+ ", EntryDate=" + EntryDate + "]";
	}
}

package application;

import java.time.LocalDate;

public class CarWashCompany {
	private Integer CompanyNumber;
	private String CompanyName;
	private String ContactPerson;
	private String PhoneNumber;
	private String Email ;
	private String Location;
	private LocalDate EntryDate;
	
	public CarWashCompany(Integer companyNumber, String companyName, String contactPerson, String phoneNumber,
			String email, String location, LocalDate entryDate) {
		super();
		CompanyNumber = companyNumber;
		CompanyName = companyName;
		ContactPerson = contactPerson;
		PhoneNumber = phoneNumber;
		Email = email;
		Location = location;
		EntryDate = entryDate;
	}
	public Integer getCompanyNumber() {
		return CompanyNumber;
	}
	public void setCompanyNumber(Integer companyNumber) {
		CompanyNumber = companyNumber;
	}
	public String getCompanyName() {
		return CompanyName;
	}
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}
	public String getContactPerson() {
		return ContactPerson;
	}
	public void setContactPerson(String contactPerson) {
		ContactPerson = contactPerson;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public LocalDate getEntryDate() {
		return EntryDate;
	}
	public void setEntryDate(LocalDate entryDate) {
		EntryDate = entryDate;
	}

}

package application;
import java.time.LocalDate;

public class TaxiComapnies {
	private Integer companyNumber;
	private String CompanyName;
	private String Location;
	private String ContactPerson;
	private String Email;
	private String PhoneNumber ;
	private LocalDate EntryDate;
	
	
	
	public TaxiComapnies(Integer companyNumber, String companyName, String location, String contactPerson, String email,String phoneNumber, LocalDate entryDate) {
		this.companyNumber = companyNumber;
		CompanyName = companyName;
		Location = location;
		ContactPerson = contactPerson;
		Email = email;
		PhoneNumber = phoneNumber;
		EntryDate = entryDate;
	}
	public int getCompanyNumber() {
		return companyNumber;
	}
	public void setCompanyNumber(int companyNumber) {
		this.companyNumber = companyNumber;
	}
	public String getCompanyName() {
		return CompanyName;
	}
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public String getContactPerson() {
		return ContactPerson;
	}
	public void setContactPerson(String contactPerson) {
		ContactPerson = contactPerson;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public LocalDate getEntryDate() {
		return EntryDate;
	}
	public void setEntryDate(LocalDate entryDate) {
		EntryDate = entryDate;
	}

}

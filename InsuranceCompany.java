package application;
import java.time.LocalDate;

public class InsuranceCompany {
	private Integer CompanyNumber;
	private String CompanyName;
	private String Email;
	private String ContactPersonName;
	private String ContactPersonPhoneNumber ;
	private String Location;
	private LocalDate EntryDate;
	
	public InsuranceCompany(Integer companyNumber, String companyName, String email, String contactPersonName,
			String contactPersonPhoneNumber, String location, LocalDate entryDate) {
		super();
		CompanyNumber = companyNumber;
		CompanyName = companyName;
		Email = email;
		ContactPersonName = contactPersonName;
		ContactPersonPhoneNumber = contactPersonPhoneNumber;
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
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getContactPersonName() {
		return ContactPersonName;
	}
	public void setContactPersonName(String contactPersonName) {
		ContactPersonName = contactPersonName;
	}
	public String getContactPersonPhoneNumber() {
		return ContactPersonPhoneNumber;
	}
	public void setContactPersonPhoneNumber(String contactPersonPhoneNumber) {
		ContactPersonPhoneNumber = contactPersonPhoneNumber;
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

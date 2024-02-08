package application;


import java.time.LocalDate;
import java.util.Date;

public class carrentalcompany {
	private int CompanyNumber;
	private String CompanyName;
	private String CompanyEmail;
	private String ContactPersonName;
	private String PhoneNumber;
	private String CompanyLocation;
	private LocalDate EntryDate;
	private String Notes;

//CompanyNumber, CompanyName, CompanyEmail, ContactPersonName, PhoneNumber, CompanyCompanyLocation, EntryDate, Notes
	public carrentalcompany(int CompanyNumber, String CompanyName, String CompanyEmail, String ContactPersonName,
			String PhoneNumber, String CompanyLocation, LocalDate EntryDate, String Notes) {
		this.CompanyNumber = CompanyNumber;
		this.CompanyName = CompanyName;
		this.CompanyEmail = CompanyEmail;
		this.ContactPersonName = ContactPersonName;
		this.CompanyLocation = CompanyLocation;
		this.EntryDate = EntryDate;
		this.Notes = Notes;
		this.PhoneNumber = PhoneNumber;
	}

	public int getCompanyNumber() {
		return CompanyNumber;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public void setCompanyNumber(int CompanyNumber) {
		this.CompanyNumber = CompanyNumber;
	}

	public String getCompanyName() {
		return CompanyName;
	}

	public void setCompanyName(String CompanyName) {
		this.CompanyName = CompanyName;
	}

	public String getCompanyEmail() {
		return CompanyEmail;
	}

	public void setCompanyEmail(String CompanyEmail) {
		this.CompanyEmail = CompanyEmail;
	}

	public String getContactPersonName() {
		return ContactPersonName;
	}

	public void setContactPersonName(String ContactPersonName) {
		this.ContactPersonName = ContactPersonName;
	}

	public String getCompanyLocation() {
		return CompanyLocation;
	}

	public void setCompanyLocation(String CompanyLocation) {
		this.CompanyLocation = CompanyLocation;
	}

	public LocalDate getEntryDate() {
		return EntryDate;
	}

	public void setEntryDate(LocalDate EntryDate) {
		this.EntryDate = EntryDate;
	}

	public String getNotes() {
		return Notes;
	}

	public void setNotes(String Notes) {
		this.Notes = Notes;
	}

	@Override
	public String toString() {
		return "carrentalcompany [CompanyNumber=" + CompanyNumber + ", CompanyName=" + CompanyName + ", CompanyEmail="
				+ CompanyEmail + ", ContactPersonName=" + ContactPersonName + ", CompanyLocation=" + CompanyLocation
				+ ", EntryDate=" + EntryDate + ", Notes=" + Notes + "]";
	}

}

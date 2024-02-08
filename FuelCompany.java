package application;

import java.time.LocalDate;

public class FuelCompany {
	
	private Integer companyNumber;	
	private String CompanyName;
	private String Email;
	private String ContactPersonName;	
	private String ContactPersonPhoneNumber ;
	private String Location;
	private String PayMethod;
	private LocalDate EntryDate;
	
	
	public FuelCompany(Integer companyNumber ,String CompanyName, String Email,String ContactPerson,String PhoneNumber,String Location,String PayMethod,LocalDate EntryDate) {
		this.companyNumber = companyNumber;
		this.CompanyName = CompanyName;
		this.Location = Location;
		this.ContactPersonName = ContactPerson;
		this.Email = Email;
		this.ContactPersonPhoneNumber = PhoneNumber;
		this.EntryDate = EntryDate;
		 this.PayMethod = PayMethod;
	}


	public Integer getCompanyNumber() {
		return companyNumber;
	}


	public void setCompanyNumber(Integer companyNumber) {
		this.companyNumber = companyNumber;
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


	public String getContactPerson() {
		return ContactPersonName;
	}


	public void setContactPerson(String contactPerson) {
		ContactPersonName = contactPerson;
	}


	public String getPhoneNumber() {
		return ContactPersonPhoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		ContactPersonPhoneNumber = phoneNumber;
	}


	public String getLocation() {
		return Location;
	}


	public void setLocation(String location) {
		Location = location;
	}


	public String getPayMethod() {
	    return PayMethod;
	}

	public void setPayMethod(String payMethod) {
	    PayMethod = payMethod;
	}

	public LocalDate getEntryDate() {
		return EntryDate;
	}


	public void setEntryDate(LocalDate entryDate) {
		EntryDate = entryDate;
	}
	
	
	

}

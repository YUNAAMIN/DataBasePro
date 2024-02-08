package application;

import java.time.LocalDate;
import java.util.Date;

public class department {
	private int DepartmentNumber;
	private String DirectorateName;
	private String DepartmentName;
	private String ManagerName;
	private String ManagerPhoneNumber;
	private String ManagerEmail;
	private LocalDate EntryDate;

	public department(int departmentNumber, String directorateName, String departmentName, String managerName,
			String managerPhoneNumber, String managerEmail, LocalDate EntryDate) {
		super();
		DepartmentNumber = departmentNumber;
		DirectorateName = directorateName;
		DepartmentName = departmentName;
		ManagerName = managerName;
		ManagerPhoneNumber = managerPhoneNumber;
		ManagerEmail = managerEmail;
		this.EntryDate = EntryDate;
	}

	public int getDepartmentNumber() {
		return DepartmentNumber;
	}

	public void setDepartmentNumber(int departmentNumber) {
		DepartmentNumber = departmentNumber;
	}

	public String getDirectorateName() {
		return DirectorateName;
	}

	public void setDirectorateName(String directorateName) {
		DirectorateName = directorateName;
	}

	public String getDepartmentName() {
		return DepartmentName;
	}

	public void setDepartmentName(String departmentName) {
		DepartmentName = departmentName;
	}

	public String getManagerName() {
		return ManagerName;
	}

	public void setManagerName(String managerName) {
		ManagerName = managerName;
	}

	public String getManagerPhoneNumber() {
		return ManagerPhoneNumber;
	}

	public void setManagerPhoneNumber(String managerPhoneNumber) {
		ManagerPhoneNumber = managerPhoneNumber;
	}

	public String getManagerEmail() {
		return ManagerEmail;
	}

	public void setManagerEmail(String managerEmail) {
		ManagerEmail = managerEmail;
	}

	public LocalDate getEntryDate() {
		return EntryDate;
	}

	public void setEntryDate(LocalDate EntryDate) {
		this.EntryDate = EntryDate;
	}

}

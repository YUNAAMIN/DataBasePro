package application;

import java.time.LocalDate;
import java.util.Date;

public class maintenanceRecords {
	private int MaintenanceRecordNumber;
	private LocalDate MaintenanceDate;
	private String MaintenanceType;
	private int CarNumber;
	private String RecordStatus;
	private LocalDate CloseDate;

	// Constructor
	public maintenanceRecords(int maintenanceRecordNumber, LocalDate maintenanceDate, String maintenanceType,
			int carNumber, String RecordStatus, LocalDate closeDate) {
		this.MaintenanceRecordNumber = maintenanceRecordNumber;
		this.MaintenanceDate = maintenanceDate;
		this.MaintenanceType = maintenanceType;
		this.CarNumber = carNumber;
		this.RecordStatus = RecordStatus;
		this.CloseDate = closeDate;
	}

	public int getMaintenanceRecordNumber() {
		return MaintenanceRecordNumber;
	}

	public void setMaintenanceRecordNumber(int maintenanceRecordNumber) {
		MaintenanceRecordNumber = maintenanceRecordNumber;
	}

	public LocalDate getMaintenanceDate() {
		return MaintenanceDate;
	}

	public void setMaintenanceDate(LocalDate maintenanceDate) {
		MaintenanceDate = maintenanceDate;
	}

	public String getMaintenanceType() {
		return MaintenanceType;
	}

	public void setMaintenanceType(String maintenanceType) {
		MaintenanceType = maintenanceType;
	}

	public int getCarNumber() {
		return CarNumber;
	}

	public void setCarNumber(int carNumber) {
		CarNumber = carNumber;
	}

	public String getRecordStatus() {
		return RecordStatus;
	}

	public void setRecordStatus(String RecordStatus) {
		RecordStatus = RecordStatus;
	}

	public LocalDate getCloseDate() {
		return CloseDate;
	}

	public void setCloseDate(LocalDate closeDate) {
		CloseDate = closeDate;
	}

	@Override
	public String toString() {
		return "maintenanceRecords [MaintenanceRecordNumber=" + MaintenanceRecordNumber + ", MaintenanceDate="
				+ MaintenanceDate + ", MaintenanceType=" + MaintenanceType + ", CarNumber=" + CarNumber + ", RecordStatus="
				+ RecordStatus + ", CloseDate=" + CloseDate + "]";
	}

}

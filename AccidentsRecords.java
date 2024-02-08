package application;


import java.math.BigDecimal;
import java.time.LocalDate;

public class AccidentsRecords {
	private int AccidentRecordNumber;
	private LocalDate AccidentDate;
	private int CarNumber;
	private String DriverName;
	private String PoliceReport;
	private String NotifyInsurance;
	private String NotifyRentalCompany;
	private String Injuries;
	private String NeedForMaintenance;
	private String Notes;
	private int ReplacementCarNumber;
	private LocalDate StartDateForReplacement;

	public AccidentsRecords(int accidentRecordNumber, LocalDate accidentDate, int carNumber, String driverName,
			String policeReport, String notifyInsurance, String notifyRentalCompany, String injuries,
			String needForMaintenance, String notes, int replacementCarNumber, LocalDate startDateForReplacement) {
		this.AccidentRecordNumber = accidentRecordNumber;
		this.AccidentDate = accidentDate;
		this.CarNumber = carNumber;
		this.DriverName = driverName;
		this.PoliceReport = policeReport;
		this.NotifyInsurance = notifyInsurance;
		this.NotifyRentalCompany = notifyRentalCompany;
		this.Injuries = injuries;
		this.NeedForMaintenance = needForMaintenance;
		this.Notes = notes;
		this.ReplacementCarNumber = replacementCarNumber;
		this.StartDateForReplacement = startDateForReplacement;
	}

	public int getAccidentRecordNumber() {
		return AccidentRecordNumber;
	}

	public void setAccidentRecordNumber(int accidentRecordNumber) {
		AccidentRecordNumber = accidentRecordNumber;
	}

	public LocalDate getAccidentDate() {
		return AccidentDate;
	}

	public void setAccidentDate(LocalDate accidentDate) {
		AccidentDate = accidentDate;
	}

	public int getCarNumber() {
		return CarNumber;
	}

	public void setCarNumber(int carNumber) {
		CarNumber = carNumber;
	}

	public String getDriverName() {
		return DriverName;
	}

	public void setDriverName(String driverName) {
		DriverName = driverName;
	}

	public String getPoliceReport() {
		return PoliceReport;
	}

	public void setPoliceReport(String policeReport) {
		PoliceReport = policeReport;
	}

	public String getNotifyInsurance() {
		return NotifyInsurance;
	}

	public void setNotifyInsurance(String notifyInsurance) {
		NotifyInsurance = notifyInsurance;
	}

	public String getNotifyRentalCompany() {
		return NotifyRentalCompany;
	}

	public void setNotifyRentalCompany(String notifyRentalCompany) {
		NotifyRentalCompany = notifyRentalCompany;
	}

	public String getInjuries() {
		return Injuries;
	}

	public void setInjuries(String injuries) {
		Injuries = injuries;
	}

	public String getNeedForMaintenance() {
		return NeedForMaintenance;
	}

	public void setNeedForMaintenance(String needForMaintenance) {
		NeedForMaintenance = needForMaintenance;
	}

	public String getNotes() {
		return Notes;
	}

	public void setNotes(String notes) {
		Notes = notes;
	}

	public int getReplacementCarNumber() {
		return ReplacementCarNumber;
	}

	public void setReplacementCarNumber(int replacementCarNumber) {
		ReplacementCarNumber = replacementCarNumber;
	}

	public LocalDate getStartDateForReplacement() {
		return StartDateForReplacement;
	}

	public void setStartDateForReplacement(LocalDate startDateForReplacement) {
		StartDateForReplacement = startDateForReplacement;
	}

	@Override
	public String toString() {
		return "AccidentsRecords [AccidentRecordNumber=" + AccidentRecordNumber + ", AccidentDate=" + AccidentDate
				+ ", CarNumber=" + CarNumber + ", DriverName=" + DriverName + ", PoliceReport=" + PoliceReport
				+ ", NotifyInsurance=" + NotifyInsurance + ", NotifyRentalCompany=" + NotifyRentalCompany
				+ ", Injuries=" + Injuries + ", NeedForMaintenance=" + NeedForMaintenance + ", Notes=" + Notes
				+ ", ReplacementCarNumber=" + ReplacementCarNumber + ", StartDateForReplacement="
				+ StartDateForReplacement + "]";
	}

}

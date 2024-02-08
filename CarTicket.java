package application;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class CarTicket {
	private int TicketNumber;
	private String ViolationType;
	private LocalDate TicketDate;
	private BigDecimal TicketValue;
	private String DriverName;
	private String DepartmentName;
	private String MethodOfPaying;
	private String Note;
	private LocalDate EntryDate;

	public CarTicket(int ticketNumber, String violationType, LocalDate ticketDate, BigDecimal ticketValue,
			String driverName, String departmentName, String methodOfPaying, String note, LocalDate entryDate) {
		TicketNumber = ticketNumber;
		ViolationType = violationType;
		TicketDate = ticketDate;
		TicketValue = ticketValue;
		DriverName = driverName;
		DepartmentName = departmentName;
		MethodOfPaying = methodOfPaying;
		Note = note;
		EntryDate = entryDate;
	}

	public int getTicketNumber() {
		return TicketNumber;
	}

	public void setTicketNumber(int ticketNumber) {
		TicketNumber = ticketNumber;
	}

	public String getViolationType() {
		return ViolationType;
	}

	public void setViolationType(String violationType) {
		ViolationType = violationType;
	}

	public LocalDate getTicketDate() {
		return TicketDate;
	}

	public void setTicketDate(LocalDate ticketDate) {
		TicketDate = ticketDate;
	}

	public BigDecimal getTicketValue() {
		return TicketValue;
	}

	public void setTicketValue(BigDecimal ticketValue) {
		TicketValue = ticketValue;
	}

	public String getDriverName() {
		return DriverName;
	}

	public void setDriverName(String driverName) {
		DriverName = driverName;
	}

	public String getDepartmentName() {
		return DepartmentName;
	}

	public void setDepartmentName(String departmentName) {
		DepartmentName = departmentName;
	}

	public String getMethodOfPaying() {
		return MethodOfPaying;
	}

	public void setMethodOfPaying(String methodOfPaying) {
		MethodOfPaying = methodOfPaying;
	}

	public String getNote() {
		return Note;
	}

	public void setNote(String note) {
		Note = note;
	}

	public LocalDate getEntryDate() {
		return EntryDate;
	}

	public void setEntryDate(LocalDate entryDate) {
		EntryDate = entryDate;
	}

	@Override
	public String toString() {
		return "CarTicket [TicketNumber=" + TicketNumber + ", ViolationType=" + ViolationType + ", TicketDate="
				+ TicketDate + ", TicketValue=" + TicketValue + ", DriverName=" + DriverName + ", DepartmentName="
				+ DepartmentName + ", MethodOfPaying=" + MethodOfPaying + ", Note=" + Note + ", EntryDate=" + EntryDate
				+ "]";
	}

}

package application;
import java.time.LocalDate;

public class CarWashes {
	
	private Integer CouponNumber;	
	private Integer CarNumber;	
	private Double ValueFee;
	private String DriverName;
	private LocalDate EntryDate;
	private String WashCompanyName;
    
    public CarWashes(Integer couponNumber, Integer carNumber, Double valueFee, String driverName, LocalDate entryDate,
			String washCompanyName) {
		super();
		CouponNumber = couponNumber;
		CarNumber = carNumber;
		ValueFee = valueFee;
		DriverName = driverName;
		EntryDate = entryDate;
		WashCompanyName = washCompanyName;
	}
	public Integer getCouponNumber() {
		return CouponNumber;
	}
	public void setCouponNumber(Integer couponNumber) {
		CouponNumber = couponNumber;
	}
	public Integer getCarNumber() {
		return CarNumber;
	}
	public void setCarNumber(Integer carNumber) {
		CarNumber = carNumber;
	}
	public Double getValueFee() {
		return ValueFee;
	}
	public void setValueFee(Double valueFee) {
		ValueFee = valueFee;
	}
	public String getDriverName() {
		return DriverName;
	}
	public void setDriverName(String driverName) {
		DriverName = driverName;
	}
	public LocalDate getEntryDate() {
		return EntryDate;
	}
	public void setEntryDate(LocalDate entryDate) {
		EntryDate = entryDate;
	}
	public String getWashCompanyName() {
		return WashCompanyName;
	}
	public void setWashCompanyName(String washCompanyName) {
		WashCompanyName = washCompanyName;
	}

}

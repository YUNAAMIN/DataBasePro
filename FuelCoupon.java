package application;

import java.time.LocalDate;

public class FuelCoupon {
	private Integer CouponNumber;	
	private Integer CarNumber;	
	private String DriverName;
	private Integer OdometerOnStarting;
	private String DepartmentName;	
	private Double FuelAmount;
	private String FuelType;
	private Double FuelPrice;
	private String FuelCompanyName;
	private LocalDate EntryDate;

	public FuelCoupon(Integer couponNumber, Integer carNumber, String driverName, Integer odometerOnStarting,
			String departmentName, Double fuelAmount, String fuelType, Double fuelPrice, String fuelCompanyName,
			LocalDate entryDate) {
		super();
		CouponNumber = couponNumber;
		CarNumber = carNumber;
		DriverName = driverName;
		OdometerOnStarting = odometerOnStarting;
		DepartmentName = departmentName;
		FuelAmount = fuelAmount;
		FuelType = fuelType;
		FuelPrice = fuelPrice;
		FuelCompanyName = fuelCompanyName;
		EntryDate = entryDate;
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
	public String getDriverName() {
		return DriverName;
	}
	public void setDriverName(String driverName) {
		DriverName = driverName;
	}
	public Integer getOdometerOnStarting() {
		return OdometerOnStarting;
	}
	public void setOdometerOnStarting(Integer odometerOnStarting) {
		OdometerOnStarting = odometerOnStarting;
	}
	public String getDepartmentName() {
		return DepartmentName;
	}
	public void setDepartmentName(String departmentName) {
		DepartmentName = departmentName;
	}
	public Double getFuelAmount() {
		return FuelAmount;
	}
	public void setFuelAmount(Double fuelAmount) {
		FuelAmount = fuelAmount;
	}
	public String getFuelType() {
		return FuelType;
	}
	public void setFuelType(String fuelType) {
		FuelType = fuelType;
	}
	public Double getFuelPrice() {
		return FuelPrice;
	}
	public void setFuelPrice(Double fuelPrice) {
		FuelPrice = fuelPrice;
	}
	public String getFuelCompanyName() {
		return FuelCompanyName;
	}
	public void setFuelCompanyName(String fuelCompanyName) {
		FuelCompanyName = fuelCompanyName;
	}
	public LocalDate getEntryDate() {
		return EntryDate;
	}
	public void setEntryDate(LocalDate entryDate) {
		EntryDate = entryDate;
	}
	
}

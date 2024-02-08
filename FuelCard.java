package application;

import java.time.LocalDate;

public class FuelCard {   
	
	private Integer CardNumber;	
	private Integer CarNumber;	
	private String FuelType;
	private String DepartmentName;
	private String FuelCompany;	
	private Double FuelAmount;
	private Double FuelPriceMonthly;
	private String CarType;
	private LocalDate DATE;
	
    public FuelCard(Integer cardNumber, Integer carNumber, String fuelType, String departmentName, String fuelCompany,
			Double fuelAmount, Double fuelPriceMonthly, String carType, LocalDate dATE) {
		super();
		CardNumber = cardNumber;
		CarNumber = carNumber;
		FuelType = fuelType;
		DepartmentName = departmentName;
		FuelCompany = fuelCompany;
		FuelAmount = fuelAmount;
		FuelPriceMonthly = fuelPriceMonthly;
		CarType = carType;
		DATE = dATE;
	}
	public Integer getCardNumber() {
		return CardNumber;
	}
	public void setCardNumber(Integer cardNumber) {
		CardNumber = cardNumber;
	}
	public Integer getCarNumber() {
		return CarNumber;
	}
	public void setCarNumber(Integer carNumber) {
		CarNumber = carNumber;
	}
	public String getFuelType() {
		return FuelType;
	}
	public void setFuelType(String fuelType) {
		FuelType = fuelType;
	}
	public String getDepartmentName() {
		return DepartmentName;
	}
	public void setDepartmentName(String departmentName) {
		DepartmentName = departmentName;
	}
	public String getFuelCompany() {
		return FuelCompany;
	}
	public void setFuelCompany(String fuelCompany) {
		FuelCompany = fuelCompany;
	}
	public Double getFuelAmount() {
		return FuelAmount;
	}
	public void setFuelAmount(Double fuelAmount) {
		FuelAmount = fuelAmount;
	}
	public Double getFuelPriceMonthly() {
		return FuelPriceMonthly;
	}
	public void setFuelPriceMonthly(Double fuelPriceMonthly) {
		FuelPriceMonthly = fuelPriceMonthly;
	}
	public String getCarType() {
		return CarType;
	}
	public void setCarType(String carType) {
		CarType = carType;
	}
	public LocalDate getDATE() {
		return DATE;
	}
	public void setDATE(LocalDate dATE) {
		DATE = dATE;
	}
	

}

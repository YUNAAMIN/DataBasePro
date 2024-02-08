package application;
import java.math.BigDecimal;
import java.time.LocalDate;

public class car {
	private int carNumber;
    private String brandName;
    private String rentalCompanyName;
    private BigDecimal rentFee;
    private LocalDate contractStartDate;
    private LocalDate contractExpirationDate;
    private LocalDate licenceInsuranceEndDate;
    private int carMeter;
    private String carColor;
    private int motorPower;
    private String fuelType;
    private int fuelTankCapacity;
    private String contractType;
    private String notes;
    private String carStatus;
    
    
	public car(int carNumber, String brandName, String rentalCompanyName, BigDecimal rentFee,
			LocalDate contractStartDate, LocalDate contractExpirationDate, LocalDate licenceInsuranceEndDate,
			int carMeter, String carColor, int motorPower, String fuelType, int fuelTankCapacity, String contractType,
			String notes, String carStatus) {
		super();
		this.carNumber = carNumber;
		this.brandName = brandName;
		this.rentalCompanyName = rentalCompanyName;
		this.rentFee = rentFee;
		this.contractStartDate = contractStartDate;
		this.contractExpirationDate = contractExpirationDate;
		this.licenceInsuranceEndDate = licenceInsuranceEndDate;
		this.carMeter = carMeter;
		this.carColor = carColor;
		this.motorPower = motorPower;
		this.fuelType = fuelType;
		this.fuelTankCapacity = fuelTankCapacity;
		this.contractType = contractType;
		this.notes = notes;
		this.carStatus = carStatus;
	}

	
	


	

	public car(int l) {
		// TODO Auto-generated constructor stub
	}

	public int getCarNumber() {
		return carNumber;
	}


	public void setCarNumber(int carNumber) {
		this.carNumber = carNumber;
	}


	public String getBrandName() {
		return brandName;
	}


	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}


	public String getRentalCompanyName() {
		return rentalCompanyName;
	}


	public void setRentalCompanyName(String rentalCompanyName) {
		this.rentalCompanyName = rentalCompanyName;
	}


	public BigDecimal getRentFee() {
		return rentFee;
	}


	public void setRentFee(BigDecimal rentFee) {
		this.rentFee = rentFee;
	}


	public LocalDate getContractStartDate() {
		return contractStartDate;
	}


	public void setContractStartDate(LocalDate contractStartDate) {
		this.contractStartDate = contractStartDate;
	}


	public LocalDate getContractExpirationDate() {
		return contractExpirationDate;
	}


	public void setContractExpirationDate(LocalDate contractExpirationDate) {
		this.contractExpirationDate = contractExpirationDate;
	}


	public LocalDate getLicenceInsuranceEndDate() {
		return licenceInsuranceEndDate;
	}


	public void setLicenceInsuranceEndDate(LocalDate licenceInsuranceEndDate) {
		this.licenceInsuranceEndDate = licenceInsuranceEndDate;
	}


	public int getCarMeter() {
		return carMeter;
	}


	public void setCarMeter(int carMeter) {
		this.carMeter = carMeter;
	}


	public String getCarColor() {
		return carColor;
	}


	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}


	public int getMotorPower() {
		return motorPower;
	}


	public void setMotorPower(int motorPower) {
		this.motorPower = motorPower;
	}


	public String getFuelType() {
		return fuelType;
	}


	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}


	public int getFuelTankCapacity() {
		return fuelTankCapacity;
	}


	public void setFuelTankCapacity(int fuelTankCapacity) {
		this.fuelTankCapacity = fuelTankCapacity;
	}


	public String getContractType() {
		return contractType;
	}


	public void setContractType(String contractType) {
		this.contractType = contractType;
	}


	public String getNotes() {
		return notes;
	}


	public void setNotes(String notes) {
		this.notes = notes;
	}


	public String getCarStatus() {
		return carStatus;
	}


	public void setCarStatus(String carStatus) {
		this.carStatus = carStatus;
	}
	
	

    

}

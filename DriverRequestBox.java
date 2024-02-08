package application;

public class DriverRequestBox {
	String name;
	String deprtment;
	String departurelocation;
	String destination;
	String dropoff;
	String companyloaction;
	String typeoftrnasport;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDeprtment() {
		return deprtment;
	}
	public void setDeprtment(String deprtment) {
		this.deprtment = deprtment;
	}
	public String getDeparturelocation() {
		return departurelocation;
	}
	public void setDeparturelocation(String departurelocation) {
		this.departurelocation = departurelocation;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDropoff() {
		return dropoff;
	}
	public void setDropoff(String dropoff) {
		this.dropoff = dropoff;
	}
	public String getCompanyloaction() {
		return companyloaction;
	}
	public void setCompanyloaction(String companyloaction) {
		this.companyloaction = companyloaction;
	}
	public String getTypeoftrnasport() {
		return typeoftrnasport;
	}
	public void setTypeoftrnasport(String typeoftrnasport) {
		this.typeoftrnasport = typeoftrnasport;
	}
	public DriverRequestBox(String name, String deprtment, String departurelocation, String destination, String dropoff,
			String companyloaction, String typeoftrnasport) {
		super();
		this.name = name;
		this.deprtment = deprtment;
		this.departurelocation = departurelocation;
		this.destination = destination;
		this.dropoff = dropoff;
		this.companyloaction = companyloaction;
		this.typeoftrnasport = typeoftrnasport;
	}
	@Override
	public String toString() {
		return "DriverRequestBox [name=" + name + ", deprtment=" + deprtment + ", departurelocation="
				+ departurelocation + ", destination=" + destination + ", dropoff=" + dropoff + ", companyloaction="
				+ companyloaction + ", typeoftrnasport=" + typeoftrnasport + "]";
	}
	
	
	
	
}

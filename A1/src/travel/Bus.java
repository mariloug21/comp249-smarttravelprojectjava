package travel;

public class Bus extends Transportation {
	
// Attributes
	private String busCompany;
	private int numberOfStops;
	
// Default Constructor
	public Bus() {
		super();
		this.busCompany = "";
		this.numberOfStops = 0;
	}

// Parameterized Constructor
	public Bus(String companyName, String departureCity, String arrivalCity, String busCompany, int numberOfStops) {
		super(companyName, departureCity, arrivalCity);
		this.busCompany = busCompany;
		this.numberOfStops = numberOfStops;
	}
	
// Copy Constructor
	public Bus(Bus other) {
		super(other);
		this.busCompany = other.busCompany;
		this.numberOfStops = other.numberOfStops;
	}

// Accessors and mutators methods
	public String getbusCompany() {
		return busCompany;
	}
	public void setTrainType(String busCompany) {
		this.busCompany = busCompany;
	}
	
	public int getNumberOfStops() {
		return numberOfStops;
	}
	public void setNumberOfStops(int numberOfStops) {
		this.numberOfStops = numberOfStops;
	}
	

// toString() method
	@Override
	public String toString() {
		return "Bus: " + super.toString() + 
				", Bus Company: " + busCompany +
				"Number of Stops: " + numberOfStops;
	}
	
// equals() method
	@Override
	public boolean equals(Object bss) {
		if(!super.equals(bss)) return false;
		Bus other = (Bus) bss;
		return busCompany.equals(other.busCompany)
				&& numberOfStops == other.numberOfStops;
	}
	
// calculateCost() method (Condition?) (Polymorphic)
	public double calculateCost(int numberOfDays) {
		return 25.0 + (numberOfStops * 5.0);		
		}

}

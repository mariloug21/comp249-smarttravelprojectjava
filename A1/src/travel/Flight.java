package travel;
//Assignment 1
//Written by: Jamal Shaheen 40327844

public class Flight extends Transportation {
	
// Attributes
	private String airlineName;
	private double allowedKgLuggage;
	
// Default Constructor
	public Flight() {
		//super(): calls the constructor of the parent class
		super();
		this.airlineName = "";
		this.allowedKgLuggage = 0.0;
	}
	
// Parameterized Constructor
	public Flight(String companyName, String departureCity, String arrivalCity, String airlineName, double allowedKgLuggage) {
		super(companyName, departureCity, arrivalCity);
		this.airlineName = airlineName;
		this.allowedKgLuggage = allowedKgLuggage;
	}
	
// Copy Constructor
	public Flight(Flight other) {
		super(other);
		this.airlineName = other.airlineName;
		this.allowedKgLuggage = other.allowedKgLuggage;
	}
	
// Accessor and mutator methods
	public String getAirlineName() {
		return airlineName;
	}
	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	
	public double getAllowedKgLuggage() {
		return allowedKgLuggage;
	}
	public void setAllowedKgLuggage(double allowedKgLuggage) {
		this.allowedKgLuggage = allowedKgLuggage;
	}
	
// toString() method
	public String toString() {
		return "Flight: " + super.toString() +
				", airline name: " + airlineName + 
				", allowed kg for luggage: " + allowedKgLuggage;
	}
	
// equals() method
	@Override
	public boolean equals(Object fli) {
		if(!super.equals(fli)) return false;
		Flight other = (Flight) fli;
		return airlineName.equals(other.airlineName) 
				&& allowedKgLuggage == other.allowedKgLuggage;
	}

// calculateCost() method (Condition?) (Polymorphic)
	public double calculateCost(int numberOfDays) {
		return 250.0 + (allowedKgLuggage);
		}
		

}

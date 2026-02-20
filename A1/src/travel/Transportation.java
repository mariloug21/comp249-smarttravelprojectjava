package travel;
//Assignment 1
//Written by: Jamal Shaheen 40327844

public abstract class Transportation {

//Attributes
	//Static counter for the transportation ID
	private static int nextID = 3001;
	
	//ID for transportation object that's not changed after the creation
	private final String tpID;

	//Protected because subclasses can access directly if needed
	protected String companyName;
	protected String departureCity;
	protected String arrivalCity;
	
// Default Constructor (generate new ID and initializes default values)
	public Transportation() {
		this.tpID = "TR" + nextID++;
		this.companyName = "";
		this.departureCity = "";
		this.arrivalCity = "";
	}
	
// Parameterized Constructor
	public Transportation(String companyName, String departureCity, String arrivalCity) {
		this.tpID = "TR" + nextID++;
		this.companyName = companyName;
		this.departureCity = departureCity;
		this.arrivalCity = arrivalCity;
	}
	
// Copy Constructor
	protected Transportation(Transportation other) {
		this.tpID = "TR" + nextID++;
		this.companyName = other.companyName;
		this.departureCity = other.departureCity;
		this.arrivalCity = other.arrivalCity;
	}
	
// Accessor and mutator methods
	public String gettpID() {
		return tpID;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public String getDepartureCity() {
		return departureCity;
	}
	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}
	
	public String getArrivalCity() {
		return arrivalCity;
	}
	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}
	
// toString() method
	@Override
	public String toString() {
		return "Transportation: " +
	"Transportation ID: " + tpID + 
	"company name: " + companyName +
	"departure city: " + departureCity +
	"arrival city: " + arrivalCity;
	
	}
	
// equals() method
	@Override
	public boolean equals(Object trp) {
		if (trp == null) return false;
		if(this.getClass() != trp.getClass()) return false;
		
		Transportation other = (Transportation) trp;
		return companyName.equals(other.companyName)
				&& departureCity.equals(other.departureCity)
				&& arrivalCity.equals(other.arrivalCity);
	}
	
// calculatecost() method
	protected abstract double calculateCost(int durationInDays);

}

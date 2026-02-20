package travel; 

public class Hostel extends Accommodation {

// Attributes
	private int numberOfBeds;
	
// Default Constructor
	public Hostel() {
		super();
		this.numberOfBeds = 0;	
	}

// Parameterized Constructor	
	public Hostel(String accommodationName, String location, double pricePerNight, int numberOfBeds) {
		super(accommodationName, location, pricePerNight);
		this.numberOfBeds = numberOfBeds;
		
	}

// Copy Construction	
	public Hostel(Hostel other) {
		super(other);
		this.numberOfBeds = other.numberOfBeds;
		
	}

// Setters and Getters
	public int getNumberOfBeds() {
		return numberOfBeds;
	}
	
	public void setNumberOfBeds(int numberOfBeds) {
		this.numberOfBeds = numberOfBeds;
	}

// toString() method
	@Override
	public String toString() {
		return super.toString() + "\nNumber of beds: " + numberOfBeds;
	}

// equals() method
	@Override
	public boolean equals(Object obj) {
	    if (!super.equals(obj))
	        return false;   // If parent attributes or class mismatch fails, returns false

	    Hostel other = (Hostel) obj; // Casting

	    //Compare child Hostel attribute
	    return this.numberOfBeds == other.numberOfBeds;
	}
	
// calculateCost() method (discount of 15%) (Polymorphic)
	public double calculateCost(int numberOfDays) {
		return super.calculateCost(numberOfDays) *0.85;
		}

}

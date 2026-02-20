package travel;

public class Hotel extends Accommodation {

// Attribute
	private int starRating;
	
// Default Constructor
	public Hotel() {
		super();
		this.starRating = 0;
	}

// Parameterized Constructor
	public Hotel(String accommodationName, String location, double pricePerNight, int starRating) {
		super(accommodationName, location, pricePerNight);
		this.starRating = starRating;
		
	}

// Copy Construction
	public Hotel(Hotel other) {
		super(other);
		this.starRating = other.starRating;
	}

// Getters and Setters
	public int getStarRating() {
		return starRating;
	}
	public void setStarRating(int starRating) {
		this.starRating = starRating;
	}
	
// toString() method
	@Override
	public String toString() {
		return super.toString() + "\nStar Rating: " + starRating;
	}
	
// equals() method
	 @Override
	    public boolean equals(Object obj) {
	        if (!super.equals(obj))
	            return false;

	        Hotel other = (Hotel) obj; // Casting

	      //Compare child Hotel attribute
	        return this.starRating == other.starRating;
	    }
// calculateCost() method (service fee of 10%) (Polymorphic)
	@Override
	public double calculateCost(int numberOfDays) {
		return super.calculateCost(numberOfDays) *1.1;
	}

}

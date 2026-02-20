package travel;
// Assignment 1
// Written by: Marilou Grenier (40210227)
public abstract class Accommodation {
	
// Attributes
	private String accommodationID;
	private String accommodationName;
	private String location;
	private double pricePerNight;
	private static int nextIdAccommodation = 1001; //Shared by all objects, must create a unique ID number

// Default Constructor
	public Accommodation() {
		this.accommodationID = "A" + nextIdAccommodation++; // Increment
		this.accommodationName= "";
		this.location="";
		this.pricePerNight = 0;
		}
	
// Parameterized Constructor
	public Accommodation(String accommodationName, String location, double pricePerNight) {
		this.accommodationID = "A" + nextIdAccommodation++;
		this.accommodationName = accommodationName;
		this.location= location ;
		this.pricePerNight = pricePerNight;	
		}

// Copy Constructor (**new ID generated)
	public Accommodation(Accommodation other) {
		this.accommodationID = "A" + nextIdAccommodation++;
		this.accommodationName = other.accommodationName;
		this.location = other.location;
		this.pricePerNight = other.pricePerNight;
		}

// Setters and Getters
	public String getAccommodationID() {
		return accommodationID;
	}

	public void setAccommodationID(String accommodationID) {
		this.accommodationID = accommodationID;
	}

	public String getAccommodationName() {
		return accommodationName;
	}

	public void setAccommodationName(String accommodationName) {
		this.accommodationName = accommodationName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getPricePerNight() {
		return pricePerNight;
	}

	public void setPricePerNight(int pricePerNight) {
		this.pricePerNight = pricePerNight;
	}

// toString() method
	@Override
	public String toString() {
		return "Accommodation ID: " + accommodationID + "\nAccommodation Name: " + accommodationName  + "\nLocation: " + location + "\nPrice per night: " + pricePerNight; 
	}

// equals() method (disregard ID)
	public boolean equals(Object obj) {
		if (obj == null || this.getClass() != obj.getClass())
			return false; //Return false is the object is empty or from another class
		Accommodation other = (Accommodation) obj; //Casting
		
		// Compare parent attributes
		return accommodationName.equals(other.accommodationName) && location.equals(other.location)&& pricePerNight == other.pricePerNight; 
		}

// calculateCost() method
	public double calculateCost(int durationInDays) {
		return pricePerNight * durationInDays;
	} 
		
}

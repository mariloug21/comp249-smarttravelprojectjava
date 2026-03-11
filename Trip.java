package travel;
import exceptions.InvalidTripDataException; //A2

// Assignment 2 continuing from Assignment 1
//Written By: Jamal Shaheen 40327844 and Marilou Grenier 40210227

import client.Client;

public class Trip {
	
// Attributes
	private static int nextID = 2001;
	private final String tripID;
	private String destination;
	private int durationInDays;
	private double basePrice;
	
	// Requirements
	private Client client;
	private Transportation transportation;
	private Accommodation accommodation;
	
// Default Constructor
	public Trip() {
		this.tripID = "T" + nextID++;
		this.destination = "";
		this.durationInDays = 1;
		this.basePrice = 100;
		this.client = null;
		this.transportation = null;
		this.accommodation = null;
	}
	
// Parameterized Constructor
	public Trip(String destination, int durationInDays, double basePrice, Client client, Transportation transportation, Accommodation accommodation) 
		throws InvalidTripDataException {
		
		this.tripID = "T" + nextID++;
		
		if (durationInDays < 1 || durationInDays > 20) // Condition Duration: 1-20 days
	        throw new InvalidTripDataException("Trip duration must be between 1 and 20 days.");

	    if (basePrice < 100.00) // Condition: Base Price >= 100$
	        throw new InvalidTripDataException("Base price must be at least $100.");

	    if (client == null) // Condition: ClientID must exist
	        throw new InvalidTripDataException("Client cannot be null.");
	    
	 // At least one of accommodation or transportation must exist
	    if (accommodation == null && transportation == null)
	        throw new InvalidTripDataException("A trip must have at least accommodation or transportation.");
		
		this.destination = destination;
		this.durationInDays = durationInDays;
		this.basePrice = basePrice;
		this.client = client;
		this.transportation = transportation;
		this.accommodation = accommodation;
	}
	
// Copy Constructor
	public Trip(Trip other) {
		this.tripID = "T" + nextID++;
		this.destination = other.destination;
		this.durationInDays = other.durationInDays;
		this.basePrice = other.basePrice;
		this.client = other.client;
		this.transportation = other.transportation;
		this.accommodation = other.accommodation;
	}

// Accessors and mutators methods
	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getDurationInDays() {
		return durationInDays;
	}

	public void setDurationInDays(int durationInDays)
		throws InvalidTripDataException {
		
		if (durationInDays < 1 || durationInDays > 20)
	        throw new InvalidTripDataException("Trip duration must be between 1 and 20 days.");

		this.durationInDays = durationInDays;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(double basePrice)
		throws InvalidTripDataException {
		
		if (basePrice < 100.0)
	        throw new InvalidTripDataException("Base price must be at least $100.");

		this.basePrice = basePrice;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client)
	        throws InvalidTripDataException {

	    if (client == null)
	        throw new InvalidTripDataException("Client cannot be null.");

	    this.client = client;
	}

	public Transportation getTransportation() {
		return transportation;
	}

	public void setTransportation(Transportation transportation) {
		this.transportation = transportation;
	}

	public Accommodation getAccommodation() {
		return accommodation;
	}

	public void setAccommodation(Accommodation accommodation) {
		this.accommodation = accommodation;
	}

	public String getTripID() {
		return tripID;
	}
	
// calculateTotalCost() method of trip
	public double calculateTotalCost() {
		double total = basePrice;
		if(transportation != null) total += transportation.calculateCost(durationInDays);
		if(accommodation != null) total += accommodation.calculateCost(durationInDays);
		return total;
	}
	
// toString() method
	@Override
	public String toString() {
		return "Trip:" +
				"Trip ID: " + tripID +
				"Destination: " + destination +
				"Duration in days: " + durationInDays +
				"Base price: " + basePrice +
				"Client: " + (client == null ? "null" : client.getClientID()) +
				"Transportation: " + (transportation == null ? "null" : transportation.gettpID()) +
				"Accommodation: " + (accommodation == null ? "null" : accommodation.getAccommodationID())+
				"TotalCost: " + calculateTotalCost();
	}
	
// equals() method
	public boolean equals(Object trp) {
		if(trp == null) return false;
		if(this.getClass() != trp.getClass()) return false;
		Trip other = (Trip) trp;
		boolean sameClient = (client == null && other.client == null) || (client != null && other.client != null && client.equals(other.client));
		boolean sameTranspot = (transportation == null && other.transportation == null) || (transportation != null && other.transportation != null && transportation.equals(other.transportation));
		boolean sameAccom = (accommodation == null && other.accommodation == null) || (accommodation != null && other.accommodation != null && accommodation.equals(other.accommodation));
		return destination.equals(other.destination)
				&& durationInDays == other.durationInDays
				&& basePrice == other.basePrice
				&& sameClient
				&& sameTranspot
				&& sameAccom;
	}

}

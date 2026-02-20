package travel;

public class Train extends Transportation{

// Attributes
	private String trainType;
	private String seatClass;
	
// Default Constructor
	public Train() {
		super();
		this.trainType = "";
		this.seatClass = "";
	}
	
// Parameterized Constructor
	public Train(String companyName, String departureCity, String arrivalCity, String trainType, String seatClass) {
		super(companyName, departureCity, arrivalCity);
		this.trainType = trainType;
		this.seatClass = seatClass;
	}
	
// Copy Constructor
	public Train(Train other) {
		super(other);
		this.trainType = other.trainType;
		this.seatClass = other.seatClass;
	}
	
// Accessors and mutators methods
	public String getTrainType() {
		return trainType;
	}
	public void setTrainType(String trainType) {
		this.trainType = trainType;
	}
	
	public String getSeatClass() {
		return seatClass;
	}
	public void setSeatClass(String seatClass) {
		this.seatClass = seatClass;
	}
	
// toString() method
	@Override
	public String toString() {
		return  super.toString() + "Train: " +
				", trainType: " + trainType +
				"seatClass: " + seatClass;
	}
	
// equals() method
	@Override
	public boolean equals(Object trn) {
		if(!super.equals(trn)) return false;
		Train other = (Train) trn;
		return trainType.equals(other.trainType)
				&& seatClass.equals(other.seatClass);
	}
	
// calculateCost() method (Condition?) (Polymorphic)
	public double calculateCost(int numberOfDays) {
		double base = 80.0;
		if(trainType.toLowerCase().contains("high")) {
				base += 40.0;
			}
		if(seatClass.toLowerCase().contains("first")) {
				base += 30;
			}
		return base;
					
		}

}

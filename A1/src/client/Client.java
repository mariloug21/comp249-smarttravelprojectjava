package client;
//Assignment 1
//Written by: Jamal Shaheen (40327844)
public class Client {
	
// Attributes
	private static int nextID = 1001; // Should start at C1001
	private final String clientID;
	private String firstName;
	private String lastName;
	private String emailAddress;
	
// Default constructor: Initializes fields to default values
	public Client() {
		this.clientID = "C" + nextID++;
		this.firstName = "";
		this.lastName = "";
		this.emailAddress = "";
	}
	
// Parameterized constructor: Initializes all attributes
	public Client(String firstName, String lastName, String emailAddress) {
		this.clientID = "C" + nextID++;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
	}
	
// Copy constructor
	public Client(Client other) {
		this.clientID = "C" + nextID++;
		this.firstName = other.firstName;
		this.lastName = other.lastName;
		this.emailAddress = other.emailAddress;
	}
	
// Getter and Setter methods
	public String getClientID() {
		return clientID;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
// toString() method: Assignment needs a readable well formated description. Overridden to show fields in proper format
	@Override
	public String toString() {
		return "Client: " +
	"clientID: " + clientID + 
	"first name: " + firstName +
	"last name: " + lastName +
	"email address: " + emailAddress;
	
	}
	
// equals() method
	@Override
	public boolean equals(Object cli) {
		if (cli == null) return false;
		if(this.getClass() != cli.getClass()) return false;
		
		Client other = (Client) cli;
		return firstName.equals(other.firstName) && lastName.equals(other.lastName) && emailAddress.equals(other.emailAddress);
	}
	

}

package driver;

//Assignment 1
//Written by: Jamal Shaheen (40327844) & Marilou Grenier (40210227)
//
import java.util.Scanner;

import client.Client;
import travel.*; //uses all classes in the travel package

public class Driver {
	
	private static final Scanner scanner = new Scanner(System.in);
	//Create arrays
	private static final Client[] clients = new Client[50]; //max capacity
	private static final Trip[] trips = new Trip[50]; //max capacity
	private static final Transportation[] transports = new Transportation[50]; //max capacity
	private static final Accommodation[] accommodations = new Accommodation[50]; //max capacity
	

	public static void main(String[] args) {
		
// Menu choice between menu interface and predefined scenario		
		System.out.println("======= Smart Travel =======");
		System.out.println("1) Menu-driven interface");
		System.out.println("2) Predefined scenario");
		System.out.print("Choose option: ");
		int choice = scanner.nextInt();
		if (choice == 2) {
			runPreDefinedScenario(clients, transports, accommodations, trips);
			scanner.close();
			return;
		}

// Menu-driven Interface (user input)
		boolean running = true;
		
		while (running) {
			System.out.println("===Menu Operations===");
			System.out.println("1. Client management");
			System.out.println("2. Trip management");
			System.out.println("3. Transportation managemet");
			System.out.println("4. Accommodation management");
			System.out.println("5. Additional Operations");
			System.out.println("6. Exit");
			System.out.print("Choose");
			int choice1 = scanner.nextInt();
			
			switch (choice1) {
			case 1 -> clientManagementMenu();
			case 2 -> tripManagementMenu();
			case 3 -> transportationManagementMenu();
			case 4 -> accommodationManagementMenu();
			case 5 -> additionalOperationsMenu();
			default -> System.out.println("Invalid choice.");
			
			}
		
		}
		scanner.close();
		System.out.println("Thank you for using the Smart Travel program!");
		

	}

// Predefined Scenario: runPreDefinedScenario()
	
	private static void runPreDefinedScenario(Client[] clients, Transportation[] transports,
			Accommodation[] accommodations, Trip[] trips) {
		
		// Predefined clients (3)
		clients[0] = new Client("Sanar", "Hassoun", "shassoun@gmail.com");
		clients[1] = new Client("Madinah", "Shaheen", "madshah2@gmail.com");
		clients[2] = new Client("Parisa", "Shaheen", "ParisaShaheen@gmail.com");

		// Predefined trips (3)
		trips[0] = new Trip("Barcelona", 5, 300, clients[0], transports[0], accommodations[2]);
		trips[1] = new Trip("New York City", 4, 400, clients[1], transports[2], accommodations[1]);
		trips[2] = new Trip("Los Angles", 3, 200, clients[2], transports[1], accommodations[3]);
	
		
		// Predefined transports (2 x 3 transporation types)
		transports[0] = new Flight("AirCo", "Montreal", "Barcelona", "AirCanada", 20);
		transports[1] = new Flight("AirCo", "Toronto", "New York City", "AirCanada", 20);
		transports[2] = new Train("RailCo", "Munich", "Berlin", "regional", "economy");
		transports[3] = new Train("RailCo", "Milan", "Rome", "regional", "first class");
		transports[4] = new Bus("Exo", "Cote Vertu", "Vaudreuil", "40", 1);
		transports[5] = new Bus("STM", "Fairview", "Lionel-Groulx", "485", 0);

		// Predefined accommodations (2 x 2 accommodation types)
		accommodations[0] = new Hotel("Ritz-Carlton", "Montreal", 220, 5);
		accommodations[1] = new Hotel("Holiday Inn", "New York City", 200, 3);
		accommodations[2] = new Hostel("Hostel Inn", "Barcelona", 40, 6);
		accommodations[3] = new Hostel("Hostel avenue", "Los Angles", 35, 8);

		// Display all created objects using toString() 
		System.out.println("----Clients----");
		listArray(clients);

		System.out.println("----Transportation----");
		listArray(transports);

		System.out.println("----Accommodations----");
		listArray(accommodations);

		System.out.println("----Trips----");
		listArray(trips);

		// Test the equals() method 
		// 1) Compare objects from different classes. (should return false)
		System.out.println("Equals test (Different classes): "
		        + new Client("Sanar", "Hassoun", "shassoun@gmail.com")
		        .equals(new Hotel("Ritz-Carlton", "Montreal", 220, 5)));
		
		// 2) Compare objects of the same class with different attributes. (should return false)
		System.out.println("Equals test (Same class, different values): "
		        + new Client("Sanar", "Hassoun", "shassoun@gmail.com")
		        .equals(new Client("Madinah", "Shaheen", "madshah2@gmail.com")));
		
		// 3) Compare objects of the same class with identical attributes. (should return true)
		System.out.println("Equals test (Clients with identical values): "
				+ new Client("Sanar", "Hassoun", "shassoun@gmail.com")
		        .equals(new Client("Sanar", "Hassoun", "shassoun@gmail.com")));
		
		// Polymorphism Demo for calculateTotalCost() from Trip class
		System.out.println("Trip Cost:");
		for (Trip t : trips) {
			if (t != null)
				System.out.println(t.getTripID() + "->" + t.calculateTotalCost());
		}
		
		// Display most expensive trip
		mostExpensiveTrip();
		
		// Deep copy of transportation array
		Transportation[] transportsCopy = copyTransportationArray(transports);

		// 1) Modify one object in the copied array
		if (transportsCopy[0] != null) {
		    transportsCopy[0].setDepartureCity("Quebec City"); // change departure city
		}

		// 2) Display original vs copy
		System.out.println("Original vs Copied Transportation Array:");
		System.out.println("Original: " + transports[0]);
		System.out.println("Modified: " + transportsCopy[0]);
		
	}

	// ================Utils===============
	// copyTransportationArray(): deep copy method for transportation
	public static Transportation[] copyTransportationArray(Transportation[] original) {
	    Transportation[] copy = new Transportation[original.length];

	    for (int i = 0; i < original.length; i++) {
	        if (original[i] != null) {
	            if (original[i] instanceof Flight) {
	                copy[i] = new Flight((Flight) original[i]);
	            } else if (original[i] instanceof Train) {
	                copy[i] = new Train((Train) original[i]);
	            } else if (original[i] instanceof Bus) {
	                copy[i] = new Bus((Bus) original[i]);
	            }
	        }
	    }

	    return copy;
	}
	
	// copyAccommodationArray(): deep copy of method for accommodation
	public static Accommodation[] copyAccommodationArray(Accommodation[] original) {
	    Accommodation[] copy = new Accommodation[original.length];

	    for (int i = 0; i < original.length; i++) {
	        if (original[i] != null) {
	            if (original[i] instanceof Hotel) {
	                copy[i] = new Hotel((Hotel) original[i]);
	            } else if (original[i] instanceof Hostel) {
	                copy[i] = new Hostel((Hostel) original[i]);
	            }
	        }
	    }

	    return copy;
	}

	// listArray() method
	private static <T> void listArray(T[] arr) { // <T>: uses a generic type, works for any object array
		for (T t : arr) {
			if (t != null)
				System.out.println(t);
		}
	}
	
	// readDouble() method
	private static double readDouble() {
		while (true) {
			String s = scanner.nextLine().trim();
			return Double.parseDouble(s);
		}
	}
	
	// firstNullIndex() method: returns -1 if the array is full
	private static int firstNullIndex(Object[] arr) {
		for (int i=0; i < arr.length; i++) {
			if(arr[i] == null) return i;
		}
		return -1;
	}
	
	// countNonNull() method
	private static int countNonNull(Object[] arr) {
		int count = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != null) {
				count++;
			}
		}
		return count;
	}
	
	// mostExpensiveTrip() method
		private static void mostExpensiveTrip() {
		    if (countNonNull(trips) == 0) {
		        System.out.println("No trips available.");
		        return;
		    }

		    Trip mostExpensive = null;
		    double maxCost = 0;

		    for (int i = 0; i < trips.length; i++) {
		        Trip t = trips[i];
		        if (t != null) {
		            double cost = t.calculateTotalCost(); // Polymorphism
		            if (cost > maxCost) {
		                maxCost = cost;
		                mostExpensive = t;
		            }
		        }
		    }

		    System.out.println("Most expensive trip:");
		    System.out.println(mostExpensive); 
		    System.out.println("Total cost: " + maxCost);
		}
		
		// findIndexByIdClient() method
		private static int findIndexByIdClient(Client[] arr, int count, String id) {
		    if (id == null) return -1;
		    id = id.trim();

		    for (int i = 0; i < count; i++) {
		        Client c = arr[i];
		        if (c != null && c.getClientID().equalsIgnoreCase(id)) {
		            return i;
		        }
		    }
		    return -1;
		}
		
		// findIndexByTransport() method
		public static int findIndexByIdTransport(Transportation[] arr, int count, String id) {
		    if (id == null) return -1;
		    id = id.trim();

		    for (int i = 0; i < count; i++) {
		    	Transportation t = arr[i];
		        if (t != null && t.gettpID().equalsIgnoreCase(id)) {
		            return i;
		        }
		    }

		    return -1; 
		}
		
		// findIndexByAccommodation() method
		public static int findIndexByIdAccommodation(Accommodation[] arr, int count, String id) {
		    if (id == null) return -1;
		    id = id.trim();

		    for (int i = 0; i < count; i++) {
		        Accommodation a = arr[i];
		        if (a != null && a.getAccommodationID().equalsIgnoreCase(id)) {
		            return i;
		        }
		    }

		    return -1; 
		}
		
		// findIndexByTrip() method
		public static int findIndexByIdTrip(Trip[] arr, int count, String id) {
		    if (id == null) return -1;
		    id = id.trim();

		    for (int i = 0; i < count; i++) {
		        Trip t = arr[i];
		        if (t != null && t.getTripID().equalsIgnoreCase(id)) {
		            return i;
		        }
		    }

		    return -1; 
		}
		
		// compact() method for arrays clarity
		public static <T> void compact(T[] arr) {
		    int writeIndex = 0;
		    
		    for (int i = 0; i < arr.length; i++) { // Move all non-null elements to the front of the array
		        if (arr[i] != null) {
		            arr[writeIndex++] = arr[i];
		        }
		    }
		    while (writeIndex < arr.length) {  // Fill the rest of the index with nulls
		        arr[writeIndex++] = null;
		    }
		}

	// =======Menu operations==========

	// 1) CLIENT MANAGEMENT

	private static void clientManagementMenu() {
        boolean back = false;
       

        while (!back) {
            System.out.println("\n--- Client Management ---");
            System.out.println("1) Add a client");
            System.out.println("2) Edit a client");
            System.out.println("3) Delete a client");
            System.out.println("4) List all clients");
            System.out.println("0) Back");
            System.out.print("Choose: ");

            int choice2 = scanner.nextInt();

            switch (choice2) {
                case 1 -> addClient();
                case 2 -> editClient();
                case 3 -> deleteClient();
                case 4 -> listClients();
                case 0 -> back = true;
                default -> System.out.println("Invalid choice.");
            }
        }
    }
	
	// addClient() method
	private static void addClient() {

		int idx = firstNullIndex(clients);
		if (idx == -1) {
			System.out.println("Client list is full.");
			return;
		}

		System.out.print("First name: ");
		String fn = scanner.nextLine();
		System.out.print("Last name: ");
		String ln = scanner.nextLine();
		System.out.print("Email: ");
		String em = scanner.nextLine();

		clients[idx] = new Client(fn, ln, em);
		System.out.println("Added: " + clients[idx]);
	}
	
	// editClient() method
	private static void editClient() {
		if (countNonNull(clients) == 0) {
			System.out.println("No clients to edit.");
			return;
		}

		listClients();
		System.out.print("Enter Client ID to edit (e.g., C1001): ");
		String id = scanner.nextLine();

		int idx = findIndexByIdClient(clients, countNonNull(clients), id);
		if (idx == -1) {
			System.out.println("Client not found.");
			return;
		}

		Client c = clients[idx];
		System.out.println("Editing: " + c);

		System.out.print("New first name (blank to keep): ");
		String fn = scanner.nextLine();
		if (!fn.isEmpty())
			c.setFirstName(fn);

		System.out.print("New last name (blank to keep): ");
		String ln = scanner.nextLine();
		if (!ln.isEmpty())
			c.setLastName(ln);

		System.out.print("New email (blank to keep): ");
		String em = scanner.nextLine();
		if (!em.isEmpty())
			c.setEmailAddress(em);

		System.out.println("Updated: " + c);
	}
	
	// deleteClient() method
	private static void deleteClient() {
		if (countNonNull(clients) == 0) {
			System.out.println("No clients to delete.");
			return;
		}

		listClients();
		System.out.print("Enter Client ID to delete: ");
		String id = scanner.nextLine();

		int idx = findIndexByIdClient(clients, countNonNull(clients), id);
		if (idx == -1) {
			System.out.println("Client not found.");
			return;
		}

		System.out.println("Deleted: " + clients[idx]);
		clients[idx] = null;
		compact(clients);
	}
	
	// listClient() method
	private static void listClients() {
		System.out.println("\nClients:");
		listArray(clients);
	}
	
	// 2) TRIP MANAGEMENT
	 private static void tripManagementMenu() {
	        boolean back = false;

	        while (!back) {
	            System.out.println("\n--- Trip Management ---");
	            System.out.println("1) Create a trip");
	            System.out.println("2) Edit trip information");
	            System.out.println("3) Cancel a trip");
	            System.out.println("4) List all trips");
	            System.out.println("5) List all trips for a specific client");
	            System.out.println("0) Back");
	            System.out.print("Choose: ");

	            int choice3 = scanner.nextInt();

	            switch (choice3) {
	                case 1 -> createTrip();
	                case 2 -> editTrip();
	                case 3 -> cancelTrip();
	                case 4 -> listTrips();
	                case 5 -> listTripsForClient();
	                case 0 -> back = true;
	                default -> System.out.println("Invalid choice.");
	            }
	        }
	    }
	 
	 	// createTrip() method
	    private static void createTrip() {
	        int idx = firstNullIndex(trips);
	        if (idx == -1) {
	            System.out.println("Trip list is full.");
	            return;
	        }

	        if (countNonNull(clients) == 0) { System.out.println("Add clients first."); return; }
	        if (countNonNull(transports) == 0) { System.out.println("Add transportation options first."); return; }
	        if (countNonNull(accommodations) == 0) { System.out.println("Add accommodations first."); return; }

	        System.out.print("Destination: ");
	        String destination = scanner.nextLine();

	        System.out.print("Duration in days: ");
	        int days = scanner.nextInt();
	        scanner.nextLine();

	        System.out.print("Base price: ");
	        double base = readDouble();

	        System.out.println("\nChoose a Client by ID:");
	        listClients();
	        System.out.print("Client ID: ");
	        String cid = scanner.nextLine();
	        int cIdx = findIndexByIdClient(clients, countNonNull(clients), cid);
	        if (cIdx == -1) { System.out.println("Client not found."); return; }

	        System.out.println("\nChoose Transportation by ID:");
	        listTransports();
	        System.out.print("Transportation ID: ");
	        String tid = scanner.nextLine();
	        int tIdx = findIndexByIdTransport(transports, countNonNull(transports), tid);
	        if (tIdx == -1) { System.out.println("Transportation not found."); return; }

	        System.out.println("\nChoose Accommodation by ID:");
	        listAccommodations();
	        System.out.print("Accommodation ID: ");
	        String aid = scanner.nextLine();
	        int aIdx = findIndexByIdAccommodation(accommodations, countNonNull(accommodations), aid);
	        if (aIdx == -1) { System.out.println("Accommodation not found."); return; }

	        trips[idx] = new Trip(destination, days, base, clients[cIdx], transports[tIdx], accommodations[aIdx]);
	        System.out.println("Created: " + trips[idx]);
	    }

	    // editTrip()
	    private static void editTrip() {
	        if (countNonNull(trips) == 0) {
	            System.out.println("No trips to edit.");
	            return;
	        }

	        listTrips();
	        System.out.print("Enter Trip ID to edit (e.g., T2001): ");
	        String id = scanner.nextLine();

	        int idx = findIndexByIdTrip(trips, countNonNull(trips), id);
	        if (idx == -1) { System.out.println("Trip not found."); return; }

	        Trip t = trips[idx];
	        System.out.println("Editing: " + t);

	        System.out.print("New destination (blank to keep): ");
	        String dest = scanner.nextLine();
	        if (!dest.isEmpty()) t.setDestination(dest);

	        System.out.print("New duration in days (0 to keep): ");
	        int days = scanner.nextInt();
	        scanner.nextLine();
	        if (days > 0) t.setDurationInDays(days);

	        System.out.print("New base price (-1 to keep): ");
	        double base = readDouble();
	        if (base >= 0) t.setBasePrice(base);

	        System.out.print("Change client? (y/n): ");
	        if (scanner.nextLine().trim().equalsIgnoreCase("y")) {
	            listClients();
	            System.out.print("Client ID: ");
	            String cid = scanner.nextLine();
	            int cIdx = findIndexByIdClient(clients, countNonNull(clients), cid);
	            if (cIdx != -1) t.setClient(clients[cIdx]);
	        }

	        System.out.print("Change transportation? (y/n): ");
	        if (scanner.nextLine().trim().equalsIgnoreCase("y")) {
	            listTransports();
	            System.out.print("Transportation ID: ");
	            String tid = scanner.nextLine();
	            int tIdx = findIndexByIdTransport(transports, countNonNull(transports), tid);
	            if (tIdx != -1) t.setTransportation(transports[tIdx]);
	        }

	        System.out.print("Change accommodation? (y/n): ");
	        if (scanner.nextLine().trim().equalsIgnoreCase("y")) {
	            listAccommodations();
	            System.out.print("Accommodation ID: ");
	            String aid = scanner.nextLine();
	            int aIdx = findIndexByIdAccommodation(accommodations, countNonNull(accommodations), aid);
	            if (aIdx != -1) t.setAccommodation(accommodations[aIdx]);
	        }

	        System.out.println("Updated: " + t);
	    }

	    // cancelTrip() method
	    private static void cancelTrip() {
	        if (countNonNull(trips) == 0) {
	            System.out.println("No trips to cancel.");
	            return;
	        }

	        listTrips();
	        System.out.print("Enter Trip ID to cancel: ");
	        String id = scanner.nextLine();

	        int idx = findIndexByIdTrip(trips, countNonNull(trips), id);
	        if (idx == -1) { System.out.println("Trip not found."); return; }

	        System.out.println("Canceled: " + trips[idx]);
	        trips[idx] = null;
	        compact(trips);
	    }

	    // listTrips() method
	    private static void listTrips() {
	        System.out.println("\nTrips:");
	        listArray(trips);
	    }

	    // lisTripsByClient() method
	    private static void listTripsForClient() {
	        if (countNonNull(trips) == 0) {
	            System.out.println("No trips in system.");
	            return;
	        }

	        listClients();
	        System.out.print("Enter Client ID: ");
	        String cid = scanner.nextLine();

	        System.out.println("\nTrips for client " + cid + ":");
	        boolean found = false;
	        for (Trip t : trips) {
	            if (t == null) continue;
	            if (t.getClient() != null && t.getClient().getClientID().equalsIgnoreCase(cid)) {
	                System.out.println(t);
	                found = true;
	            }
	        }
	        if (!found) System.out.println("(none)");
	    }
	    
	    // 3) TRANSPORTATION MANAGEMENT
	    
	    private static void transportationManagementMenu() {
	        boolean back = false;

	        while (!back) {
	            System.out.println("\n--- Transportation Management ---");
	            System.out.println("1) Add a transportation option");
	            System.out.println("2) Remove a transportation option");
	            System.out.println("3) List transportation options by type (Flight, Train, Bus)");
	            System.out.println("4) List all transportation options");
	            System.out.println("0) Back");
	            System.out.print("Choose: ");

	            int choice4 = scanner.nextInt();

	            switch (choice4) {
	                case 1 -> addTransport();
	                case 2 -> removeTransport();
	                case 3 -> listTransportByType();
	                case 4 -> listTransports();
	                case 0 -> back = true;
	                default -> System.out.println("Invalid choice.");
	            }
	        }
	    }
	    
	    // addTransport() method
	    private static void addTransport() {
	        int idx = firstNullIndex(transports);
	        if (idx == -1) { System.out.println("Transportation list is full."); return; }

	        System.out.println("Choose type:");
	        System.out.println("1) Flight");
	        System.out.println("2) Train");
	        System.out.println("3) Bus");
	        System.out.print("Type: ");
	        int type = scanner.nextInt();
	        scanner.nextLine();

	        System.out.print("Company name: ");
	        String company = scanner.nextLine();
	        System.out.print("Departure city: ");
	        String dep = scanner.nextLine();
	        System.out.print("Arrival city: ");
	        String arr = scanner.nextLine();

	        if (type == 1) {
	            System.out.print("Airline name: ");
	            String airline = scanner.nextLine();
	            System.out.print("Luggage allowance (kg): ");
	            double kg = readDouble();
	            transports[idx] = new Flight(company, dep, arr, airline, kg);

	        } else if (type == 2) {
	            System.out.print("Train type: ");
	            String trainType = scanner.nextLine();
	            System.out.print("Seat class: ");
	            String seat = scanner.nextLine();
	            transports[idx] = new Train(company, dep, arr, trainType, seat);

	        } else if (type == 3) {
	            System.out.print("Bus company: ");
	            String busCo = scanner.nextLine();
	            System.out.print("Number of stops: ");
	            int stops = scanner.nextInt();
	            scanner.nextLine();
	            transports[idx] = new Bus(company, dep, arr, busCo, stops);

	        } else {
	            System.out.println("Invalid transportation type.");
	            return;
	        }

	        System.out.println("Added: " + transports[idx]);
	    }

	    // removeTransport() method
	    private static void removeTransport() {
	        if (countNonNull(transports) == 0) {
	            System.out.println("No transportation options to remove.");
	            return;
	        }

	        listTransports();
	        System.out.print("Enter Transportation ID to remove (e.g., TR3001): ");
	        String id = scanner.nextLine();

	        int idx = findIndexByIdTransport(transports, countNonNull(transports), id);
	        if (idx == -1) { System.out.println("Transportation not found."); return; }

	        System.out.println("Removed: " + transports[idx]);
	        transports[idx] = null;
	        compact(transports);
	    }

	    // listTransportByType() method
	    private static void listTransportByType() {
	        System.out.print("Enter type (Flight/Train/Bus): ");
	        String type = scanner.nextLine().trim().toLowerCase();

	        boolean found = false;
	        for (Transportation t : transports) {
	            if (t == null) continue;
	            if (t.getClass().getSimpleName().toLowerCase().equals(type)) {
	                System.out.println(t);
	                found = true;
	            }
	        }
	        if (!found) System.out.println("(none)");
	    }

	    // listTransport() method
	    private static void listTransports() {
	        System.out.println("\nTransportation options:");
	        listArray(transports);
	    }
	    
	    // 4) ACCOMMODATION MANAGEMENT
	    private static void accommodationManagementMenu() {
	        boolean back = false;

	        while (!back) {
	            System.out.println("\n--- Accommodation Management ---");
	            System.out.println("1) Add an accommodation");
	            System.out.println("2) Remove an accommodation");
	            System.out.println("3) List accommodations by type (Hotel, Hostel)");
	            System.out.println("4) List all accommodations");
	            System.out.println("0) Back");
	            System.out.print("Choose: ");

	            int choice5 = scanner.nextInt();
	            scanner.nextLine();

	            switch (choice5) {
	                case 1 -> addAccommodation();
	                case 2 -> removeAccommodation();
	                case 3 -> listAccommodationByType();
	                case 4 -> listAccommodations();
	                case 0 -> back = true;
	                default -> System.out.println("Invalid choice.");
	            }
	        }
	    }

	    // addAccommodation() method
	    private static void addAccommodation() {
	        int idx = firstNullIndex(accommodations);
	        if (idx == -1) { System.out.println("Accommodation list is full."); return; }

	        System.out.println("Choose type:");
	        System.out.println("1) Hotel");
	        System.out.println("2) Hostel");
	        System.out.print("Type: ");
	        int type = scanner.nextInt();
	        scanner.nextLine();

	        System.out.print("Name: ");
	        String accommodationName = scanner.nextLine();
	        System.out.print("Location: ");
	        String location = scanner.nextLine();
	        System.out.print("Price per night: ");
	        double pricePerNight = readDouble();

	        if (type == 1) {
	            System.out.print("Star rating: ");
	            int starRating = scanner.nextInt();
	            scanner.nextLine();
	            accommodations[idx] = new Hotel(accommodationName, location, pricePerNight, starRating);

	        } else if (type == 2) {
	            System.out.print("Shared beds per room: ");
	            int numberOfBeds = scanner.nextInt();
	            scanner.nextLine();
	            accommodations[idx] = new Hostel(accommodationName, location, pricePerNight , numberOfBeds);

	        } else {
	            System.out.println("Invalid accommodation type.");
	            return;
	        }

	        System.out.println("Added: " + accommodations[idx]);
	    }
	    
	    // removeAccommodation() method
	    private static void removeAccommodation() {
	        if (countNonNull(accommodations) == 0) {
	            System.out.println("No accommodations to remove.");
	            return;
	        }

	        listAccommodations();
	        System.out.print("Enter Accommodation ID to remove (e.g., A4001): ");
	        String id = scanner.nextLine();

	        int idx = findIndexByIdAccommodation(accommodations, countNonNull(accommodations), id);
	        if (idx == -1) { System.out.println("Accommodation not found."); return; }

	        System.out.println("Removed: " + accommodations[idx]);
	        accommodations[idx] = null;
	        compact(accommodations);
	    }

	    // listAccommodationByType() method
	    private static void listAccommodationByType() {
	        System.out.print("Enter type (Hotel/Hostel): ");
	        String type = scanner.nextLine().trim().toLowerCase();

	        boolean found = false;
	        for (Accommodation a : accommodations) {
	            if (a == null) continue;
	            if (a.getClass().getSimpleName().toLowerCase().equals(type)) {
	                System.out.println(a);
	                found = true;
	            }
	        }
	        if (!found) System.out.println("(none)");
	    }

	    // listAccommodations() method
	    private static void listAccommodations() {
	        System.out.println("\nAccommodations:");
	        listArray(accommodations);
	    }
	    
	    // 5) ADDITIONAL OPERATIONS
	    private static void additionalOperationsMenu() {
	        boolean back = false;

	        while (!back) {
	            System.out.println("\n--- Additional Operations ---");
	            System.out.println("1) Display most expensive trip");
	            System.out.println("2) Calculate total cost of a trip");
	            System.out.println("3) Deep copy transportation array");
	            System.out.println("4) Deep copy accommodation array");
	            System.out.println("0) Back");
	            System.out.print("Choose: ");

	            int choice6 = scanner.nextInt();
	            scanner.nextLine();

	            switch (choice6) {
	                case 1 -> mostExpensiveTrip();
	                case 2 -> {
	                	travel.calculateTotalCost();
	                }
	                case 3 -> {
	                    Transportation[] copy = copyTransportationArray(transports);
	                    System.out.println("Transportation array copied.");
	                }
	                case 4 -> {
	                    Accommodation[] copy = copyAccommodationArray(accommodations);
	                    System.out.println("Accommodation array copied.");
	                }
	                case 0 -> back = true;
	                default -> System.out.println("Invalid choice.");
	            }
	        }
	    }
	    

	

}


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {

    private static final boolean True = false;
	private static final boolean False = false;
	// instance variables (add more as needed)
	private static ArrayList<Ship> shipList = new ArrayList<Ship>();
	private static ArrayList<Cruise> cruiseList = new ArrayList<Cruise>();
	private static ArrayList<Passenger> passengerList = new ArrayList<Passenger>();
	private static Scanner newScanner = new Scanner(System.in);

    public static void main(String[] args) {

    	initializeShipList();       // initial ships
        initializeCruiseList();     // initial cruises
        initializePassengerList();  // initial passengers
        displayMenu();
        String programInput = newScanner.nextLine();
      	while ( ! programInput.equalsIgnoreCase("x")) {
      		switch(programInput){
              case "1":
            	  addShip();
            	  break;
              case "2":
            	  editShip();
            	  break;
              case "3":
            	  addCruise();
            	  break;
              case "4":
            	  editCruise();
            	  break;
              case "5":
            	  addPassenger();
            	  break;
              case "A":
            	  printShipList("name");
            	  break;
              case "B":
            	  printShipList("active");
            	  break;
              case "C":
            	  printShipList("full");
            	  break;
              case "D":
            	  printCruiseList("list");
            	  break;
              case "E":
            	  printCruiseList("details");
            	  break;
              case "F":
            	  printPassengerList();
            	  break;
              default:
            	  System.out.println("Error!");
      		}
                  displayMenu();
                  programInput = newScanner.nextLine();
        }
    }
    	//end of switch
        // add loop and code here that accepts and validates user input
        // and takes the appropriate action. include appropriate
        // user feedback and redisplay the menu as needed
        

    // hardcoded ship data for testing
    // Initialize ship list
    public static void initializeShipList() {
        add("Candy Cane", 20, 40, 10, 60, true);
        add("Peppermint Stick", 10, 20, 5, 40, true);
        add("Bon Bon", 12, 18, 2, 24, false);
        add("Candy Corn", 12, 18, 2, 24, false);
    }

    // hardcoded cruise data for testing
    // Initialize cruise list
    public static void initializeCruiseList() {
        Cruise newCruise = new Cruise("Southern Swirl", "Candy Cane", "Miami", "Cuba", "Miami");
        cruiseList.add(newCruise);
    }

    // hardcoded cruise data for testing
    // Initialize passenger list
    public static void initializePassengerList() {
        Passenger newPassenger1 = new Passenger("Neo Anderson", "Southern Swirl", "STE");
        passengerList.add(newPassenger1);

        Passenger newPassenger2 = new Passenger("Trinity", "Southern Swirl", "STE");
        passengerList.add(newPassenger2);

        Passenger newPassenger3 = new Passenger("Morpheus", "Southern Swirl", "BAL");
        passengerList.add(newPassenger3);
    }

    // custom method to add ships to the shipList ArrayList
    public static void add(String tName, int tBalcony, int tOceanView,
                           int tSuite, int tInterior, boolean tInService) {
        Ship newShip = new Ship(tName, tBalcony, tOceanView, tSuite, tInterior, tInService);
        shipList.add(newShip);
    }


    public static void printShipList(String listType) {
        // printShipList() method prints list of ships from the
        // shipList ArrayList. There are three different outputs
        // based on the listType String parameter:
        // name - prints a list of ship names only
        // active - prints a list of ship names that are "in service"
        // full - prints tabbed data on all ships

        if (shipList.size() < 1) {
            System.out.println("There are no ships to print.");
            return;
        }
        if (listType == "name") {
            System.out.println("SHIP LIST - Name");
            for (int i = 0; i < shipList.size(); i++) {
                System.out.println(shipList.get(i));
            }
        } else if (listType == "active") {
            System.out.println("SHIP LIST - Active");

            for (int i = 0; i < shipList.size(); i++) {
                if (shipList.get(i).getInService() == true)
                  System.out.println(shipList.get(i));
              }

        } else if (listType == "full") {
            System.out.println("SHIP LIST - Full");
            System.out.println("-----------------------------------------------");
            System.out.println("                    Number of Rooms     In");
            System.out.print("SHIP NAME           Bal OV  Ste Int     Service");
            System.out.println("-----------------------------------------------");
            for (Ship eachShip: shipList)
                eachShip.printShipData();

        } else
            System.out.println("Error: List type not defined.");
    }

    public static void printCruiseList(String listType) {
        if (cruiseList.size() < 1) {
            System.out.println("There are no cruises to print.");
            return;
        }
        if (listType == "list") {
            System.out.println("CRUISE LIST");
            for (int i=0; i < cruiseList.size(); i++) {
                System.out.println(cruiseList.get(i));
            }
        } else if (listType == "details") {
            System.out.println("CRUISE LIST - Details");
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println("                                      |----------------------PORTS-----------------------|");
            System.out.print("CRUISE NAME         SHIP NAME           DEPARTURE           DESTINATION         RETURN");
            System.out.println("-----------------------------------------------------------------------------------------");
            for (Cruise eachCruise: cruiseList)
                eachCruise.printCruiseDetails();
        } else
            System.out.println("Error: List type not defined.");
    }

    public static void printPassengerList() {
        if (passengerList.size() < 1) {
            System.out.println("There are no passengers to print.");
            return;
        }
        System.out.println("PASSENGER LIST");
        System.out.println("-----------------------------------------------------");
        System.out.print("PASSENGER NAME      CRUISE              ROOM TYPE");
        System.out.println("-----------------------------------------------------");
        for (Passenger eachPassenger: passengerList)
            eachPassenger.printPassenger();
    }

    // display text-based menu
    public static void displayMenu() {

        System.out.println("");
        System.out.println("				Luxury Ocean Cruise Outings");
        System.out.println("					System Menu");
        System.out.println();
        System.out.println("			[1] Add Ship            [A] Print Ship Names");
        System.out.println("			[2] Edit Ship           [B] Print Ship In Service List");
        System.out.println("			[3] Add Cruise          [C] Print Ship Full List");
        System.out.println("			[4] Edit Cruise         [D] Print Cruise List");
        System.out.println("			[5] Add Passenger       [E] Print Cruise Details");
        System.out.println("			[6] Edit Passenger      [F] Print Passenger List");
        System.out.println("			[x] Exit System");
        System.out.println();
        System.out.println("			Enter a menu selection: ");
    }

    // Add a New Ship
    public static void addShip() {

        // complete this method
        Scanner newShipInput = new Scanner(System.in);
        System.out.println("Enter the new ship's name: ");
        String newShipName = newShipInput.nextLine();
        

        for (Ship eachShip: shipList) {
            if (eachShip.getShipName().equalsIgnoreCase(newShipName)) {
                System.out.println("That ship is already in the system. Exiting to menu...");
                return;
            }
        }
      
        try {
            System.out.println("Enter the number of the ship's balcony rooms: ");
            int roomBalcony = newShipInput.nextInt();
            while (roomBalcony < 0) {
                System.out.println("Invalid value. Please enter a positive number of the ship's balcony rooms: ");
                roomBalcony = newShipInput.nextInt();
            }
            System.out.println("Enter the number of the ship's ocean view rooms: ");
            int roomOceanView = newShipInput.nextInt();
            while (roomOceanView < 0){
                System.out.println("Invalid value. Please enter a positive number of the ship's ocean view rooms: ");
                roomOceanView = newShipInput.nextInt();
            }
            System.out.println("Enter the number of the ship's suite rooms: ");
            int roomSuite = newShipInput.nextInt();
            while (roomSuite < 0) {
                System.out.println("Invalid value. Please enter a positive number of the ship's suite rooms: ");
                roomSuite = newShipInput.nextInt();
            }
            System.out.println("Enter the number of the ship's interior rooms: ");
            int roomInterior = newShipInput.nextInt();
            while (roomInterior < 0) {
                System.out.println("Invalid value. Please enter a positive number of the ship's interior rooms: ");
                roomInterior = newShipInput.nextInt();
            }
            System.out.println("Is the ship in service? (true/false): ");
            boolean inService = newShipInput.nextBoolean();

            Ship newShip = new Ship(newShipName, roomBalcony, roomOceanView, roomSuite, roomInterior, inService) ;

            shipList.add(newShip);
          
        } catch (InputMismatchException e) {
                System.out.println("Invalid input!");
        }
    }
    // Edit an existing ship
    public static void editShip() {

        // This method does not need to be completed
        System.out.println("The 'Edit Ship' feature is not yet implemented.");
    }

    // Add a New Cruise
    public static void addCruise() {

        // complete this method
        Scanner newCruiseInput = new Scanner(System.in);
        System.out.println("Enter the new cruise's name: ");
        String newCruiseName = newCruiseInput.nextLine();
        boolean isValid = true;
      	boolean availableShip = false;

        for (Cruise eachCruise: cruiseList) {
            if (eachCruise.getCruiseName().equalsIgnoreCase(newCruiseName)) {
                System.out.println("That cruise is already in the system. Exiting to menu...");
                isValid = false;
            }
        }
      
      	if (isValid) {
          try {
              System.out.println("Enter the ship name: ");
              String shipName = newCruiseInput.nextLine();
              while (!availableShip) {
                  for (Ship eachShip: shipList) {
                      if (eachShip.getShipName().equalsIgnoreCase(shipName)) {
                          availableShip = true;
                      }
                  }
               	  if (!availableShip) {
                    System.out.println("This ship doesn't exist. Please enter a valid ship name: ");
                  	shipName = newCruiseInput.nextLine();
                  }
              }
              System.out.println("Enter the departure port: ");   //Depart
              String departurePort = newCruiseInput.nextLine();
            
              System.out.println("Enter the destination: ");       //Destination
              String destination = newCruiseInput.nextLine();
          
              System.out.println("Enter the return port: ");     //Return
			  String returnPort = newCruiseInput.nextLine();

              
              System.out.println("Is the ship in service? (true/false): ");     
              Cruise newCruise = new Cruise(newCruiseName, shipName, departurePort, destination, returnPort) ;

              cruiseList.add(newCruise);

          } catch (InputMismatchException e) {
                  System.out.println("Invalid input!");
          }
        }
        
    }

    // Edit an existing cruise
    public static void editCruise() {

        // This method does not need to be completed
        System.out.println("The 'Edit Cruise' feature is not yet implemented.");

    }


 // Add a New Passenger
    public static void addPassenger() {

    
        	Scanner newPassengerInput = new Scanner(System.in);
			System.out.println("Enter the new passenger's name: ");
			String newPassengerName = newPassengerInput.nextLine();

			// ensure new passenger name does not already exist
			for (Passenger eachPassenger: passengerList) {
			    if (eachPassenger.getPassengerName().equalsIgnoreCase(newPassengerName)) {
			        System.out.println("That passenger is already in the system. Exiting to menu...");
			        return; // quits addPassenger() method processing
			    }
			}

			// get cruise name for passenger
			System.out.println("Enter cruise name: ");
			String newCruiseName = newPassengerInput.nextLine();
			boolean cruiseFound = false;
			// ensure cruise exists
			for (Cruise eachCruise: cruiseList) {
			    if (eachCruise.getCruiseName().equalsIgnoreCase(newCruiseName)) {
			        // cruise does exist
			    	cruiseFound = true;
			    	break;
			    } 
			}
			
			if(cruiseFound == false) {
		        System.out.println("That cruise does not exist in the system. Exiting to menu...");
		        return; // quits addPassenger() method processing
		    }

			// get room type
			System.out.println("Enter Room Type (BAL, OV, STE, or INT: ");
			String room = newPassengerInput.nextLine();
			// validate room type
			if ((room.equalsIgnoreCase("BAL")) || (room.equalsIgnoreCase("OV")) ||
			        (room.equalsIgnoreCase("STE")) || (room.equalsIgnoreCase("INT"))) {
			    // validation passed - add passenger
			    Passenger newPassenger = new Passenger(newPassengerName, newCruiseName, room.toUpperCase());
			    passengerList.add(newPassenger);
			} else {
			    System.out.println("Invalid input. Exiting to menu...");
			    return; // quits addPassenger() method processing
			}
		
    }


    // Edit an existing passenger
    public static void editPassenger() {

        // This method does not need to be completed
        System.out.println("The 'Edit Passenger' feature is not yet implemented.");

    }

    // Method to check if input is a number
    public static boolean isANumber(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i)) == false)
                return false;
        }
        return true;
    }

}
import java.util.Scanner;

public class LibraryStaff {
    enum Command {
        LIST,
        CHECKOUT,
        CHECKIN,
        REGISTER,
        DEREGISTER,
        INFO,
        QUIT,
        UNKNOWN
    }
    
    public static Command parseCommand(String userInput) {
        String commandString = userInput.split(" ")[0];
        switch (commandString) {
	        case "list":
	            return Command.LIST;
	        case "checkout":
	            return Command.CHECKOUT;
	        case "checkin":
	            return Command.CHECKIN;
	        case "register":
	            return Command.REGISTER;
	        case "deregister":
	            return Command.DEREGISTER;
	        case "info":
	            return Command.INFO;
	        case "quit":
	            return Command.QUIT;
	        default:
	        	return Command.UNKNOWN;
        }
    }
    
    public static String parseArgument(String userInput) {
        String argument = userInput.split(" ")[1];
        return argument;
    }

    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	while (true) {
		    String userInput = scanner.nextLine();
		    Command command = parseCommand(userInput);
		    if(userInput.contains(" ")) {
		    	String argument = parseArgument(userInput);
		    }
		    
		    if (command == Command.LIST) {
		    	//Prints out article numbers, titles and inventory status for each registered product.
		    	//Prints out the names and phone numbers of customers that have borrowed a product.
		    } else if (command == Command.CHECKOUT) {
		    	//If someone has borrowed the product
		    		System.out.println("Cannot lend (product name) to another customer. It is already borrowed by (customer name)");
		        //else
			    	System.out.println("Enter customer name:");
			        scanner.nextLine(); //TEMPORARY
			        System.out.println("Enter customer phone number:");
			        scanner.nextLine(); //TEMPORARY
			        System.out.println("Successfully lended (product name) to (customer name)");
		        
		    } else if (command == Command.CHECKIN) {
		    	//If someone has borrowed the product
		    		System.out.println("Successfully returned (product name) from (customer name)");
		    	//else
		    		System.out.println("Cannot return (product name). It is not borrowed by any customer.");
		    } else if (command == Command.REGISTER) {
		    	System.out.println("What are you registering? Book (b), Movie (m)");
		    	scanner.nextLine(); //TEMPORARY
		    	System.out.println("Enter product ID:");
		    	scanner.nextLine(); //TEMPORARY
		    	System.out.println("Enter title:");
		    	scanner.nextLine(); //TEMPORARY
		    	System.out.println("Enter value:");
		    	scanner.nextLine(); //TEMPORARY
		    	
		    	//If it's a Book
		    		System.out.println("Enter number of pages:");
		    		scanner.nextLine(); //TEMPORARY
		    		System.out.println("Enter publisher:");
		    		scanner.nextLine(); //TEMPORARY
		    	//else if it's a Movie
		    		System.out.println("Enter length:");
		    		scanner.nextLine(); //TEMPORARY
		    		System.out.println("Enter rating:");
		    		scanner.nextLine(); //TEMPORARY
		    	
		    	//If it's not already registered
		    		System.out.println("Successfully registered (product name)!");
		    	//else 
		    		System.out.println("Error: Product with ID (product ID) is already registered.");
		    } else if (command == Command.DEREGISTER) {
		    	System.out.println("Successfully deregistered (product name)");
		    } else if (command == Command.INFO) {
		    	//If the product is a registered Book
		    		System.out.println("(product type) (product name): Value (product value)kr, Number of pages: (book pages), Publisher (book author)");
		    	//else if it's a registered Movie
		    		System.out.println("(product type) (product name): Value (product value)kr, Length (movie length), Rating (movie rating)");
		    	//else 
		    		System.out.println("Error: No product with id (product id) registered.");	
		    } else if (command == Command.QUIT) {
		        System.out.println("Goodbye!");
		        scanner.close();
		        System.exit(0);
		    } else if(command == Command.UNKNOWN) {
		    	System.out.println("Unknown command. Try again.");
		    	continue;
		    }
    	}
    }
}
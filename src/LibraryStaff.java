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
    	if(userInput.contains(" ")) {
            String argument = userInput.split(" ")[1];
            return argument;
    	}
    	return "";
    }

	public static void main(String[] args) {
    	LibraryInventory lib = new LibraryInventory();
    	
    	Customer customer1 = new Customer("Tomas Larsson", "073-683-3307");
    	Book book1 = new Book(12345, "Book", "Utvandrarna", 99, 573, "Vilhelm Moberg", customer1);
    	Book book2 = new Book(13370, "Book", "Historien om Titanic", 99, 45, "Francesca Baines");
    	Movie movie1 = new Movie(20202, "Movie", "Djungelboken", 169, 78, 7.6);
    	lib.addProduct(book1);
    	lib.addProduct(book2);
    	lib.addProduct(movie1);
    	
    	Scanner scanner = new Scanner(System.in);
    	while (true) {
		    String userInput = scanner.nextLine();
		    Command command = parseCommand(userInput);
		    String argument = parseArgument(userInput);
		    
		    if (command == Command.LIST) {
		    	System.out.println(lib.toString());
		    } else if (command == Command.CHECKOUT) {
		    	lib.borrowProduct(argument);
		    } else if (command == Command.CHECKIN) {
		    	lib.returnProduct(argument);
		    } else if (command == Command.REGISTER) {
		    	String type, title;
		    	int id, value;
		    	System.out.println("What are you registering? Book (b), Movie (m)");
		    	type = scanner.next().toLowerCase();
		    	System.out.println("Enter product ID:");
		    	id = scanner.nextInt();
		    	System.out.println("Enter title:");
		    	title = scanner.next();
		    	System.out.println("Enter value:");
		    	value = scanner.nextInt();
		    	
		    	if(!lib.isRegistered(id)) {
		    		if(type.equals("b")) {
		    			int pages;
			    		String publisher;
			    		System.out.println("Enter number of pages:");
			    		pages = scanner.nextInt();
			    		System.out.println("Enter publisher:");
			    		publisher = scanner.next();
		    			Book book = new Book(id, "Book", title, value, pages, publisher);
			    		lib.addProduct(book);
		    		} else if(type.equals("m")) {
		    			int length;
			    		double rating;
			    		System.out.println("Enter length:");
			    		length = scanner.nextInt();
			    		System.out.println("Enter rating:");
			    		rating = scanner.nextDouble();
			    		Movie movie = new Movie(id, "Movie", title, value, length, rating);
			    		lib.addProduct(movie);
		    		}
		    		System.out.println("Successfully registered " + title + "!");
		    	} else {
		    		System.out.println("Error: Product with ID " + id + " is already registered.");
		    	}
		    } else if (command == Command.DEREGISTER) {
		    	System.out.println(lib.deregister(argument));
		    } else if (command == Command.INFO) {
		    	System.out.println(lib.getInfo(argument));	
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
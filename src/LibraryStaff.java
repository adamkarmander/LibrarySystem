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
    
    public static String[] parseArguments(String userInput) {
        String[] commandPlusArguments = userInput.split(" ");
        String[] arguments = new String[commandPlusArguments.length - 1];
        for (int i = 1; i < commandPlusArguments.length; i++) {
            arguments[i - 1] = commandPlusArguments[i];
        }
        return arguments;
    }

    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	while (true) {
		    String userInput = scanner.nextLine();
		    Command command = parseCommand(userInput);
		    String[] arguments = parseArguments(userInput);
		    if (command == Command.LIST) {
		        
		    } else if (command == Command.CHECKOUT) {
		        
		    } else if (command == Command.CHECKIN) {
		        
		    } else if (command == Command.REGISTER) {
		    	
		    } else if (command == Command.DEREGISTER) {
		    	
		    } else if (command == Command.INFO) {
		    	
		    } else if (command == Command.LIST) {
		    	
		    } else if (command == Command.QUIT) {
		        System.out.println("The queue is now closed!");
		        scanner.close();
		        System.exit(0);
		    } else if(command == Command.UNKNOWN) {
		    	System.out.println("Unknown command. Try again.");
		    	continue;
		    }
    	}
    }
}
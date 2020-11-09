import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.csv.*;

public class LibraryStaff {

	enum Command {
		LIST, CHECKOUT, CHECKIN, REGISTER, DEREGISTER, INFO, QUIT, UNKNOWN
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
		if (userInput.contains(" ")) {
			String argument = userInput.split(" ")[1];
			return argument;
		}
		return "";
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		LibraryInventory lib = new LibraryInventory();
		// Collections.sort(lib, new SortProducts());

		String filePath = "library_csv.csv";
		File csvFile = new File(filePath);
		if (!csvFile.exists()) {
			// Creates a new CSV file
			try {
				FileWriter write = new FileWriter(csvFile);
				CSVPrinter print = new CSVPrinter(write, CSVFormat.DEFAULT);

				Customer customer = new Customer("Sture Karlsson", "073-953-6436");

				// Products to be added
				Book b1 = new Book(2345, "Book", "The Emigrants", 99, 573, "Vilhelm Moberg", customer);
				Book b2 = new Book(2346, "Book", "Story of the Titanic", 99, 45, "Francesca Baines");
				Movie m = new Movie(2347, "Movie", "The Jungle Book", 169, 78, 7.6);

				// Adding them to the library inventory
				lib.addProduct(b1);
				lib.addProduct(b2);
				lib.addProduct(m);

				// Printing them to the CSV file
				print.printRecord(b1.getArticleNumber(), b1.getProductType(), b1.getProductName(), b1.getProductValue(),
						b1.getPages(), b1.getAuthor(), customer.getName(), customer.getNumber());
				print.printRecord(b2.getArticleNumber(), b2.getProductType(), b2.getProductName(), b2.getProductValue(),
						b2.getPages(), b2.getAuthor());
				print.printRecord(m.getArticleNumber(), m.getProductType(), m.getProductName(), m.getProductValue(),
						m.getLength(), m.getRating());
				print.close();
			} catch (IOException e) {
				System.out.println("Caught an IOException.");
			}
		} else {
			// There is a CSV file already
			FileReader reader;
			try {
				reader = new FileReader(csvFile);
				Scanner filescanner = new Scanner(reader);

				while (filescanner.hasNextLine()) {
					// Scan the file and add its contents to the library inventory
					String csvRecord = filescanner.nextLine();
					String[] values = csvRecord.split(",");
					if (values[1].equals("Book")) {
						if (values.length == 8) {
							// If it's a borrowed Book
							Customer customer = new Customer(values[6], values[7]);
							Book book = new Book(Integer.valueOf(values[0]), values[1], values[2],
									Integer.valueOf(values[3]), Integer.valueOf(values[4]), values[5], customer);
							lib.addProduct(book);
						} else {
							// No one is borrowing the Book
							Book book = new Book(Integer.valueOf(values[0]), values[1], values[2],
									Integer.valueOf(values[3]), Integer.valueOf(values[4]), values[5]);
							lib.addProduct(book);
						}
					} else if (values[1].equals("Movie")) {
						// If it's a borrowed Movie
						if (values.length == 8) {
							Customer customer = new Customer(values[6], values[7]);
							Movie movie = new Movie(Integer.valueOf(values[0]), values[1], values[2],
									Integer.valueOf(values[3]), Integer.valueOf(values[4]), Double.valueOf(values[5]),
									customer);
							lib.addProduct(movie);
							// No one is borrowing the Movie
						} else {
							Movie movie = new Movie(Integer.valueOf(values[0]), values[1], values[2],
									Integer.valueOf(values[3]), Integer.valueOf(values[4]), Double.valueOf(values[5]));
							lib.addProduct(movie);
						}
					}
				}
				filescanner.close();
			} catch (FileNotFoundException e) {
				System.out.println("Error. File not found.");
			}
		}

		while (true) {
			System.out.println("Enter your command here:" + "\n");
			System.out.print("> ");
			String userInput = scanner.nextLine();
			Command command = parseCommand(userInput);

			if (command == Command.LIST) {
				System.out.println(lib.toString());
			} else if (command == Command.REGISTER) {
				lib.register(csvFile);
			} else if (command == Command.QUIT) {
				System.out.println("Goodbye!");
				scanner.close();
				System.exit(0);
			} else if (command == Command.UNKNOWN) {
				System.out.println("Unknown command. Try again.");
				continue;
			} else {
				String argument = parseArgument(userInput);
				if (!argument.equals("") && argument.matches(".*\\d.*")) {
					if (command == Command.CHECKOUT) {
						lib.borrowProduct(argument, csvFile);
					} else if (command == Command.CHECKIN) {
						lib.returnProduct(argument, csvFile);
					} else if (command == Command.DEREGISTER) {
						System.out.println(lib.deregister(argument, csvFile));
					} else if (command == Command.INFO) {
						System.out.println(lib.getInfo(argument));
					}
				} else {
					System.out.println("Syntax error. You must also add an articlenumber");
				}
			}
		}
	}
}
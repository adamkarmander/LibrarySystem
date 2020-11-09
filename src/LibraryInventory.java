
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
//import java.util.LinkedList;

public class LibraryInventory {
	Scanner scanner = new Scanner(System.in);

	ArrayList<Product> inventory = new ArrayList<Product>();
	// private List<Product> inventory;

	// public LibraryInventory() {
	// inventory = new ArrayList<Product>();
	// }

	public void save(File csvFile) {
		try {
			PrintWriter printWriter = new PrintWriter(csvFile);
			for (int i = 0; i < inventory.size(); i++) {
				Product p = inventory.get(i);

				int articleNumber = p.getArticleNumber();
				String productType = p.getProductType();
				String productName = p.getProductName();
				int productValue = p.getProductValue();

				if (p.getProductType() == "Book") {
					Book b = (Book) p;
					int pages = b.getPages();
					String author = b.getAuthor();

					if (b.borrowingCustomer != null) {
						// Someone is borrowing the Book
						String customerName = b.borrowingCustomer.getName();
						String customerNumber = b.borrowingCustomer.getNumber();
						printWriter.println(articleNumber + "," + productType + "," + productName + "," + productValue
								+ "," + pages + "," + author + "," + customerName + "," + customerNumber);
					} else {
						printWriter.println(articleNumber + "," + productType + "," + productName + "," + productValue
								+ "," + pages + "," + author);
					}
				} else if (p.getProductType() == "Movie") {
					Movie m = (Movie) p;
					int length = m.getLength();
					double rating = m.getRating();

					if (m.borrowingCustomer != null) {
						// Someone is borrowing the Movie
						String customerName = m.borrowingCustomer.getName();
						String customerNumber = m.borrowingCustomer.getNumber();
						printWriter.println(articleNumber + "," + productType + "," + productName + "," + productValue
								+ "," + length + "," + rating + "," + customerName + "," + customerNumber);
					} else {
						printWriter.println(articleNumber + "," + productType + "," + productName + "," + productValue
								+ "," + length + "," + rating);
					}
				}
			}
			printWriter.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error. File not found.");
		}
	}

	public void addProduct(Product product) {
		inventory.add(product);
		Collections.sort(inventory);
	}

	public void borrowProduct(String argument, File csvFile) {
		for (int i = 0; i < inventory.size(); i++) {
			Product p = inventory.get(i);
			if (String.valueOf(p.getArticleNumber()).equals(argument)) {
				if (p.borrowingCustomer != null) {
					// Cannot lend the product to someone because it's already borrowed
					System.out.println("Cannot borrow " + p.getProductName()
							+ " to another customer. It is already borrowed by " + p.borrowingCustomer.getName() + ".");
				} else {
					// The product can be borrowed
					String name;
					String phonenumber;

					System.out.println("Enter customer name:");
					name = scanner.nextLine();
					if (name.matches(".*[a-z].*") || (name.contains(" ") && name.matches(".*[a-z].*"))) {
						System.out.println("Enter customer phone number:");
						phonenumber = scanner.nextLine();
						if (phonenumber.matches(".*\\d.*") || ((phonenumber.contains(" ") || phonenumber.contains("-"))
								&& phonenumber.matches(".*\\d.*"))) {
							p.borrowingCustomer = new Customer(name, phonenumber);
							save(csvFile);
							System.out.println("Successfully borrowed" + p.getProductName() + " to " + name);
						} else {
							System.out.println("The phone number must contain numbers!");
							break;
						}
					} else {
						System.out.println("The name must contain alphabetical characters!");
						break;
					}
				}
			}
		}
	}

	public void returnProduct(String argument, File csvFile) {
		for (int i = 0; i < inventory.size(); i++) {
			Product p = inventory.get(i);
			if (String.valueOf(p.getArticleNumber()).equals(argument)) {
				if (p.borrowingCustomer != null) {
					// Return the borrowed product
					System.out.println(
							"Successfully returned " + p.getProductName() + " from " + p.borrowingCustomer.getName());
					p.borrowingCustomer = null;
					save(csvFile);
				} else {
					// No one is borrowing it, the product cannot be returned
					System.out.println("Cannot return " + p.getProductName() + ". It is not borrowed by any customer.");
				}
			}
		}
	}

	public String getInfo(String argument) {
		for (int i = 0; i < inventory.size(); i++) {
			Product p = inventory.get(i);
			if (String.valueOf(p.getArticleNumber()).equals(argument)) {
				if (p.getProductType() == "Book") {
					// Type casting so Book class methods can be used
					Book b = (Book) p;
					return "(" + b.getProductType() + ") " + b.getProductName() + ": Value " + b.getProductValue()
							+ "kr, Pages " + b.getPages() + ", Author " + b.getAuthor();
				} else if (p.getProductType() == "Movie") {
					// Type casting so Movie class methods can be used
					Movie m = (Movie) p;
					return "(" + m.getProductType() + ") " + m.getProductName() + ": Value " + m.getProductValue()
							+ "kr, Length " + m.getLength() + "m, Rating " + m.getRating();
				}
			}
		}
		return "Error: No product with id " + argument + " are registered.";
	}

	public boolean isRegistered(int id) {
		for (int i = 0; i < inventory.size(); i++) {
			Product p = inventory.get(i);
			if (p.getArticleNumber() == id) {
				// There is a book with that ID/article number
				return true;
			}
		}
		return false;

	}

	public void register(File csvFile) {
		String type, title, id, value;
		System.out.println("What are you registering? Book (b), Movie (m)");
		type = scanner.nextLine().toLowerCase();

		if (type.equals("b") || type.equals("m")) {
			System.out.println("Enter product ID:");
			id = scanner.nextLine();
			try {
				Integer.parseInt(id);
			} catch (NumberFormatException e) {
				System.out.println("Error. The ID has to consist of numbers!");
			}
			if (id.matches(".*\\d.*") && !id.contains(" ")) {
				System.out.println("Enter title:");
				title = scanner.nextLine();
				if (!title.equals("")) {
					System.out.println("Enter value:");
					value = scanner.nextLine();
					try {
						Integer.parseInt(value);
					} catch (NumberFormatException e) {
						System.out.println("Error. The value has to consist of numbers!");
					}
					if (value.matches(".*\\d.*") && !value.contains(" ")) {
						if (!isRegistered(Integer.valueOf(id))) {
							if (type.equals("b")) {
								String pages, publisher;
								System.out.println("Enter number of pages:");
								pages = scanner.nextLine();
								try {
									Integer.parseInt(pages);
								} catch (NumberFormatException e) {
									System.out.println("Error. The amount of pages has to consist of numbers!");
								}
								if (pages.matches(".*\\d.*") && !pages.contains(" ") && !pages.contains(",")) {
									System.out.println("Enter publisher:");
									publisher = scanner.nextLine();
									if (publisher.matches(".*[a-z].*")
											|| (publisher.contains(" ") && publisher.matches(".*[a-z].*"))) {
										Book book = new Book(Integer.valueOf(id), "Book", title, Integer.valueOf(value),
												Integer.valueOf(pages), publisher);
										addProduct(book);
										save(csvFile);
										System.out.println("Successfully registered " + title + "!");
									} else {
										System.out.println("Not a valid publisher name!");
									}
								}
							} else if (type.equals("m")) {
								String length, rating;
								System.out.println("Enter length:");
								length = scanner.nextLine();
								try {
									Integer.parseInt(length);
								} catch (NumberFormatException e) {
									System.out.println("Error. The length can only contain numbers!");
								}
								if (length.matches(".*\\d.*") && !length.contains(" ")) {
									System.out.println("Enter rating:");
									rating = scanner.nextLine();
									try {
										Double.parseDouble(rating);
										Movie movie = new Movie(Integer.valueOf(id), "Movie", title,
												Integer.valueOf(value), Integer.valueOf(length),
												Double.valueOf(rating));
										addProduct(movie);
										save(csvFile);
										System.out.println("Successfully registered " + title + "!");
									} catch (NumberFormatException e) {
										System.out.println("Error. The rating can only contain numbers!");
									}
								}
							}
						} else {
							System.out.println("Error: Product with ID " + id + " is already registered.");
						}
					}
				} else {
					System.out.println("That is not a valid title!");
				}
			}
		} else {
			System.out.println("You need to enter b for Book or m for Movie!");
		}
	}

	public String deregister(String argument, File csvFile) {
		for (int i = 0; i < inventory.size(); i++) {
			Product p = inventory.get(i);
			if (String.valueOf(p.getArticleNumber()).equals(argument)) {
				// Removes the product with that ID from the list
				inventory.remove(p);
				save(csvFile);
				return "Successfully deregistered " + p.getProductName();
			}
		}
		return "Error: There is no registered product with ID " + argument;
	}

	@Override
	public String toString() {
		String productsToPrintOut = "";
		for (int i = 0; i < inventory.size(); i++) {
			Product p = inventory.get(i);
			// Adds all the products in the list so they can be printed out
			productsToPrintOut = productsToPrintOut + p.toString();
		}
		return productsToPrintOut;
	}
	/*
	 * public class LibraryInventory<E> implements AddProducts<E> {
	 * 
	 * private List<E> inventory; private String productPath; // Lagrar sökväg till
	 * csv-filen
	 * 
	 * inventory=new LinkedList<E>();
	 * 
	 * private List<E> parseProducts(String productPath) throws
	 * FileNotFoundException { this.productPath = productPath; inventory =
	 * parseProducts(productPath); // Hur parsea produkterna ? FileReader reading =
	 * new FileReader(productPath); Scanner sc = new Scanner(reading); sc.close(); }
	 * 
	 * private void writeProducts() { // Uppdaterar csv-filen med de nuvarande
	 * produkterna try { PrintWriter printer = new PrintWriter(productPath);
	 * 
	 * for (E addProduct : inventory) { String csvRec = addProduct.bookCsvRec(); //
	 * Hur få ut csvrecord från både book och movie printer.println(csvRec); //
	 * Skriver ned csvrecord } printer.close(); } catch (FileNotFoundException e) {
	 * e.printStackTrace(); } }
	 * 
	 * @Override public void addProduct(E Book) { inventory.add(Book);
	 * writeProducts();
	 * 
	 * }
	 * 
	 * @Override public void addProduct2(E Movie) {
	 * 
	 * inventory.add(Movie); writeProducts();
	 * 
	 * }
	 */
}
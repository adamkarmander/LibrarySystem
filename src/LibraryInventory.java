//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//import java.util.LinkedList;

public class LibraryInventory {
	Scanner scanner = new Scanner(System.in);
	
	private List<Product> inventory;
	
	public LibraryInventory() {
		inventory = new ArrayList<Product>();
	}
	
	public void addProduct(Product product) {
		inventory.add(product);
	}
	
	public void borrowProduct(String argument) {
		for(int i = 0; i < inventory.size(); i++) {
			Product p = inventory.get(i);
			if(String.valueOf(p.getArticleNumber()).equals(argument)) {
				if(p.borrowingCustomer != null) {
					//Cannot lend the product to someone because it's already borrowed
					System.out.println("Cannot lend " + p.getProductName() + " to another customer. It is already borrowed by " + p.borrowingCustomer.getName() + ".");
				} else {
					//The product can be borrowed
					String name;
					String phonenumber;
					
					System.out.println("Enter customer name:");
			        name = scanner.next();
			        System.out.println("Enter customer phone number:");
			        phonenumber = scanner.next();
			        p.borrowingCustomer = new Customer(name, phonenumber);
			        System.out.println("Successfully lended " + p.getProductName() + " to " + name);
				}
			}
		}
	}
	
	public void returnProduct(String argument) {
		for(int i = 0; i < inventory.size(); i++) {
			Product p = inventory.get(i);
			if(String.valueOf(p.getArticleNumber()).equals(argument)) {
				if(p.borrowingCustomer != null) {
					//Return the borrowed product
					System.out.println("Successfully returned " + p.getProductName() + " from " + p.borrowingCustomer.getName());
					p.borrowingCustomer = null;
				} else {
					//No one is borrowing it, the product cannot be returned
					System.out.println("Cannot return " + p.getProductName() + ". It is not borrowed by any customer.");
				}
			}
		}
	}
	
	public String getInfo(String argument) {
		for(int i = 0; i < inventory.size(); i++) {
			Product p = inventory.get(i);
			if(String.valueOf(p.getArticleNumber()).equals(argument)) {
				if(p.getProductType() == "Book") {
					//Type casting so Book class methods can be used
					Book b = (Book)p;
					return "(" + b.getProductType() + ") "+ b.getProductName() + ": Value " + b.getProductValue() + "kr, Pages " + b.getPages() + ", Author " + b.getAuthor();
				}
				else if(p.getProductType() == "Movie") {
					//Type casting so Movie class methods can be used
					Movie m = (Movie)p;
					return "(" + m.getProductType() + ") " + m.getProductName() + ": Value " + m.getProductValue() + "kr, Length " + m.getLength() + "m, Rating " + m.getRating();
				}
			}
		}
		return "Error: No product with id " + argument + " registered.";
	}
	
	public boolean isRegistered(int id) {
		for(int i = 0; i < inventory.size(); i++) {
			Product p = inventory.get(i);
			if(p.getArticleNumber() == id) {
				//There is a book with that ID/article number
				return true;
			}
		}
		return false;
	}
	
	public String deregister(String argument) {
		for(int i = 0; i < inventory.size(); i++) {
			Product p = inventory.get(i);
			if(String.valueOf(p.getArticleNumber()).equals(argument)) {
				//Removes the product with that ID from the list
				inventory.remove(p);
				return "Successfully deregistered " + p.getProductName();
			}
		}
		return "Error: There is no registered product with ID " + argument;
	}
	
	@Override
	public String toString() {
		String productsToPrintOut = "";
		for(int i = 0; i < inventory.size(); i++) {
			Product p = inventory.get(i);
			//Adds all the products in the list so they can be printed out
			productsToPrintOut = productsToPrintOut + p.toString();
		}
		return productsToPrintOut;
	}
/*public class LibraryInventory<E> implements AddProducts<E> {

	private List<E> inventory;
	private String productPath; // Lagrar sökväg till csv-filen

	inventory=new LinkedList<E>();

	private List<E> parseProducts(String productPath) throws FileNotFoundException {
		this.productPath = productPath;
		inventory = parseProducts(productPath); // Hur parsea produkterna ?
		FileReader reading = new FileReader(productPath);
		Scanner sc = new Scanner(reading);
		sc.close();
	}

	private void writeProducts() { // Uppdaterar csv-filen med de nuvarande produkterna
		try {
			PrintWriter printer = new PrintWriter(productPath);

			for (E addProduct : inventory) {
				String csvRec = addProduct.bookCsvRec(); // Hur få ut csvrecord från både book och movie
				printer.println(csvRec); // Skriver ned csvrecord
			}
			printer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addProduct(E Book) {
		inventory.add(Book);
		writeProducts();

	}

	@Override
	public void addProduct2(E Movie) {

		inventory.add(Movie);
		writeProducts();

	}
	*/
}
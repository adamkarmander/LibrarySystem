<<<<<<< Updated upstream
import java.util.LinkedList;

public class LibraryInventory implements AddProducts<Product> {
	LinkedList<Product> list = new LinkedList<Product>();
	
	public LibraryInventory(String /*Filen där prdoukterna finns */)throws FileNotFoundException{
		this./*Filen där produkterna finns */=;
		products= parseMovies(/*Filnamnet */);
	}

	@Override
	public void add(Product product) {
		list.add(product);
		writeInventory();
	}
=======
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class LibraryInventory<E> implements AddProducts<E> {

	private List<E> inventory;
	private String productPath; // Lagrar sökväg till csv-filen

	inventory=new LinkedList<E>();

	public LibraryInventory(String productPath) throws FileNotFoundException {
		this.productPath = productPath;
		productPath = parseMovies(productPath); // Hur parsea ? Även parsea i LibraryStaff?
		FileReader reading = new FileReader(productPath);
		Scanner sc = new Scanner(reading);

	}sc.close();

	private void writeProducts() { // Uppdaterar csv-filen med de nuvarande produkterna
		try {
			PrintWriter printer = new PrintWriter(productPath);

			for (E add1 : inventory) {
				String csvRec = add1.productCsvRec(); // Hur få ut csvrecord från tex klassen products CsvRec metod?
				printer.println(csvRec); // Skriver ned csvrecord

			}
			printer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void add1(E element) {
		inventory.add(movie);
		writeInventory();

	}// Hur lägga till produkterna?

	@Override
	public void add2(E element) {
		inventory.add(book);
		writeInventory();

	}

>>>>>>> Stashed changes
}

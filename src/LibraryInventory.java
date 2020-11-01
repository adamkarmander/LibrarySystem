
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import java.util.LinkedList;

public class LibraryInventory<E> implements AddProducts<E> {

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

}

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
}

public class LibraryInventory implements AddProducts<Products> {

	public LibraryInventory(String /*Filen där prdoukterna finns */)throws FileNotFoundException{
		this./*Filen där produkterna finns */=;
		products= parseMovies(/*Filnamnet */);
		
	}

	private List<Products>inventory;

	inventory=new LinkedList<Products>();

	@Override
	public static void add(Products movie) {
		inventory.add(movie);
		writeInventory();
	}

	@Override
	public static void add(Products book) {
		inventory.add(book);
		writeInventory();
	}

}

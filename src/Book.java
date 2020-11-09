public class Book extends Product {
	private int pages;
	private String author;

	public Book(int articleNumber, String productType, String productName, int productValue, int pages, String author) {
		super(articleNumber, productType, productName, productValue);
		this.pages = pages;
		this.author = author;
	}

	public Book(int articleNumber, String productType, String productName, int productValue, int pages, String author, Customer borrowingCustomer) {
		super(articleNumber, productType, productName, productValue, borrowingCustomer);
		this.pages = pages;
		this.author = author;
	}

	public int getPages() {
		return pages;
	}

	public String getAuthor() {
		return author;
	}
}
public class Book extends Product {
	private int pages;
	private String author;

	public Book(int articleNumber, String productName, int productValue, int pages, String author) {
		super(articleNumber, productName, productValue);
		this.pages = pages;
		this.author = author;
	}

	public int getPages() {
		return pages;
	}

	public String getAuthor() {
		return author;
	}

	public String bookCsvRec() {
		return String.format("%d, %s", pages, author);
	}

	public String bookToString() {
		return String.format("%d  %s.");
	}
}
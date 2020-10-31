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

	@Override
	public String productCsvRec() {
		super.productCsvRec();
		return productCsvRec();
	}// Såhär vi får tag på metoden productCsvRec?

	public String productToString() {
		super.productToString();
		return productToString();
	}// Såhär vi får tag på metoden ProducToString?

	public String bookCsvRec() {
		return String.format("%d, %s", pages, author);

	}// Hur skriva regex för int?

	public String bookToString() {
		return String.format("%d  %s.");
	}
}
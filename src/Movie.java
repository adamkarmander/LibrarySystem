public class Movie extends Product {
	private int length;
	private float rating;

	public Movie(int articleNumber, String productName, int productValue, int length, float rating) {
		super(articleNumber, productName, productValue);
		this.length = length;
		this.rating = rating;
	}

	public int getLength() {
		return length;
	}

	public float getRating() {
		return rating;
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

	public String movieCsvRec() {
		return String.format("%d, %.2f", length, rating);
	}// Hur skriva regex för int?

	public String movieToString() {
		return String.format("%d  %.2f");
	}
}
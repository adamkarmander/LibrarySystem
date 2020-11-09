public class Movie extends Product {
	private int length;
	private double rating;

	public Movie(int articleNumber, String productType, String productName, int productValue, int length,
			double rating) {
		super(articleNumber, productType, productName, productValue);
		this.length = length;
		this.rating = rating;
	}

	public Movie(int articleNumber, String productType, String productName, int productValue, int length, double rating,
			Customer borrowingCustomer) {
		super(articleNumber, productType, productName, productValue, borrowingCustomer);
		this.length = length;
		this.rating = rating;
	}

	public int getLength() {
		return length;
	}

	public double getRating() {
		return rating;
	}

	/*
	 * @Override public String productCsvRec() { super.productCsvRec(); return
	 * productCsvRec(); }// Såhär vi får tag på metoden productCsvRec?
	 * 
	 * public String productToString() { super.productToString(); return
	 * productToString(); }// Såhär vi får tag på metoden ProducToString?
	 * 
	 * public String movieCsvRec() { return String.format("%d, %.2f", length,
	 * rating); }// Hur skriva regex för int?
	 * 
	 * public String movieToString() { return String.format("%d  %.2f"); }
	 */
}
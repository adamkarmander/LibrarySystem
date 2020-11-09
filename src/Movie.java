public class Movie extends Product {
	private int length;
	private double rating;

	public Movie(int articleNumber, String productType, String productName, int productValue, int length, double rating) {
		super(articleNumber, productType, productName, productValue);
		this.length = length;
		this.rating = rating;
	}

	public Movie(int articleNumber, String productType, String productName, int productValue, int length, double rating, Customer borrowingCustomer) {
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
}
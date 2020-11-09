public class Product implements Comparable<Product> {
	protected int articleNumber;
	protected String productType;
	protected String productName;
	protected int productValue;
	protected Customer borrowingCustomer;

	public Product(int articleNumber, String productType, String productName, int productValue) {
		this.articleNumber = articleNumber;
		this.productType = productType;
		this.productName = productName;
		this.productValue = productValue;
	}

	public Product(int articleNumber, String productType, String productName, int productValue, Customer borrowingCustomer) {
		this.articleNumber = articleNumber;
		this.productType = productType;
		this.productName = productName;
		this.productValue = productValue;
		this.borrowingCustomer = borrowingCustomer;
	}

	public Integer getArticleNumber() {
		return articleNumber;
	}

	public void setArticleNumber(int newArticleNumber) {
		articleNumber = newArticleNumber;
	}

	public String getProductType() {
		return productType;
	}

	public String getProductName() {
		return productName;
	}

	public int getProductValue() {
		return productValue;
	}

	@Override
	public String toString() {
		if (borrowingCustomer == null) {
			// If no one is borrowing this product, it's in stock:
			return articleNumber + " (" + productType + "): " + productName + ". (in stock)\n";
		}
		// Prints product information and name and number of customer borrowing it
		return articleNumber + " (" + productType + "): " + productName + ".\n   lent by: "
				+ borrowingCustomer.getName() + ", " + borrowingCustomer.getNumber() + "\n";
	}

	@Override
	public int compareTo(Product p) {
		return this.getArticleNumber().compareTo(p.getArticleNumber());
	}
}
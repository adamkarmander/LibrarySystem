import java.util.Comparator;

public class Product {
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

	public Product(int articleNumber, String productType, String productName, int productValue,
			Customer borrowingCustomer) {
		this.articleNumber = articleNumber;
		this.productType = productType;
		this.productName = productName;
		this.productValue = productValue;
		this.borrowingCustomer = borrowingCustomer;

		class SortProducts implements Comparator<Product> {

			@Override
			public int compare(Product articleNumber1, Product articleNumber2) {
				// articleNumber sorteras här i stigande ordning

				return articleNumber1.articleNumber - articleNumber2.articleNumber;
			}
			/*
			 * Ha med denna text i Main-metoden innan arrayen printas ut?
			 * 
			 * Collections.sort(inventory, new SortProducts());
			 * 
			 */

		}

	}

	public int getArticleNumber() {
		return articleNumber;
	}

	public void setArticleNumber(int newArticleNumber) {
		articleNumber = newArticleNumber;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String newProductType) {
		productType = newProductType;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String newProductName) {
		productName = newProductName;
	}

	public int getProductValue() {
		return productValue;
	}

	public void setProductValue(int newProductValue) {
		productValue = newProductValue;
	}

	@Override
	public String toString() {
		if (borrowingCustomer == null) {
			// If no one is borrowing this product, it's in stock:
			return articleNumber + " (" + productType + "): " + productName + ". (in stock)\n";
		}
		// Prints product information and name and number of customer borrowing it
		return articleNumber + " (" + productType + "): " + productName + ".\n    Borrowed by: "
				+ borrowingCustomer.getName() + ", " + borrowingCustomer.getNumber() + "\n";
	}
	/*
	 * public String productCsvRec() { return String.format("%d, %s,%s",
	 * articleNumber, productType, productName); } // Vilken regex för int?
	 * 
	 * public static String getProductHeader() {// Vill ha header? return
	 * "articlenumber, type, name"; }
	 * 
	 * public static void parseProducts(String csvRec) { // Behövs metoden?
	 * csvRec.split(", "); }
	 * 
	 * public String productToString() { return String.format("%d [%s]: %s.");
	 * 
	 * }
	 */
}
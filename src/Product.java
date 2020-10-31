public class Product {
	protected int articleNumber;
	protected String productType;
	protected String productName;
	protected int productValue;

	public Product(int articleNumber, String productName, int productValue) {
		this.articleNumber = articleNumber;
		this.productType = productType;
		this.productName = productName;
		this.productValue = productValue; // Ska endast synas vid användandet av kommandot "register"
	}

	public int getArticleNumber() {
		return articleNumber;
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

	public String productCsvRec() {
		return String.format("%d, %s,%s", articleNumber, productType, productName);
	} // Vilken regex för int?

	public static String getProductHeader() {// Vill ha header?
		return "articlenumber, type, name";
	}

	public static void parseProducts(String csvRec) { // Behövs metoden?
		csvRec.split(", ");
	}

	public String productToString() {
		return String.format("%d [%s]: %s.");

	}
}
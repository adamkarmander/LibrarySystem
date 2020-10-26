public class Product {
	private int articleNumber;
	private String productType;
	private String productName;
	private int productValue;

	public Product(int articleNumber, String productName, int productValue) {
		this.articleNumber = articleNumber;
		this.productType = productType;
		this.productName = productName;
		// this.productValue = productValue; // Ska endast synas vid kommando register
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

	public String productCsvRec() {
		return String.format("%d, %s,%s", articleNumber, productType, productName);
	}

	public static String getProductHeader() {// Vad gör metoden?
		return "articlenumber, type, name";
	}

	public static Products parseProducts(String csvRec) { // Behövs metoden?
		csvRec.split(", ");
	}

	public String ProductToString() {
		return String.format("%d [%s]: %s.");

	}
}
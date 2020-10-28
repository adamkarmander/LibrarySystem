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

	public String productCsvRec() { // Hur få in denna metod i book och movie?
		return String.format("%d, %s,%s", articleNumber, productType, productName);
	} // Vilken regex för int?

	public static String getProductHeader() {// Vill ha header?
		return "articlenumber, type, name";
	}

	public static Products parseProducts(String csvRec) { // Behövs metoden?
		csvRec.split(", ");
	}

	public String ProductToString() {
		return String.format("%d [%s]: %s.");

	}
}
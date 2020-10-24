public class Product {
	private int articleNumber;
	private String productName;
	private int productValue;
	
	public Product(int articleNumber, String productName, int productValue) {
		this.articleNumber = articleNumber;
		this.productName = productName;
		this.productValue = productValue;
	}
	
	public int getArticleNumber() {
		return articleNumber;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public int getProductValue() {
		return productValue;
	}
}
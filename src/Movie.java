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
}
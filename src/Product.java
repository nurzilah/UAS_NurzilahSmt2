public class Product {
    private String Title;
    private double price;
    private double rating;

    public Product(String Title, double price, double rating) {
        this.Title = Title;
        this.price = price;
        this.rating = rating;
    }

    public double getRating() {
        return rating;
    }

    public String toString() {

            return "Product: " + Title + ", Price: $" + price + ", Rating: " + rating;
    }
}



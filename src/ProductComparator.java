import java.util.Comparator;

public class ProductComparator implements Comparator<Product> {
    public int compare(Product p1, Product p2) {
        if (p1.getRating() < p2.getRating()) {
            return -1;
        } else if (p1.getRating() > p2.getRating()) {
            return 1;
        } else {
            return 0;
        }
    }
}

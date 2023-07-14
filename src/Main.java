import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String url = "https://dummyjson.com/products";
        String consId = "1234567";
        String userKey = "faY738sH";

        try {
            List<Product> products = fetchDataFromURL(url, consId, userKey);
            selectionSort(products);
            displayProducts(products);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Product> fetchDataFromURL(String url, String consId, String userKey) throws IOException {
        List<Product> products = new ArrayList<>();

        URL apiUrl = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
        connection.setRequestProperty("X-Cons_ID", consId);
        connection.setRequestProperty("user_key", userKey);
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Parsing JSON manually
            String json = response.toString();
            // Parse JSON and extract products data, populate the products list
            // ...

            // Dummy data for demonstration
            products.add(new Product("Product 1", 10.0, 3.5));
            products.add(new Product("Product 2", 20.0, 4.2));
            products.add(new Product("Product 3", 15.0, 4.9));
        }

        connection.disconnect();

        return products;
    }

    private static void selectionSort(List<Product> products) {
        int n = products.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (products.get(j).getRating() < products.get(minIndex).getRating()) {
                    minIndex = j;
                }
            }
            Collections.swap(products, i, minIndex);
        }
    }

    private static void displayProducts(List<Product> products) {
        for (Product product : products) {
            System.out.println(product);
        }
    }
}

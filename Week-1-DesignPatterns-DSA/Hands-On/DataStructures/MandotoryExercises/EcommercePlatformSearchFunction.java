class Product {

    int productId;
    String productName;
    String category;

    Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    void display() {
        System.out.println(productId + " " + productName + " " + category);
    }
}

class LinearSearch {

    public static Product search(Product[] products, int id) {

        for (Product product : products) {

            if (product.productId == id) {
                return product;
            }
        }

        return null;
    }
}

class BinarySearch {

    public static Product search(Product[] products, int id) {

        int low = 0;
        int high = products.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (products[mid].productId == id)
                return products[mid];

            else if (products[mid].productId < id)
                low = mid + 1;

            else
                high = mid - 1;
        }

        return null;
    }
}

public class Main {

    public static void main(String[] args) {

        Product[] products = {

                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Mouse", "Electronics"),
                new Product(103, "Keyboard", "Electronics"),
                new Product(104, "Shoes", "Fashion"),
                new Product(105, "Watch", "Accessories")
        };

        System.out.println("Linear Search");

        Product p1 = LinearSearch.search(products, 104);

        if (p1 != null)
            p1.display();
        else
            System.out.println("Product not found");

        System.out.println();

        System.out.println("Binary Search");

        Product p2 = BinarySearch.search(products, 104);

        if (p2 != null)
            p2.display();
        else
            System.out.println("Product not found");
    }
}

// Which algorithm is more suitable for an e-commerce platform?
// Binary Search is more suitable because:
// E-commerce platforms contain thousands or millions of products.
// Products can be stored in sorted order based on productId.
// Binary Search significantly reduces the number of comparisons.
// It provides much faster search performance than Linear Search for large datasets.
// However, if the products are not sorted or change frequently (many insertions/deletions), Linear Search may be used in simple scenarios, though databases and search engines typically use more advanced indexing structures (such as B-trees or hash-based indexes) instead of either algorithm.







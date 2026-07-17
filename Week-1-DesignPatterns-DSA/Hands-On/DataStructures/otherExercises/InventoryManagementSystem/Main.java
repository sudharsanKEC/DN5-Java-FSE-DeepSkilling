import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Map<Integer, Product> products = new HashMap<>();
        int choice;
        do{
            System.out.println("Enter 1 to add products.");
            System.out.println("Enter 2 to update products.");
            System.out.println("Enter 3 to delete products.");
            System.out.println("Enter 4 to delete all products.");
            System.out.println("Enter 5 to display all products.");
            System.out.println("Enter 6 to end operations.");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch(choice){
                case 1:{
                    System.out.print("Enter the product name: ");
                    sc.nextLine();
                    String productName = sc.nextLine();
                    System.out.print("Enter the quantity: ");
                    int quantity = sc.nextInt();
                    System.out.print("Enter the price: ");
                    double price = sc.nextDouble();
                    Product product = Product.createProduct(productName, quantity, price);
                    products.put(product.getProductId(),product);
                    System.out.println("Product added: "+product.toString());
                    break;
                }
                case 2:{
                    System.out.println("Enter product id to update:");
                    int productId = sc.nextInt();
                    if(!products.containsKey(productId)){
                        System.out.println("Invalid ID");
                        break;
                    }
                    Product product = products.get(productId);
                    System.out.println("Enter the new value for product quantity or -1 to skip: ");
                    int quantity = sc.nextInt();
                    if(quantity!=-1 && quantity>=0){
                        product.setQuantity(quantity);
                    }
                    
                    System.out.println("Enter the new value for product price or -1 to skip: ");
                    int price = sc.nextInt();
                    if(price!=-1 && price>=0){
                        product.setPrice(price);
                    }
                    System.out.println("Product updated successfully");
                    break;
                }
                case 3:{
                    System.out.println("Enter the id to delete the product: ");
                    int productId = sc.nextInt();
                    if(!products.containsKey(productId)){
                        System.out.println("Invalid productId");
                        break;
                    }
                    products.remove(productId);
                    break;
                }
                case 4:{
                    if(products.isEmpty()){
                        System.out.println("No products exists in inventory.");
                        break;
                    }
                    System.out.println("Deleting all the products...");
                    products.clear();
                    System.out.println("Deleted successfully.");
                    break;
                }
                case 5:{
                    if(products.isEmpty()){
                        System.out.println("No product available to display.");
                        break;
                    }
                    for(Integer productId : products.keySet()){
                        System.out.println(products.get(productId).toString());
                    }
                    System.out.println("Display finished.");
                }
                default:{
                    System.out.println("Enter a valid choice.");
                }
            }
            

        }while(choice!=6);
    }
}

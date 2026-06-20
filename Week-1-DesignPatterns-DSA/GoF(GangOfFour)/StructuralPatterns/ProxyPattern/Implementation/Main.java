public class Main {
    public static void main(String[] args) {
        Image image = new ProxyImage("profile.jpg");
        System.out.println("Proxy created");
        image.display();
        image.display();
    }    
}

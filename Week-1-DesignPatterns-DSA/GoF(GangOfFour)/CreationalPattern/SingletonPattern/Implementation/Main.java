public class Main {
    public static void main(String[] args) {
        // Eager initialization
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();
        System.out.println("The object initialized using eager initialization: "+obj1.toString());
        System.out.println("obj1 == obj2: "+(obj1 == obj2)); // true

        // Normal initialization
        Singleton2 obj3 = Singleton2.getInstance();
        Singleton2 obj4 = Singleton2.getInstance();
        System.out.println("The object initialized using normal singleton approach: "+obj3.toString());
        System.out.println("obj3 == obj4: "+(obj3 == obj4)); // true

    }
}

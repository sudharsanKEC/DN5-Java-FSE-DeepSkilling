class Singleton{
    
    private static final Singleton singletonInstance = new Singleton();
    private Singleton(){};
    public static Singleton getInstance(){
        return singletonInstance;
    }


}
public class Main{
    public static void main(String[] args){
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();
 
        System.out.println("Both objects are same: "+(obj1 == obj2));
    }
}

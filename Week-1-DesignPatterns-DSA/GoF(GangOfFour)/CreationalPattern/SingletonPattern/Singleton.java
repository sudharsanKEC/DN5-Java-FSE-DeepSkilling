// The below approach is called Eager Initialization
// Object is created immediately when the class loads.
//     Advantages:
//         Simple
//         Thread-safe
//         Most interviewers like this explanation
//     Disadvantage:
//         Object is created even if never used.
class Singleton{
    private static final Singleton INSTANCE = new Singleton();
    private Singleton(){}
    public static Singleton getInstance(){
        return INSTANCE;
    }
}

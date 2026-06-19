public class Main{
    public static void main(String[] args) {
        User user1 = new User.Builder().username("sudharsan").build(); // build the Object only passing the name.
        // If we want to do the same with constructor, then it would be like: User("sudharsan",null,null,null);
        // The constructor telescope is not a good approach.
        System.out.println("User1: ");
        System.out.println(user1.getUsername());
        System.out.println();

        // Now building the object with passing all the values.
        User user2 = new User.Builder().username("sancoder").bio("I am a coder").email("sancoder@gmail.com").location("Coimbatore").build();
        System.out.println("User2:");
        System.out.println(user2.getUsername());
        System.out.println(user2.getEmail());
        System.out.println(user2.getBio());
        System.out.println(user2.getLocation());

    }
}

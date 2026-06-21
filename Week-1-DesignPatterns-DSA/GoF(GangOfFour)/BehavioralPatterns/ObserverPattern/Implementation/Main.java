public class Main {
    public static void main(String[] args) {
        
        YouTubeChannel channel = new YouTubeChannel();
        
        Observer user1 = new MobileUser("Sudharsan");
        
        Observer user2 = new EmailUser("john@gmail.com");

        Observer user3 = new MobileUser("Alex");

        channel.addObserver(user1);
        channel.addObserver(user2);
        channel.addObserver(user3);

        channel.uploadVideo("Observer Pattern Explained");
    }    
}

public class Main {
    public static void main(String[] args) {
        NotificationCreator creator;
        creator = new EmailNotificationCreator();
        creator.notifyUser();

        creator = new SmsNotificationCreator();
        creator.notifyUser();
    }    
}

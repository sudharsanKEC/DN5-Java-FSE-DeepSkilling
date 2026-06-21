public class EmailUser implements Observer{
    
    private String email;

    public EmailUser(String email){
        this.email = email;
    }

    public void update(String message){
        System.out.println(email+" received email: "+message);
    }
}

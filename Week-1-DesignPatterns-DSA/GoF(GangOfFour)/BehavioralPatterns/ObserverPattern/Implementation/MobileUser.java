public class MobileUser implements Observer{

    private String name;

    public MobileUser(String name){
        this.name = name;
    }

    public void update(String message){
        System.out.println(name+" recieved mobile notification: "+message);
    }

}

public class Main {
    public static void main(String[] args) {
        
        Light light = new Light();

        Command command = new TurnOnLightCommand(light);

        RemoteControl remote = new RemoteControl(command);

        remote.pressButton();

        command = new TurnOffLightCommand(light);
        remote = new RemoteControl(command);

        remote.pressButton();
    }    
}

import java.util.*;
interface Command{
    void execute();
}
// Concrete Command to turn on light
class LightOnCommand implements Command{
    private Light light;
    public LightOnCommand(Light light){
        this.light = light;
    }
    @Override
    public void execute(){
        light.turnOn();
    }
}
// Concrete Command to turn off light
class LightOffCommand implements Command{
    private Light light;
    public LightOffCommand(Light light){
        this.light = light;
    }
    @Override
    public void execute(){
        light.turnOff();
    }
}
//Implementing Invoker Class
class RemoteControl{
    private Command command;
    public void setCommand(Command command){
        this.command = command;
    }
    public void pressButton(){
        command.execute();
    }
}
//Implementing Receiver Class
class Light{
    public void turnOn(){
        System.out.println("The light is on");
    }
    public void turnOff(){
        System.out.println("The light is off");
    }
}

public class CommandDesignExample{
    public static void main(String[] args){
        Light livingRoomLight = new Light();

        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);

        RemoteControl remote = new RemoteControl();
        
        remote.setCommand(lightOn);
        remote.pressButton(); 

        remote.setCommand(lightOff);
        remote.pressButton();
    }
}
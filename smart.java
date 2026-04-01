abstract class SmartDevice{
    abstract void turnOn(); // abstract method without body
    abstract void turnOff();   
    void deviceInfo(){ // regular method with body
        System.out.println("This is a smart device");
    } 
}

class light extends SmartDevice{ // child class that extends the abstract class
    @Override
    void turnOn(){
        System.out.println("Light is turned on");
    }
    @Override
    void turnOff(){
        System.out.println("Light is turned off");
    }
}
abstract class setlvl{
    abstract void setLevel(); // abstract method without body
}
interface Remote{ // interface with abstract method
    void change();
} 

interface wifiControl{ // interface with abstract method
    void connnect();
}

class TV implements Remote, wifiControl{ // class that implements the interface
    @Override
    public void change(){
        System.out.println("Changing TV channel");
    }
    @Override
    public void connnect(){
        System.out.println("Connecting to WiFi");
    }

}
public class smart{
    public static void main(String[] args) {
        SmartDevice device = new light(); // creating an object of the child class
        device.turnOn(); // calling the method to turn on the light
        device.deviceInfo(); // calling the method to display device info
        TV tv = new TV(); // creating an object of the TV class
        tv.change(); // calling the method to change TV channel
        tv.connnect(); // calling the method to connect to WiFi

    
    }
}

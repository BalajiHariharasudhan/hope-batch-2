class Battery{ //parent class
    public void powesupply(){ //method of the parent class
        System.out.println("still have 40% power");
    }
}
class Remote{ // child class
    Battery miniBattery = new Battery(); //obj of the parent class in child class and has a relationship
    Remote(){
        miniBattery = new Battery();
    }
    public void changeChannel(){ //method of the child class
        miniBattery.powesupply();// calling the method -> parent class method in child class method
        System.out.println("Channel changed");
    }
    public void changeVolume(){
        System.out.println("volume increased");
    }
}
class tv{
    Remote tvRemote;
    tv(Remote tvRemote){
        this.tvRemote = tvRemote;
    }
    public void increaseVolume(){
        tvRemote.changeVolume();
    }
}
public class relationship {
    public static void main(String[] args) {
        Remote tvremote = new Remote(); //obj of the child class
        tvremote.changeChannel();// calling the method of the child class
    }
}

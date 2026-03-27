import java.util.*;
class Notification{
    String name;
    String message;
    Notification(String name,String message)
    {
        this .name=name;
        this.message=message;
    }
    void send()
    {
        System.out.println("Sending Notification from parent");
    }

}
class EmailNotification extends Notification{
    EmailNotification(String name, String message)
    {
        super(name,message);
    }
    void send()
    {
        System.out.println("Sending Email to "+name);
        System.out.println("Sending Email to "+message);

    }
    void changeReceiverEmail(){}
}
class SMSNotifiation extends Notification{
    
    SMSNotifiation(String name, String message) {
        super(name, message);
        
    }
    void send()
    {
        System.out.println("Sending SMS to "+name);
        System.out.println("Sending SMS to "+message);
    }
}
public class Notify{
    public static void main(String[] args)
    {
        Notification n;
        n=new EmailNotification("test","order confirmed");
        n.send();
        n=new SMSNotifiation("test","order confirmed");
        n.send();

    }

}

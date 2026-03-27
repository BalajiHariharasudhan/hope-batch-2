import java.util.*;
class Users{
    String name;
    String email;
    String address;
    String phoneNumber;
    Users(String name,String email, String address, String phoneNumber){
        {
            this.name=name;
            this.email=email;
            this.address=address;
            this.phoneNumber=phoneNumber;
        }
    }
    void DisplayUser(){
        System.out.println("Name: "+name);
        System.out.println("Email: "+email);
        System.out.println("Address: "+address);
        System.out.println("Phone Number: "+phoneNumber);
        System.err.println("-----------------------------");
    }
        
}
class RideUser extends Users{
    String VehicleType;
    RideUser(String name,String email, String address, String phoneNumber, String VehicleType){
        super(name,email,address,phoneNumber);
        this.VehicleType=VehicleType;
    }
    void DisplayRide(){
        System.out.println("Vehicle Type: "+VehicleType);
        System.out.println("name: "+name);
        System.out.println("email: "+email);
        System.out.println("address: "+address);
        System.out.println("phoneNumber: "+phoneNumber);
        System.err.println("-----------------------------");

    }
}
class FoodUser extends Users{
    String food;
    FoodUser(String name,String email, String address, String phoneNumber, String food){
        super(name,email,address,phoneNumber);
        this.food=food;
    }
    void Display_Fav_Food(){
        System.out.println("Favorite Food: "+food);
        System.err.println("-----------------------------");

    }
}
class ParcelUser extends Users{
    String parcelType;
    ParcelUser(String name,String email, String address, String phoneNumber, String parcelType){
        super(name,email,address,phoneNumber);
        this.parcelType=parcelType;
    }
    void Display_ParcelWeight(){
        System.out.println("Parcel Type: "+parcelType);
        System.err.println("-----------------------------");
    }
}
public class M_Booking_Platform{
    public static void main(String[] args)
    {
        RideUser u;
        u=new RideUser("Dhana","dhana123@gmail.com","chennai","1234567890","car");
        u.DisplayRide();
        u.DisplayUser();
        FoodUser f;
        f=new FoodUser("Mithran","mithran123@gmail.com","bangalore","0987654321","pizza");
        f.Display_Fav_Food();
        f.DisplayUser();
        ParcelUser p;
        p=new ParcelUser("Suresh","suresh123@gmail.com","hyderabad","1122334455","document");
        p.Display_ParcelWeight();
        p.DisplayUser();


    }
    
}

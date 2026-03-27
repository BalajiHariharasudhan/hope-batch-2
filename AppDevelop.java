import java.util.*;

class User {
    String name;
    String phone;
    String address;
    String role = "user";

    User() {
        System.out.println("By using super");
    }

    User(String name) {
        this.name = name;
        System.out.println("User Created");
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Role: " + role);
    }
}

class FoodUser extends User {
    String favoritefood;

    FoodUser() {
        System.out.println("Food User Created");
    }
}

class TravelUser extends User {
    String preferredvehicle;
}

class Driver extends User {
    String role = "Driver"; // overrides role
    String vehicle;

    Driver(String name, String vehicle) {
        super(name);
        this.vehicle = vehicle;

        System.out.println("Name: " + name + " Driving " + vehicle);
        System.out.println("Role: " + role);
    }

    void displayDriver() {
        super.display(); // calls User display
        System.out.println("Vehicle: " + vehicle);
        System.out.println("Role: " + role);        // Driver role
        System.out.println("Parent Role: " + super.role); // User role
    }
}

public class AppDevelop {
    public static void main(String args[]) {
        Driver d = new Driver("Dhanalakshmi", "Car");
        d.displayDriver();
        
    }
}

package Day_4;

class Product {
    int id;
    String name;
    double price;
    int quantity;

    // Constructor
    Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Method to calculate total price of a product
    double getTotalPrice() {
        return price * quantity;
    }

    // Method to display product details
    void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Price: " + getTotalPrice());
        System.out.println("------------------------");
    }
}

public class Task1 {
    public static void main(String[] args) {

        // Creating 3 product objects
        Product p1 = new Product(1, "Laptop", 50000.0, 1);
        Product p2 = new Product(2, "Mouse", 500.0, 2);
        Product p3 = new Product(3, "Keyboard", 1500.0, 1);

        // Store in array
        Product[] cart = {p1, p2, p3};

        double grandTotal = 0;

        // Display all products
        for (Product p : cart) {
            p.display();
            grandTotal += p.getTotalPrice();
        }

        // Print grand total
        System.out.println("Grand Total: " + grandTotal);
    }
}

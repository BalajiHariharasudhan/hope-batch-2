import java.util.*;
class Product{
    int id;
    String name;
    double price;
    int quantity;
    Product(){
    }
    Product(int id,String name,double price,int quantity){
        this.id=id;
        this.name=name;
        this.price=price;
        this.quantity=quantity;
    }
    double getTotalPrice(){
        return price*quantity;
    }
    void display(){
        System.out.println("Id: "+id+" | Name: "+name+" | Price: "+price+" | Quantity: "+quantity+" | Total Price: "+getTotalPrice());
        System.out.println("---------------------------------------------------------------------------");
    }
}
public class ShoppingCart{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        Product[] cart=new Product[N];
        if(N>0) cart[0]=new Product(1,"Laptop",50000.0,1);
        if(N>1) cart[1]=new Product(1,"Mouse",200.0,3);
        if(N>2) cart[2]=new Product(3,"Keyboard",1500.0,2);
        for(int i=3;i<N;i++){
            System.out.println("Enter Product "+(i+1)+" Details");
            int id=sc.nextInt();
            sc.nextLine();
            String name=sc.nextLine();
            double price=sc.nextDouble();
            int quantity=sc.nextInt();
            cart[i]=new Product(id,name,price,quantity);
        }
        double grandTotal=0.0;
        System.out.println("SHOPPING CART");
        for(Product p:cart){
            p.display();
            grandTotal+=p.getTotalPrice();
        }
        System.out.println("Grand Total : "+grandTotal);
    }
}

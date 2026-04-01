public class EcommerceSystem {

    // 🔴 Custom Exceptions
    static class OutOfStockException extends Exception {
        public OutOfStockException(String message) {
            super(message);
        }
    }

    static class PaymentFailedException extends Exception {
        public PaymentFailedException(String message) {
            super(message);
        }
    }

    static class OrderProcessingException extends Exception {
        public OrderProcessingException(String message) {
            super(message);
        }
    }

    // 🔵 Product Class
    static class Product {
        String name;
        int stock;
        double price;

        Product(String name, int stock, double price) {
            this.name = name;
            this.stock = stock;
            this.price = price;
        }

        // Reduce stock
        void reduceStock(int quantity) throws OutOfStockException {
            if (quantity > stock) {
                throw new OutOfStockException("Product out of stock!");
            }
            stock -= quantity;
        }
    }

    // 🟢 User Class
    static class User {
        String name;
        String address;

        User(String name, String address) {
            this.name = name;
            this.address = address;
        }
    }

    // 🟡 Order Class
    static class Order {
        Product product;
        User user;
        int quantity;

        Order(Product product, User user, int quantity) {
            this.product = product;
            this.user = user;
            this.quantity = quantity;
        }

        double getTotalPrice() {
            return product.price * quantity;
        }
    }

    // 🟣 OrderService Class
    static class OrderService {

        public void placeOrder(Order order)
                throws OutOfStockException, PaymentFailedException, OrderProcessingException {

            // Step 1: Check stock
            order.product.reduceStock(order.quantity);

            // Step 2: Payment
            processPayment(order);

            // Step 3: Processing
            processOrder(order);

            System.out.println("✅ Order placed successfully!");
        }

        private void processPayment(Order order) throws PaymentFailedException {
            System.out.println("Processing payment...");

            if (Math.random() < 0.3) {
                throw new PaymentFailedException("❌ Payment failed!");
            }

            System.out.println("💰 Payment successful: " + order.getTotalPrice());
        }

        private void processOrder(Order order) throws OrderProcessingException {
            System.out.println("Processing order...");

            if (Math.random() < 0.2) {
                throw new OrderProcessingException("❌ Order processing failed!");
            }

            System.out.println("📦 Order processed for " + order.user.name);
        }
    }

    // 🚀 MAIN METHOD
    public static void main(String[] args) {

        Product product = new Product("Laptop", 5, 50000);
        User user = new User("Balaji", "Chennai");

        Order order = new Order(product, user, 2);
        OrderService service = new OrderService();

        try {
            service.placeOrder(order);

        } catch (OutOfStockException e) {
            System.out.println("Error: " + e.getMessage());

        } catch (PaymentFailedException e) {
            System.out.println("Error: " + e.getMessage());

        } catch (OrderProcessingException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

package Students;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
public class Warehouse {
    HashMap<String, Integer> products = new HashMap<>();
    HashMap<String, Integer> stockChecker = new HashMap<>();
    
    public void addProduct(String product, int price, int stock){
        products.put(product, price);
        stockChecker.put(product, stock);
    }

    public int price(String product) {
        return products.getOrDefault(product, -99);
    }

    public int stock(String product) {
        return stockChecker.getOrDefault(product, 0);
    }

    public boolean take(String product) {
        int stockAmount = stockChecker.getOrDefault(product, 0);
        if(stockAmount <= 0) {
            return false;
        } else {
            stockChecker.put(product, stockAmount - 1);
            return true;
        }
    }
    public Set<String> products() {
        return products.keySet();
    }

public static class Item {
            private String product;
            private int qty;
            private int unitPrice;

        public Item(String product, int qty, int unitPrice) {
            this.product = product;
            this.qty = qty;
            this.unitPrice = unitPrice;
        }
        
        public int totalPrice() {
            return qty * unitPrice;
        }
        
        public void increaseQuantity() {
            qty++;
        }

        @Override
        public String toString() {
            return this.product + ": " + qty ;
        }
    }   
    
    public static class ShoppingCart {
        private Map<String, Item> cart;
        
        public ShoppingCart() {
            this.cart = new HashMap<String, Item>();
        }
        
        public void add(String product, int price){
            if (cart.containsKey(product)) {
                cart.get(product).increaseQuantity();
            } else {
                Item item = new Item(product, 1, price);
                cart.put(product, item);
            }
        }
        
        public int price(){
            int totalPrice = 0;
            for (Item item : cart.values()) {
                totalPrice += item.totalPrice();
            }
            return totalPrice;
        }
        
        public void print() {
            for (Item item : cart.values()) {
                System.out.println(item);
            }
        }
    }
    public class Store {

    private Warehouse warehouse;
    private Scanner scanner;

    public Store(Warehouse warehouse, Scanner scanner) {
        this.warehouse = warehouse;
        this.scanner = scanner;
    }

    // the method that handles the customers visit to the store.
    public void shop(String customer) {
        ShoppingCart cart = new ShoppingCart();
        System.out.println("Welcome to the store " + customer);
        System.out.println("our selection:");

        for (String product : this.warehouse.products()) {
            System.out.println(product);
        }

        while (true) {
            System.out.print("What to put in the cart (press enter to go to the register): ");
            String product = scanner.nextLine();
            if (product.isEmpty()) {
                break;
            }

            // Add code here that adds the product to the cart,
            // If there is any in the warehouse, and reduces the stock in the warehouse
            // Don't touch any of the other code!

            if (warehouse.stock(product) > 0) {
                if (warehouse.take(product)) {
                    int productPrice = warehouse.price(product);
                    cart.add(product, productPrice);
                }
            }
        }

        System.out.println("your shoppingcart contents:");
        cart.print();
        System.out.println("total: " + cart.price());
    }
}


    public void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        Scanner scanner = new Scanner(System.in);
    warehouse.addProduct("coffee", 5, 10);
    warehouse.addProduct("milk", 3, 20);
    warehouse.addProduct("cream", 2, 55);
    warehouse.addProduct("bread", 7, 8);

    Store store = new Store(warehouse, scanner);
    store.shop("John");

}
}
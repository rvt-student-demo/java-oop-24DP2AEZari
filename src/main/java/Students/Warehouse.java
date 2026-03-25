package Students;
import java.util.HashMap;
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
            public String product;
            public int qty;
            public int unitPrice;
            HashMap<String, Integer> products = new HashMap<>();
            HashMap<String, Integer> productPrice = new HashMap<>();

        public Item(String product, int qty, int unitPrice) {
            this.product = product;
            this.qty = qty;
            this.unitPrice = unitPrice;
            products.put(product, qty);
            productPrice.put(product, unitPrice);
        }
        public int totalPrice() {
            int totalPrice = products.get(product) * productPrice.get(product);
            return totalPrice;
        }
        public void increaseQuantity() {
            qty++;
        }

        @Override
        public String toString() {
            return this.product + ":" + qty;
        }
    }    


    public static void main(String[] args) {
        Item item = new Item("milk", 4, 2);
        Item bread = new Item("bread", 5, 4);
        System.out.println("an item that contains 4 milks has the total price of " + item.totalPrice());
        System.out.println("an item that contains 5 bread has the total price of " + bread.totalPrice());
        System.out.println(item);
        bread.increaseQuantity();
        System.out.println(item + " and pricie of bread is " + bread);   

}
}
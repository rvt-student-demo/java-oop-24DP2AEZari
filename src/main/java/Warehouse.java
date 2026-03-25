package rvt.onlineShop;
import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    Map<String, Integer> products = new HashMap<>();
    Map<String, Integer> stockCheck = new HashMap<>();
    
    public void addProduct(String product, int price, int stock) {
        products.put(product, price);
        stockCheck.put(product, stock);

    }
   
    public int price(String product) {
        return products.getOrDefault(product, -99);
    }

     public int stock(String product) {
        return stockCheck.getOrDefault(product, 0);
    }

    public boolean take(String product) {
        int stockLeft = stockCheck.getOrDefault(product, 0);

        if (stockLeft > 0) {
            stockCheck.put(product, stockLeft - 1);
            return true;
        }  else {
            return false;
        }

    }

    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        warehouse.addProduct("coffee", 5, 1);

        System.out.println("stock:");
        System.out.println("coffee: " + warehouse.stock("coffee"));
        System.out.println("sugar: " + warehouse.stock("sugar"));

        System.out.println("taking coffee " + warehouse.take("coffee"));
        System.out.println("taking coffee " + warehouse.take("coffee"));
        System.out.println("taking sugar " + warehouse.take("sugar"));

        System.out.println("stock:");
        System.out.println("coffee: " + warehouse.stock("coffee"));
        System.out.println("sugar: " + warehouse.stock("sugar"));

    }
}
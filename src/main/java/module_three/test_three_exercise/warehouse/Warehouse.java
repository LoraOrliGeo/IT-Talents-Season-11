package module_three.test_three_exercise.warehouse;

import module_three.test_three_exercise.warehouse.products.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Warehouse {

    private Map<Product.ProductType, Map<IKind, Integer>> products;

    public Warehouse() {
        this.products = new HashMap<>();
        this.products.put(Product.ProductType.FRUIT, new HashMap<>());
        this.products.put(Product.ProductType.VEGETABLE, new HashMap<>());
        this.products.put(Product.ProductType.MEAT, new HashMap<>());

        for (Fruit.FruitKind fruit : Fruit.FruitKind.values()) {
            this.products.get(Product.ProductType.FRUIT).put(fruit, 15);
        }

        for (Vegetable.VegeKind vegetable : Vegetable.VegeKind.values()) {
            this.products.get(Product.ProductType.VEGETABLE).put(vegetable, 15);
        }

        for (Meat.MeatKind meat : Meat.MeatKind.values()) {
            this.products.get(Product.ProductType.MEAT).put(meat, 15);
        }
    }

    public synchronized void deliver() {
        // invoke by Deliver
        List<IKind> deficit = getDeficitProducts();

        while (deficit.isEmpty()) {
            try {
                wait();
                deficit = getDeficitProducts();
                System.out.println("Deficit products: " + deficit.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (IKind p : deficit) {
            addProduct(p, 25);
        }

        notifyAll();
    }

    public synchronized void sellToStore(IKind p, Store store) {
        // invoke by Store
        if (this.products.get(p.getType()).get(p) < 5) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // sell 5 of this product to the store
        this.products.get(p.getType()).put(p, this.products.get(p.getType()).get(p) - 5);
        store.addGoods(p, 5);
        System.out.println("Sell 5 " + p + " to store");
        notifyAll();
    }

    private void addProduct(IKind p, int i) {
        this.products.get(p.getType()).put(p, this.products.get(p.getType()).get(p) + i);
        System.out.println("Adding products from deliver done!");
    }

    private List<IKind> getDeficitProducts() {
        List<IKind> deficit = new ArrayList<>();
        for (Map.Entry<Product.ProductType, Map<IKind, Integer>> e : this.products.entrySet()) {
            for (Map.Entry<IKind, Integer> entry : e.getValue().entrySet()) {
                if (entry.getValue() < 15) {
                    deficit.add(entry.getKey());
                }
            }
        }

        return deficit;
    }
}

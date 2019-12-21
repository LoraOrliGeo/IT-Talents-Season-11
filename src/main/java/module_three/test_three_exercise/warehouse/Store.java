package module_three.test_three_exercise.warehouse;

import module_three.test_three_exercise.warehouse.products.*;

import java.util.*;

public class Store extends Thread {
    public volatile static Warehouse warehouse;

    private Map<Product.ProductType, Map<IKind, Integer>> products;

    public Store() {
        this.products = new HashMap<>();
        this.products.put(Product.ProductType.FRUIT, new HashMap<>());
        this.products.put(Product.ProductType.VEGETABLE, new HashMap<>());
        this.products.put(Product.ProductType.MEAT, new HashMap<>());

        for (Fruit.FruitKind fruit : Fruit.FruitKind.values()) {
            this.products.get(Product.ProductType.FRUIT).put(fruit, 15);
        }

        for (Vegetable.VegeKind vege : Vegetable.VegeKind.values()) {
            this.products.get(Product.ProductType.VEGETABLE).put(vege, 15);
        }

        for (Meat.MeatKind meat : Meat.MeatKind.values()) {
            this.products.get(Product.ProductType.MEAT).put(meat, 15);
        }
    }

    @Override
    public void run() {
        while (true) {
            List<IKind> deficit = getDeficitProducts();
            if (!deficit.isEmpty()) {
                for (IKind p : deficit) {
                    warehouse.sellToStore(p, this);
                }
            }
        }
    }

    public synchronized void addGoods(IKind p, int i) {
        this.products.get(p.getType()).put(p, this.products.get(p.getType()).get(p) + i);
        System.out.println("The store added " + i + " " + p + " from the warehouse");
    }

    private List<IKind> getDeficitProducts() {
        List<IKind> deficit = new ArrayList<>();
        for (Map.Entry<Product.ProductType, Map<IKind, Integer>> e : this.products.entrySet()) {
            for (Map.Entry<IKind, Integer> entry : e.getValue().entrySet()) {
                if (entry.getValue() < 10) {
                    deficit.add(entry.getKey());
                }
            }
        }

        return deficit;
    }

    public IKind getRandomProduct() {
        List<IKind> allProducts = new ArrayList<>();
        for (Map.Entry<Product.ProductType, Map<IKind, Integer>> entry : this.products.entrySet()) {
            allProducts.addAll(entry.getValue().keySet());
        }

        Collections.shuffle(allProducts);
        return allProducts.get(0);
    }

    public synchronized void sell(IKind product, int quantity) {
        while (this.products.get(product.getType()).get(product) < quantity) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.products.get(product.getType()).put(product, this.products.get(product.getType()).get(product) - quantity);
        System.out.println("Sold " + quantity + " " + product + " to client");
        notifyAll();
    }
}

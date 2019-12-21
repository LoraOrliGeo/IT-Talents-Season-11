package module_three.test_three_exercise.test_three.models;

import module_three.test_three_exercise.test_three.db.DBDao;
import module_three.test_three_exercise.test_three.models.breads.Bread;
import module_three.test_three_exercise.test_three.models.breads.BreadBasket;
import module_three.test_three_exercise.test_three.models.garnish.Garnish;
import module_three.test_three_exercise.test_three.models.garnish.GarnishBow;
import module_three.test_three_exercise.test_three.models.garnish.NotEnoughGarnishQuantity;
import module_three.test_three_exercise.test_three.models.meats.Meat;
import module_three.test_three_exercise.test_three.models.meats.MeatPot;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Seller extends Thread {
    private List<BreadBasket> breadBaskets;
    private List<MeatPot> meatPots;
    private List<GarnishBow> garnishBows;
    private List<Order> orders;

    public Seller() {
        initBreadBaskets();
        initMeatPots();
        initGarnishBows();
        this.orders = new ArrayList<>();
    }

    private void initBreadBaskets() {
        this.breadBaskets = new ArrayList<>();
        this.breadBaskets.add(new BreadBasket(Bread.BreadType.WHITE));
        this.breadBaskets.add(new BreadBasket(Bread.BreadType.WHOLEGRAIN));
    }

    private void initMeatPots() {
        this.meatPots = new ArrayList<>();
        this.meatPots.add(new MeatPot(Meat.MeatType.MEATBALL));
        this.meatPots.add(new MeatPot(Meat.MeatType.PLESKAVICA));
        this.meatPots.add(new MeatPot(Meat.MeatType.STEAK));
    }

    private void initGarnishBows() {
        this.garnishBows = new ArrayList<>();
        this.garnishBows.add(new GarnishBow(Garnish.GarnishType.RUSSIAN));
        this.garnishBows.add(new GarnishBow(Garnish.GarnishType.LUTENICA));
        this.garnishBows.add(new GarnishBow(Garnish.GarnishType.SNEJANKA));
        this.garnishBows.add(new GarnishBow(Garnish.GarnishType.CABBAGE_CARROT));
        this.garnishBows.add(new GarnishBow(Garnish.GarnishType.TOMATO_CUCUMBER));
    }

    @Override
    public void run() {
        while (true) {
            logOrders();
        }
    }

    public BreadBasket getProperBasket(Bread bread) {
        for (BreadBasket basket : this.breadBaskets) {
            if (basket.getBreadType().equals(bread)) {
                return basket;
            }
        }
        return null;
    }

    public List<BreadBasket> getBreadBaskets() {
        return breadBaskets;
    }

    public MeatPot getProperPot(Meat meat) {
        for (MeatPot pot : this.meatPots) {
            if (pot.getMeatType().equals(meat.getMeatType())) {
                return pot;
            }
        }
        return null;
    }

    public List<MeatPot> getMeatPots() {
        return meatPots;
    }

    public GarnishBow getProperBow(Garnish garnish) {
        for (GarnishBow bow : this.garnishBows) {
            if (bow.getGarnishType().equals(garnish.getGarnishType())) {
                return bow;
            }
        }
        return null;
    }

    public List<GarnishBow> getGarnishBows() {
        return garnishBows;
    }

    private Meat getMeatFromMeatPot(Meat.MeatType meatType) {
        // invoke by seller
        for (MeatPot meatPot : this.meatPots) {
            if (meatPot.getMeatType().equals(meatType)) {
                return meatPot.takeMeat();
            }
        }
        return null;
    }

    private Bread getBreadFromBreadBasket(Bread.BreadType breadType) {
        // invoke by seller
        for (BreadBasket breadBasket : this.breadBaskets) {
            if (breadBasket.getBreadType().equals(breadType)) {
                return breadBasket.takeBread();
            }
        }
        return null;
    }

    private void takeGarnish(Garnish.GarnishType garnishType) throws NotEnoughGarnishQuantity {
        // invoke by seller
        for (GarnishBow bow : this.getGarnishBows()) {
            if (bow.getGarnishType().equals(garnishType)) {
                bow.takeGarnish();
            }
        }
    }

    public int prepareOrder(Order order) throws NotEnoughGarnishQuantity, SQLException {
        int milliseconds = 0;
        Bread bread = this.getBreadFromBreadBasket(order.getBreadType());
        milliseconds += bread.getType().getPreparationTime();

        Meat meat = this.getMeatFromMeatPot(order.getMeatType());
        milliseconds += meat.getMeatType().getPreparationTime();

        this.takeGarnish(order.getGarnishType());
        milliseconds += 100; // time to add garnish to the order

        System.out.println(milliseconds);

        double price = bread.getType().getPrice() + meat.getMeatType().getPrice() + order.getGarnishType().getPrice();
        order.setPrice(price);
        order.setOrderTime(LocalDateTime.now());
        order.setPreparationTime(milliseconds);
        this.orders.add(order);

        DBDao.getInstance().insertOrder(order);
        return milliseconds;
    }

    private void logOrders() {
        File file = new File("C:\\Users\\Lori\\Desktop\\tefter.txt");
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(file))) {
            for (Order order : this.orders) {
                pw.println(order.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

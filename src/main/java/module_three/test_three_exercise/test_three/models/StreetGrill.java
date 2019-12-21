package module_three.test_three_exercise.test_three.models;

import module_three.test_three_exercise.test_three.db.DBDao;
import module_three.test_three_exercise.test_three.models.breads.Bread;
import module_three.test_three_exercise.test_three.models.breads.BreadBasket;
import module_three.test_three_exercise.test_three.models.breads.BreadMakerGirl;
import module_three.test_three_exercise.test_three.models.garnish.*;
import module_three.test_three_exercise.test_three.models.meats.GrillMan;
import module_three.test_three_exercise.test_three.models.meats.Meat;
import module_three.test_three_exercise.test_three.models.meats.MeatPot;
import org.w3c.dom.ls.LSOutput;

import java.sql.SQLException;

public class StreetGrill {

    private static StreetGrill INSTANCE = new StreetGrill();

    private Seller seller;
    private BreadMakerGirl breadMakerGirl;
    private GrillMan grillMan;
    private GarnishGuy garnishGuy;
    private Owner owner;

    class Owner extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(7000); // 7 days
                    printFirst();
                    printSecond();
                    printSeventh();
                    printEight();
                    printNinth();
                    printTenth();
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private void printFirst() throws SQLException {
            System.out.println("Number of orders for my grill: " + DBDao.getInstance().getSumOfOrders());
        }

        private void printSecond() throws SQLException {
            System.out.println(DBDao.getInstance().getMostSellMeatType());
        }

        private void printSeventh() throws SQLException {
            String res = DBDao.getInstance().getShopWithHighestAmountOfWholegrainBread();
            System.out.println(res);
        }

        private void printEight() throws SQLException {
            DBDao.getInstance().getTotalCountOfPLeskavici();
        }

        private void printNinth() throws SQLException {
            System.out.println(DBDao.getInstance().getMostSoldGarnish());
        }

        private void printTenth() throws SQLException {
            System.out.println(DBDao.getInstance().getLessSoldGarnishInMyShop());
        }
    }

    private StreetGrill() {
        this.seller = new Seller();
        this.seller.start();
        this.breadMakerGirl = new BreadMakerGirl();
        this.breadMakerGirl.start();
        this.grillMan = new GrillMan();
        this.grillMan.start();
        this.garnishGuy = new GarnishGuy();
        this.garnishGuy.start();
    }

    public synchronized static StreetGrill getInstance() {
        return INSTANCE;
    }

    public void addBreadToBasket(Bread bread) {
        // invoke by bread maker girl
        BreadBasket basket = this.seller.getProperBasket(bread);
        if (basket != null) {
            basket.addBread(bread);
        }
    }

    public void addMeatToPot(Meat meat) {
        //invoke by grill man
        MeatPot pot = this.seller.getProperPot(meat);
        if (pot != null) {
            pot.addMeat(meat);
        }
    }

    public void addGarnishToGarnishBow(Garnish garnish) throws NotEnoughSpaceException {
        // invoke by garnish guy
        GarnishBow bow = this.seller.getProperBow(garnish);
        if (bow != null) {
            bow.addGarnish();
        }
    }

    public int makeOrder(Order order) {
        try {
            int time = this.seller.prepareOrder(order);
            System.out.println("Your order is ready!");
            return time;
        } catch (NotEnoughGarnishQuantity notEnoughGarnishQuantity) {
            System.out.println(notEnoughGarnishQuantity.getMessage());
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}

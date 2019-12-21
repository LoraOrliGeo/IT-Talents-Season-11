package module_three.threads.lecture_two;

public class Pot {
    private int quantity = 50;
    private static final int MAX_QUANTITY = 100;

    public synchronized void add() {
        if (quantity == MAX_QUANTITY) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.quantity++;
        notifyAll();
        System.out.println("Grandmother added. Bob in pot -> " + this.quantity);
    }

    public synchronized void remove() {
        if (quantity == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.quantity--;
        notifyAll();
        System.out.println("Grandchild took. Bob in pot -> " + this.quantity);
    }

    public int getQuantity() {
        return quantity;
    }
}

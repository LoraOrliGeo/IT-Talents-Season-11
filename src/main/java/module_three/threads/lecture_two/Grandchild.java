package module_three.threads.lecture_two;

public class Grandchild extends Thread {
    private Pot pot;

    public Grandchild(Pot pot) {
        this.pot = pot;
    }

    @Override
    public void run() {
        while(true) {
            pot.remove();
        }
    }
}

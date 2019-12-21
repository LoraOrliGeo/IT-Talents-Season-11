package module_three.threads.lecture_two;

public class Grandmother extends Thread {
    private Pot pot;

    public Grandmother(Pot pot) {
        this.pot = pot;
    }

    @Override
    public void run() {
        while(true) {
            pot.add();
        }
    }
}

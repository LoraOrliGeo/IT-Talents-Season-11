package module_three.test_three_exercise.harbour.model;

public class Crane extends Thread {

    public Crane(String name) {
        super(name);
    }

    @Override
    public void run() {
        while(true){
            Harbour.getInstance().unload();
        }
    }
}

package module_three.threads.lecture_one;

public class MyThread extends Thread {

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + " * 2 = " + (i * 2));
        }
    }
}

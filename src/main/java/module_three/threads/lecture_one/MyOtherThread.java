package module_three.threads.lecture_one;

public class MyOtherThread implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + " * 2 = " + (i * 2));
        }
    }
}

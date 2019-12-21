package module_three.threads.lecture_one;

public class Timer extends Thread {
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                if (isInterrupted()) {
                    System.out.println("interrupted");
                    return;
                }
            }

            System.out.println("the time is now");
        }
    }
}

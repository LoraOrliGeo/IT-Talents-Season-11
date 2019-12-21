package module_three.threads.lecture_one;

public class Demo {
    public static void main(String[] args) {

        // ways to create thread:
        // 1 MyThread extends Thread
        MyThread myThread = new MyThread("My thread");
        // never! - now run() it's just a method, it doesn't give the thread state (run() NEVER STARTS IN PARALLEL!)
//        myThread.run();
        myThread.start(); // sends the thread in "the waiting room" -> it has a ready (not-running) state

        // 2 MyOtherThread implements Runnable
        MyOtherThread myOtherThread = new MyOtherThread();
        Thread t = new Thread(myOtherThread); // Runnable doesn't have start()
        t.start();

        try {
            // t.join() - the current thread (main) will continue its control flow when t is dead
            myThread.join();
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 3 anonymous class from Thread
        Thread t1 = new Thread() {
            @Override
            public void run() {
                System.out.println("Thread created by anonymous class from Thread");
            }
        };
        t1.start();

        // 4 anonymous class from Runnable
        Runnable t2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread created by anonymous class from Runnable");
            }
        };
        new Thread(t2).start();

        // 5 lambda function
        Thread t3 = new Thread(() -> {
            System.out.println("Thread created by lambda expression");
        });
        System.out.println(t3.getState()); // NEW
        t3.start();

        System.out.println(t3.getState()); // RUNNABLE

        System.out.println("Start timer");
        Timer timer = new Timer();
        timer.start();
        timer.interrupt();

//        try {
//            Thread.sleep(12000);
//        } catch (InterruptedException e) {
//            System.out.println("oops");
//        }

        System.out.println("End timer");
    }
}

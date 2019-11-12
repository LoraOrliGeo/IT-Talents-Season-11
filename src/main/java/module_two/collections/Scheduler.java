package module_two.collections;

import java.util.LinkedList;
import java.util.Queue;

public class Scheduler {
    private LinkedList<ITask> queue;

    public Scheduler() {
        this.queue = new LinkedList<>();
    }

    public void push(ITask task) {
        this.queue.offer(task);
    }

    public void main() {
        System.out.println("By peek() -> " + this.queue.peek());
        System.out.println("By getFirst() -> " + this.queue.getFirst());
        ITask task3 = this.queue.peekFirst();
        ITask task4 = this.queue.poll();
    }
}

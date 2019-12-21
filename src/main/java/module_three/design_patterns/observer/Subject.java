package module_three.design_patterns.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject implements ISubject {
    private List<IObserver> observers;

    public Subject() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(IObserver observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        if (this.observers.remove(observer)) {
            System.out.println("Successfully remove an observer!");
        }
    }

    @Override
    public void notifyObservers() {
        for (IObserver observer : this.observers) {
            observer.update();
        }
    }
}

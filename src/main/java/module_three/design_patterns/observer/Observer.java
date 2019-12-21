package module_three.design_patterns.observer;

public class Observer implements IObserver {
    @Override
    public void update() {
        System.out.println("Hurray, I'm updated!");
    }
}

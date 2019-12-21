package module_three.design_patterns.observer;

public interface ISubject {
    void registerObserver(IObserver observer);

    void removeObserver(IObserver observer);

    void notifyObservers();
}

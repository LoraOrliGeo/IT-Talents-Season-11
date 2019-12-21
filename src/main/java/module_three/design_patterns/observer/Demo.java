package module_three.design_patterns.observer;

public class Demo {
    public static void main(String[] args) {

        // create the subject
        ISubject magazine = new Subject();

        // create some observers
        IObserver pesho = new Observer();
        IObserver mimi = new Observer();

        magazine.registerObserver(pesho);
        magazine.registerObserver(mimi);

        // notify the observers for change in subject
        magazine.notifyObservers();

        // remove subscriber (observer) from the subject
        magazine.removeObserver(mimi);

        magazine.notifyObservers();
    }
}

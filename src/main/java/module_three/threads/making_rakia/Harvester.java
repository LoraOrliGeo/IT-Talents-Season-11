package module_three.threads.making_rakia;

public class Harvester extends Person {

    public Harvester(String name, int age, FruitType fruit) {
        super(name, age, fruit);
    }

    @Override
    public void run() {
        while (true) {
            if (Person.distillery.isFull()) {
                return;
            }

            try {
                sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Person.distillery.addFruit(this.getFruit());
        }
    }
}

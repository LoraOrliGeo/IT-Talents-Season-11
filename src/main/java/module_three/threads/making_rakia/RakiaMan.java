package module_three.threads.making_rakia;

public class RakiaMan extends Person {

    public RakiaMan(String name, int age, FruitType fruit) {
        super(name, age, fruit);
    }

    @Override
    public void run() {
        while (true) {
            if (Person.distillery.isFull()){
                return;
            }

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Person.distillery.makeRakia(this.getFruit());
        }
    }
}

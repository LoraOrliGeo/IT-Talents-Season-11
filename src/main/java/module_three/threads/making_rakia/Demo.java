package module_three.threads.making_rakia;

import java.util.Random;

public class Demo {
    public static void main(String[] args) {

        for (int i = 0; i < 7; i++) {
            Harvester harvester = new Harvester("Harvester " + (i + 1), i + 25, getRandomFruit());
            harvester.start();
        }

        RakiaMan unclePesho = new RakiaMan("Uncle Pesho", 60, FruitType.GRAPES);
        RakiaMan uncleGosho = new RakiaMan("Uncle Gosho", 62, FruitType.APRICOT);
        RakiaMan uncleVanio = new RakiaMan("Uncle Vanio", 64, FruitType.PLUM);

        unclePesho.start();
        uncleGosho.start();
        uncleVanio.start();

        Statistics statistics = new Statistics();
        statistics.setDaemon(true);
        statistics.start();
    }

    private static FruitType getRandomFruit() {
        return FruitType.values()[new Random().nextInt(FruitType.values().length)];
    }
}

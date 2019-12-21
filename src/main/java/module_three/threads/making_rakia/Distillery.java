package module_three.threads.making_rakia;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class Distillery {
    private static final int NUMBER_OF_CAULDRONS = 5;
    private static final int MAX_LITERS_RAKIA = 20;
    private List<Cauldron> cauldrons;
    private Map<FruitType, Integer> litersProducedRakia;
    private Map<FruitType, Integer> harvestFruits;

    public Distillery() {
        this.cauldrons = addCauldrons();
        this.harvestFruits = new HashMap<>();
        this.litersProducedRakia = new HashMap<>();
    }

    private List<Cauldron> addCauldrons() {
        this.cauldrons = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_CAULDRONS; i++) {
            this.cauldrons.add(new Cauldron(i + 1));
        }
        return this.cauldrons;
    }

    public boolean isFull() {
        int litersRakia = 0;
        for (Integer liters : this.litersProducedRakia.values()) {
            litersRakia += liters;
        }
        return litersRakia >= MAX_LITERS_RAKIA;
    }

    public synchronized void addFruit(FruitType fruit) {
        // invoked by harvesters
        Cauldron cauldron = null;
        do {
            if (isFull()) {
                return;
            }

            for (Cauldron c : this.cauldrons) {
                if (c.isEmpty() || (c.getFruit() == fruit && !c.isFull())) {
                    cauldron = c;
                    break;
                }
            }

            if (cauldron == null) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                cauldron.fill(fruit);
                harvestFruits.putIfAbsent(fruit, 1);
                harvestFruits.putIfAbsent(fruit, harvestFruits.get(fruit) + 1);
                notifyAll();
            }
        } while (cauldron == null);
    }

    public synchronized void makeRakia(FruitType fruit) {
        // invoked by rakiamen
        Cauldron cauldron = null;
        do {
            if (isFull()) {
                return;
            }

            for (Cauldron c : this.cauldrons) {
                if (c.isFull() && c.getFruit() == fruit) {
                    cauldron = c;
                    break;
                }
            }

            if (cauldron == null) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                cauldron.empty();
                this.litersProducedRakia.putIfAbsent(fruit, 1);
                this.litersProducedRakia.put(fruit, this.litersProducedRakia.get(fruit) + 1);
                notifyAll();
            }
        } while (cauldron == null);
    }

    public void printStatistics() {
        StringBuilder result = new StringBuilder();
        result.append(LocalDateTime.now()).append(System.lineSeparator());
        try (OutputStreamWriter writer = new FileWriter(new File("C:\\Users\\Lori\\Desktop\\rakii_statistics.txt"), true)) {

            result.append("~~~~~~~~~~~~~~~~~~~~~~~~~~ MOST HARVEST FRUIT ~~~~~~~~~~~~~~~~~~~~~~~~~~" + System.lineSeparator());

            this.harvestFruits.entrySet().stream().sorted((f1, f2) -> f2.getValue() - f1.getValue())
                    .limit(1).forEach(e -> result.append(e.getKey() + " -> " + e.getValue() + " kg").append(System.lineSeparator()));

            result.append("~~~~~~~~~~~~~~~~~~~~~~~~~~ MOST PRODUCED RAKIA ~~~~~~~~~~~~~~~~~~~~~~~~~~").append(System.lineSeparator());
            this.litersProducedRakia.entrySet().stream().sorted((r1, r2) -> r2.getValue() - r1.getValue())
                    .limit(1).forEach(e -> result.append(e.getKey() + " -> " + e.getValue() + " liters").append(System.lineSeparator()));

            result.append("~~~~~~~~~~~~~~~~~~~~~~~~~~ RATIO BETWEEN GRAPES AND APRICOT PRODUCED RAKIA ~~~~~~~~~~~~~~~~~~~~~~~~~~").append(System.lineSeparator());
            int grapesRakiaLiters = this.litersProducedRakia.containsKey(FruitType.GRAPES)
                    ? this.litersProducedRakia.get(FruitType.GRAPES) : 0;
            int apricotRakiaLiters = this.litersProducedRakia.containsKey(FruitType.APRICOT)
                    ? this.litersProducedRakia.get(FruitType.APRICOT) : 0;
            result.append(grapesRakiaLiters + " / " + apricotRakiaLiters).append(System.lineSeparator());

            writer.append(result.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~ MOST HARVEST FRUIT ~~~~~~~~~~~~~~~~~~~~~~~~~~");
//        this.harvestFruits.entrySet().stream().sorted((f1, f2) -> f2.getValue() - f1.getValue())
//                .limit(1).forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue() + " kg"));
//
//        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~ MOST PRODUCED RAKIA ~~~~~~~~~~~~~~~~~~~~~~~~~~");
//        this.litersProducedRakia.entrySet().stream().sorted((r1, r2) -> r2.getValue() - r1.getValue())
//                .limit(1).forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue() + " liters"));
//
//        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~ RATIO BETWEEN GRAPES AND APRICOT PRODUCED RAKIA ~~~~~~~~~~~~~~~~~~~~~~~~~~");
//        int grapesRakiaLiters = this.litersProducedRakia.containsKey(FruitType.GRAPES)
//                ? this.litersProducedRakia.get(FruitType.GRAPES) : 0;
//        int apricotRakiaLiters = this.litersProducedRakia.containsKey(FruitType.APRICOT)
//                ? this.litersProducedRakia.get(FruitType.APRICOT) : 0;
//        System.out.println(grapesRakiaLiters + " / " + apricotRakiaLiters);
    }
}

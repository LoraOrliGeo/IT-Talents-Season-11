package module_three.test_three_exercise.harbour.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Ship {
    private int dockId;
    private String name;
    private List<Package> packages;

    public Ship(String name) {
        this.name = name;
        this.packages = new ArrayList<>();
        int numberOfPackages = new Random().nextInt(3) + 1;
        for (int i = 0; i < numberOfPackages; i++) {
            this.packages.add(new Package());
        }
    }

    public String getName() {
        return name;
    }

    public List<Package> getPackages() {
        List<Package> list = new ArrayList<>(this.packages);
        this.packages.clear();
        return Collections.unmodifiableList(list);
    }

    public void setDockId(int i) {
        this.dockId = i;
    }

    public int getDockId() {
        return dockId;
    }
}

package test_two_exercise.archery_club.archers;

import test_two_exercise.archery_club.bows.WoodenBow;

import java.util.Random;

public class JuniorArcher extends Archer {
    private static final int ARROWS_COUNT = 30;
    private static final int JUNIOR_MISS_CHANCE = 10;

    public JuniorArcher(String name, String gender, int age, WoodenBow bow, int experience, int tournaments) {
        super(name, gender, age, bow, experience, tournaments);
    }

    @Override
    public int getMinExperience() {
        return 1;
    }

    @Override
    public int getArrowsCount() {
        return ARROWS_COUNT;
    }

    @Override
    public int getRandomPoints() {
        Random r = new Random();
        return r.nextInt(10) + 1;
    }

    @Override
    public boolean hasMissed() {
        Random r = new Random();
        int chance = r.nextInt(100);
        return chance <= JUNIOR_MISS_CHANCE;
    }

    @Override
    public ArcherType getArcherType() {
        return ArcherType.JUNIOR;
    }
}

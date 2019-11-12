package test_two_exercise.archery_club.archers;

import test_two_exercise.archery_club.bows.CarbonBow;

import java.util.Random;

public class VeteranArcher extends Archer {
    private static final int ARROWS_COUNT = 60;
    private static final int MIN_YEARS_EXPERIENCE = 10;

    public VeteranArcher(String name, String gender, int age, CarbonBow bow, int experience, int tournaments) {
        super(name, gender, age, bow, experience, tournaments);
    }

    @Override
    public int getMinExperience() {
        return MIN_YEARS_EXPERIENCE;
    }

    @Override
    public int getArrowsCount() {
        return ARROWS_COUNT;
    }

    @Override
    public int getRandomPoints() {
        Random r = new Random();
        return r.nextInt(5) + 6;
    }

    @Override
    public boolean hasMissed() {
        return false;
    }

    @Override
    public ArcherType getArcherType() {
        return ArcherType.VETERAN;
    }
}

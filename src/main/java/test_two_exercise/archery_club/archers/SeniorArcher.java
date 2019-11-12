package test_two_exercise.archery_club.archers;

import test_two_exercise.archery_club.bows.ISeniorBow;

import java.util.Random;

public class SeniorArcher extends Archer {
    private static final int ARROWS_COUNT = 60;
    private static final int MIN_YEARS_EXPERIENCE = 3;
    private static final int SENIOR_MISS_CHANCE = 5;

    public SeniorArcher(String name, String gender, int age, ISeniorBow bow, int experience, int tournaments) {
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
        Random r = new Random();
        int chance = r.nextInt(100);
        return chance <= SENIOR_MISS_CHANCE;
    }

    @Override
    public ArcherType getArcherType() {
        return ArcherType.SENIOR;
    }
}

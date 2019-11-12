package test_two_exercise.archery_club.archers;

import test_two_exercise.archery_club.bows.IBow;

public abstract class Archer {

    private static final int MAX_POINTS = 10;

    private String name;
    private String gender;
    private int age;
    private IBow bow;
    private int experience;
    private int tournaments;
    private int points;
    private int tens;
    private int missedShoots;

    public Archer(String name, String gender, int age, IBow bow, int experience, int tournaments) {
        setName(name);
        setGender(gender);
        setAge(age);
        setBow(bow);
        setExperience(experience);
        setTournaments(tournaments);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
    }

    public String getGender() {
        return this.gender;
    }

    private void setGender(String gender) {
        if (gender.equalsIgnoreCase("male") ||
                gender.equalsIgnoreCase("female")) {
            this.gender = gender;
        } else {
            System.out.println("Invalid gender!");
        }
    }

    public int getAge() {
        return this.age;
    }

    private void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }
    }

    public IBow getBow() {
        return this.bow;
    }

    private void setBow(IBow bow) {
        if (bow != null) {
            this.bow = bow;
        }
    }

    public int getExperience() {
        return this.experience;
    }

    private void setExperience(int experience) {
        int minExperience = getMinExperience();
        this.experience = experience > minExperience ? experience : minExperience;
    }

    private int getTournaments() {
        return this.tournaments;
    }

    private void setTournaments(int tournaments) {
        if (tournaments > 0) {
            this.tournaments = tournaments;
        }
    }

    public int getPoints() {
        return this.points;
    }

    public double getTensPercentage() {
        return this.tens * 1.0 / getArrowsCount() * 100;
    }

    public int getMissedShoots() {
        return this.missedShoots;
    }

    public void increaseTournamentsByOne() {
        int t = this.getTournaments();
        this.setTournaments(t + 1);
    }

    public void shoot() {
        for (int i = 0; i < getArrowsCount(); i++) {
            int points = hasMissed() ? 0 : getRandomPoints();

            if (hasMissed()) {
                this.missedShoots++;
            }

            if (points != MAX_POINTS) {
                int bonus = this.bow.getBonus();
                points += (points + bonus) > MAX_POINTS ? MAX_POINTS : bonus;

                if (points == MAX_POINTS) {
                    this.tens++;
                }
            }

            this.points += points;
        }
    }

    protected abstract boolean hasMissed();

    protected abstract int getRandomPoints();

    protected abstract int getArrowsCount();

    protected abstract int getMinExperience();

    public abstract ArcherType getArcherType();

    public void printArcherInfo() {
        System.out.println(String.format("Name: %s%nAge: %d%nExperience: %d",
                this.getName(), this.getAge(), this.getExperience()));
    }
}

package test_two_exercise.archery_club;

import test_two_exercise.archery_club.archers.Archer;
import test_two_exercise.archery_club.archers.ArcherType;

import java.util.*;

public class Club {
    private String name;
    private String address;
    private String trainer;
    private List<Archer> archers;
    private Map<ArcherType, Map<Archer, Integer>> results;

    public Club(String name, String address, String trainer) {
        setName(name);
        setAddress(address);
        setTrainer(trainer);
        this.archers = new ArrayList<>();
        this.results = new HashMap<>();
    }

    private void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
    }

    private void setAddress(String address) {
        if (address != null && !address.isEmpty()) {
            this.address = address;
        }
    }

    private void setTrainer(String trainer) {
        if (trainer != null && !trainer.isEmpty()) {
            this.trainer = trainer;
        }
    }

    public void addArcher(Archer archer) {
        if (archer != null) {
            this.archers.add(archer);
        }
    }

    public void startTournament() {
        printContestants();
        shootArrows();
        showStatistics();
    }

    private void printContestants() {
        // sort archers by name and increase the tournaments of each archer by 1
        System.out.println("ARCHERS IN THE COMPETITION:");
        TreeSet<Archer> archers = new TreeSet<>((a1, a2) -> {
            if (a1.getName().equalsIgnoreCase(a2.getName())) {
                return 1;
            }
            return a1.getName().compareTo(a2.getName());
        });
        archers.addAll(this.archers);

        for (Archer archer : archers) {
            archer.printArcherInfo();
            archer.increaseTournamentsByOne();
        }
    }

    private void shootArrows() {
        for (Archer archer : this.archers) {
            archer.shoot();

            if (!results.containsKey(archer.getArcherType())) {
                results.put(archer.getArcherType(), new HashMap<>());
            }

            results.get(archer.getArcherType()).put(archer, archer.getPoints());
        }
    }

    private void showStatistics() {
        printCategoryWinner();
        printAvgPoints();
        printPrecisestArcher();
        printMostIncapableArcher();
        printWomenByAccuracy();
        printMenWithCarbonBowsByYearsExperience();
    }

    private void printCategoryWinner() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~ WINNER BY CATEGORY ~~~~~~~~~~~~~~~~~~~~~~");
        Archer juniorWinner = null;
        Archer seniorWinner = null;
        Archer veteranWinner = null;

        for (Archer archer : this.archers) {
            switch (archer.getArcherType()) {
                case JUNIOR:
                    if (juniorWinner == null || archer.getPoints() > juniorWinner.getPoints()) {
                        juniorWinner = archer;
                    }
                    break;
                case SENIOR:
                    if (seniorWinner == null || archer.getPoints() > seniorWinner.getPoints()) {
                        seniorWinner = archer;
                    }
                    break;
                case VETERAN:
                    if (veteranWinner == null || archer.getPoints() > veteranWinner.getPoints()) {
                        veteranWinner = archer;
                    }
                    break;
            }
        }

        System.out.println(String.format("Junior Winner: %s%nSenior Winner: %s%nVeteran Winner: %s",
                juniorWinner.getName(), seniorWinner.getName(), veteranWinner.getName()));
    }

    private void printAvgPoints() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~ AVERAGE POINTS BY CATEGORY ~~~~~~~~~~~~~~~~~~~~~~");
        for (Map.Entry<ArcherType, Map<Archer, Integer>> entry : this.results.entrySet()) {
            int total = entry.getValue().size();
            double sum = 0;
            for (Integer i : entry.getValue().values()) {
                sum += i;
            }
            System.out.println(entry.getKey() + " Average Points: " + sum / total);
        }
    }

    private void printPrecisestArcher() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~ PRECISEST ARCHER ~~~~~~~~~~~~~~~~~~~~~~");
        Archer precisestArcher = null;
        double percentageTens = 0;

        for (Archer archer : this.archers) {
            if (archer.getTensPercentage() > percentageTens) {
                percentageTens = archer.getTensPercentage();
                precisestArcher = archer;
            }
        }

        System.out.println(String.format("%s, Percentage of Tens: %.2f%%",
                precisestArcher.getName(), percentageTens));
    }

    private void printMostIncapableArcher() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~ MOST INCAPABLE ARCHER ~~~~~~~~~~~~~~~~~~~~~~");
        Archer a = null;
        int numberOfMissedShoots = 0;

        for (Archer archer : this.archers) {
            if (archer.getMissedShoots() > numberOfMissedShoots) {
                numberOfMissedShoots = archer.getMissedShoots();
                a = archer;
            }
        }

        System.out.println(String.format("Most Incapable Archer: %s, Number of Missed Shoots: %d",
                a.getName(), numberOfMissedShoots));
    }

    private void printWomenByAccuracy() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~ WOMEN RANKING BY POINTS ~~~~~~~~~~~~~~~~~~~~~~");

        for (Map.Entry<ArcherType, Map<Archer, Integer>> e : this.results.entrySet()) {
            Map<Archer, Integer> innerMap = e.getValue();
            List<Map.Entry<Archer, Integer>> list = new ArrayList<>(innerMap.entrySet());
            list.sort((a1, a2) -> a2.getValue() - a1.getValue());

            int maxPoints = list.get(0).getValue();

            System.out.println("Category: " + e.getKey());
            for (Map.Entry<Archer, Integer> archerInfo : list) {
                if (archerInfo.getKey().getGender().equalsIgnoreCase("Male")) {
                    continue;
                }
                double percentagePoints = archerInfo.getKey().getPoints() * 1.0 / maxPoints * 100.0;
                System.out.println(String.format("%s, Points Percentage: %.2f",
                        archerInfo.getKey().getName(), percentagePoints));
            }
        }
    }

    private void printMenWithCarbonBowsByYearsExperience() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~ MEN WITH CARBON BOW BY EXPERIENCE ~~~~~~~~~~~~~~~~~~~~~~");
        TreeSet<Archer> archers = new TreeSet<>((a1, a2) -> {
            if (a1.getExperience() == a2.getExperience()) {
                return 1;
            }
            return a1.getExperience() - a2.getExperience();
        });
        archers.addAll(this.archers);

        for (Archer archer : archers) {
            if (!archer.getGender().equalsIgnoreCase("Male")) {
                continue;
            }

            if ("Carbon".equalsIgnoreCase(archer.getBow().getBowType())) {
                archer.printArcherInfo();
            }
        }
    }
}
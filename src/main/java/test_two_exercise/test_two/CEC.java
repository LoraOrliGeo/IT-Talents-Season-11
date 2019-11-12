package test_two_exercise.test_two;



import test_two_exercise.test_two.voters.Voter;

import java.util.*;

public class CEC {
    // Central Election Commission

    private List<Voter> voters;
    private List<Ballot> ballots;
    private Map<String, Map<String, Integer>> ranking;

    public CEC() {
        this.voters = new ArrayList<>();
        this.ballots = new ArrayList<>();
        this.ranking = new HashMap<>();
    }

    public void addVoters(List<Voter> voters) {
        this.voters.addAll(voters);
    }

    public void addBallot(Ballot ballot) {
        this.ballots.add(ballot);
    }

    public void showStatistics() {
        generateRanking();
        printRanking();
        printWinner();
        printTotalVoters();
        printVoteActivity();
        printCitiesByActivity();
    }

    private void printCitiesByActivity() {
        Map<String, Double> activity = new HashMap<>();

    }

    private void printVoteActivity() {
        System.out.println("-------------------- VOTE ACTIVITY --------------------");
        double activity = this.ballots.size() * 100.0 / this.voters.size();
        System.out.println(String.format("%.2f %%", activity));
    }

    private void printTotalVoters() {
        System.out.println("-------------------- TOTAL VOTERS --------------------");
        System.out.println(this.voters.size());
    }

    private void printWinner() {
        String winner = null;
        int maxVotes = 0;
        for (Map.Entry<String, Map<String, Integer>> entry : this.ranking.entrySet()) {
            Map<String, Integer> innerMap = entry.getValue();
            int votes = innerMap.values().stream().mapToInt(Integer::intValue).sum();
            if (votes > maxVotes) {
                maxVotes = votes;
                winner = entry.getKey();
            }
        }

        System.out.println("-------------------- WINNER --------------------");
        System.out.println(winner + " - votes: " + maxVotes);
    }

    private void printRanking() {
        for (Map.Entry<String, Map<String, Integer>> candidate : this.ranking.entrySet()) {
            System.out.println(candidate.getKey() + ": ");
            Map<String, Integer> innerMap = candidate.getValue();
            for (Map.Entry<String, Integer> stats : innerMap.entrySet()) {
                System.out.println("\t" + stats.getKey() + " - " + stats.getValue());
            }
        }
    }

    private void generateRanking() {
        for (Ballot ballot : ballots) {
            String candidateName = ballot.getCandidate().getName();
            ranking.putIfAbsent(candidateName, new HashMap<>());
            String cityName = ballot.getCity();
            ranking.get(candidateName).putIfAbsent(cityName, 0);
            ranking.get(candidateName).put(cityName, ranking.get(candidateName).get(cityName) + 1);
        }
    }
}

package test_two_exercise.test_two.campaigns;

import test_two_exercise.test_two.candidates.Candidate;
import test_two_exercise.test_two.voters.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public abstract class Campaign {
    private static final int MIN_DURATION_DAYS = 20;
    private static final int MAX_DURATION_DAYS = 25;

    private LocalDate dateFrom;
    private LocalDate dateTo;
    private double budget;
    private int durationDays;
    private Candidate candidate;
    protected CampaignType type;

    protected Campaign(double budget, Candidate candidate) {
        this.dateFrom = LocalDate.now();
        setDurationDays();
        setDateTo(durationDays);
        this.budget = budget;
        this.candidate = candidate;
        setCampaignType();
    }

    protected abstract void setCampaignType();

    private void setDurationDays() {
        Random r = new Random();
        this.durationDays = r.nextInt(MAX_DURATION_DAYS - MIN_DURATION_DAYS + 1) + MIN_DURATION_DAYS;
    }

    private void setDateTo(int durationDays) {
        this.dateTo = this.dateFrom.plusDays(durationDays);
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public double getBudget() {
        return budget;
    }

    public int getDurationDays() {
        return durationDays;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public List<Voter> generateVoters() {
        List<Voter> voters = new ArrayList<>();

        for (int i = 0; i < getNumberOfVotersPerDay() * this.durationDays; i++) {
            Voter voter = generateRandomVoter(i);
            voters.add(voter);
        }

        Random r = new Random();
        if (this.type.equals(CampaignType.CRIMINAL)) {
            for (int i = 0; i < voters.size() / 2; i++) {
                double price = 30 + (50 - 30) * r.nextDouble();

                if (price > this.budget) {
                    break;
                }

                this.budget -= price;
                voters.get(i).setBought(true);
            }
        }


        return voters;
    }

    private Voter generateRandomVoter(int i) {
        Random r = new Random();
        List<String> cities = new ArrayList<>(
                Arrays.asList("Sofia", "Plovdiv", "Varna", "Burgas", "Veliko Turnovo", "Panagyurishte"));
        VoterType type = VoterType.values()[r.nextInt(VoterType.values().length)];
        String name = "Random Voter Name" + i;
        String city = cities.get(r.nextInt(cities.size()));
        Voter voter;

        switch (type) {
            case UNLEARNED:
                voter = new UnlearnedVoter(name, city, this.candidate);
                break;
            case MIDDLE_CLASS:
                voter = new MiddleClassVoter(name, city, this.candidate);
                break;
            default:
                voter = new RichVoter(name, city, this.candidate);
                break;
        }

        return voter;
    }

    protected abstract int getNumberOfVotersPerDay();
}

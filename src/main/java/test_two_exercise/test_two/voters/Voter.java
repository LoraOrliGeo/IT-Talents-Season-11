package test_two_exercise.test_two.voters;

import test_two_exercise.test_two.Ballot;
import test_two_exercise.test_two.CEC;
import test_two_exercise.test_two.candidates.Candidate;

import java.util.Random;

public abstract class Voter {
    private String name;
    private VoterGender gender;
    private String city;
    private boolean bought;
    private Candidate candidate;
    protected VoterType type;
    public static CEC cec;

    protected Voter(String name, String city, Candidate candidate) {
        this.name = name;
        setGender();
        this.city = city;
        this.candidate = candidate;
    }

    private void setGender() {
        Random r = new Random();
        this.gender = VoterGender.values()[r.nextInt(VoterGender.values().length)];
    }

    public String getName() {
        return name;
    }

    public VoterGender getGender() {
        return gender;
    }

    public String getCity() {
        return city;
    }

    public boolean isBought() {
        return bought;
    }

    public void setBought(boolean bought) {
        this.bought = bought;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public VoterType getType() {
        return type;
    }

    public void vote() {
        Random r = new Random();
        int chanceWontVote = r.nextInt(100);
        if (chanceWontVote > this.type.getWontVotePercentage()) {
            Ballot ballot = new Ballot(this.getCandidate(), this.getCity());
            cec.addBallot(ballot);
        }
    }
}

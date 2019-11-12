package test_two_exercise.test_two;

import test_two_exercise.test_two.candidates.Candidate;

public class Ballot {
    private Candidate candidate;
    private String city;

    public Ballot(Candidate candidate, String city) {
        this.candidate = candidate;
        this.city = city;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public String getCity() {
        return city;
    }
}

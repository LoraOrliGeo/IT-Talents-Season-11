package test_two_exercise.test_two.voters;

import test_two_exercise.test_two.candidates.Candidate;

public class RichVoter extends Voter {
    public RichVoter(String name, String city, Candidate candidate) {
        super(name, city, candidate);
        this.type = VoterType.RICH;
    }
}

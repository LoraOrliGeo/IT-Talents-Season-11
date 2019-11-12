package test_two_exercise.test_two.voters;

import test_two_exercise.test_two.candidates.Candidate;

public class UnlearnedVoter extends Voter {
    public UnlearnedVoter(String name, String city, Candidate candidate) {
        super(name, city, candidate);
        this.type = VoterType.UNLEARNED;
    }
}

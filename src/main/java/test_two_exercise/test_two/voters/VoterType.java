package test_two_exercise.test_two.voters;

public enum VoterType {
    UNLEARNED(40, 10),
    MIDDLE_CLASS(10, 30),
    RICH(0, 50);

    private int invalidBallotPercentage;
    private int wontVotePercentage;

    VoterType(int invalidBallotPercentage, int wontVotePercentage) {
        this.invalidBallotPercentage = invalidBallotPercentage;
        this.wontVotePercentage = wontVotePercentage;
    }

    public int getInvalidBallotPercentage() {
        return invalidBallotPercentage;
    }

    public int getWontVotePercentage() {
        return wontVotePercentage;
    }
}

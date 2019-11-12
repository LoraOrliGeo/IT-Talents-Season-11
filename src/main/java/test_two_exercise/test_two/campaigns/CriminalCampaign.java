package test_two_exercise.test_two.campaigns;

import test_two_exercise.test_two.candidates.Candidate;

public class CriminalCampaign extends Campaign {
    private static final int NUMBER_OF_VOTERS_PER_DAY = 120;

    public CriminalCampaign(double budget, Candidate candidate) {
        super(budget, candidate);
    }

    @Override
    protected void setCampaignType() {
        this.type = CampaignType.CRIMINAL;
    }

    @Override
    protected int getNumberOfVotersPerDay() {
        return NUMBER_OF_VOTERS_PER_DAY;
    }
}

package test_two_exercise.test_two.candidates;

import test_two_exercise.test_two.campaigns.NormalCampaign;

import java.util.Random;

public class ShowMan extends Candidate {
    public ShowMan(String name, double money) {
        super(name, money);
    }

    @Override
    protected void setEducationType() {
        Random r = new Random();
        this.education = CandidateType.SHOWMAN.getEducations().get(r.nextInt(CandidateType.SHOWMAN.getEducations().size()));
    }

    @Override
    public void setCampaign() {
        this.campaign = new NormalCampaign(this.getMoney(), this);
    }
}

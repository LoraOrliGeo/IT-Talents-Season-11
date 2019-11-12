package test_two_exercise.test_two.candidates;

import test_two_exercise.test_two.campaigns.CriminalCampaign;

import java.util.Random;

public class MafiaMan extends Candidate {
    public MafiaMan(String name, double money) {
        super(name, money);
    }

    @Override
    protected void setEducationType() {
        Random r = new Random();
        this.education = CandidateType.MAFIAMAN.getEducations().get(r.nextInt(CandidateType.MAFIAMAN.getEducations().size()));
    }

    @Override
    public void setCampaign() {
        this.campaign = new CriminalCampaign(this.getMoney(),this);
    }
}

package test_two_exercise.test_two.candidates;

import test_two_exercise.test_two.campaigns.CriminalCampaign;
import test_two_exercise.test_two.campaigns.NormalCampaign;

import java.util.Random;

public class Politician extends Candidate {
    public Politician(String name, double money) {
        super(name, money);
    }

    @Override
    protected void setEducationType() {
        Random r = new Random();
        this.education = CandidateType.POLITICIAN.getEducations().get(r.nextInt(CandidateType.POLITICIAN.getEducations().size()));
    }

    @Override
    public void setCampaign() {
        Random r = new Random();
        int percentChance = r.nextInt(100);
        if (percentChance < 50) {
            this.campaign = new NormalCampaign(this.getMoney(), this);
        } else {
            this.campaign = new CriminalCampaign(this.getMoney(), this);
        }
    }
}

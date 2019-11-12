package test_two_exercise.test_two.candidates;


import test_two_exercise.test_two.campaigns.Campaign;

public abstract class Candidate {
    private String name;
    private double money;
    protected EducationType education;
    protected Campaign campaign;

    protected Candidate(String name, double money) {
        this.name = name;
        setEducationType();
        setCampaign();
        this.money = money;
    }

    protected abstract void setEducationType();

    public Campaign getCampaign() {
        return campaign;
    }

    public abstract void setCampaign();

    public String getName() {
        return name;
    }

    public EducationType getEducation() {
        return education;
    }

    public double getMoney() {
        return money;
    }
}

package test_two_exercise.real_estates.clients;

import test_two_exercise.real_estates.agency.Agent;
import test_two_exercise.real_estates.agency.View;
import test_two_exercise.real_estates.real_estates_types.RealEstate;

import java.util.Random;

public class Buyer extends Client {

    private int budget;
    private View[] views;
    private Agent agent;

    public Buyer(String name, String phone, int budget) {
        super(name, phone);
        setBudget(budget);
        this.views = new View[0];
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    private void setBudget(int budget) {
        // the budget of a buyer is in range 30 000 and 150 000 euro
        if (30_000 <= budget && budget <= 150_000) {
            this.budget = budget;
        }
    }

    public void makeEnquiry() {
        agency.receiveEnquiry(this);
    }

    public void declareView(RealEstate realEstate) {
        if (realEstate.getPrice() < this.budget) {
            View view = new View(realEstate, this.agent, this);
            addView(view);
            this.agent.addView(view);
        } else {
            System.out.println("The real estate can not be viewed - it's not in budget!");
        }
    }

    public void buyRealEstate(RealEstate realEstate) {

        if (realEstate == null) {
            System.out.println("Not a valid real estate!");
            return;
        }

        boolean hasBeenViewed = false;
        for (int i = 0; i < this.views.length; i++) {
            if (views[i].getRealEstate().equals(realEstate)) {
                agency.confirmDeal(this, realEstate);
                hasBeenViewed = true;
                break;
            }
        }

        if (!hasBeenViewed) {
            System.out.println("Real estate has not been viewed!");
        }
    }

    public RealEstate getRandomViewedRealEstate() {
        Random r = new Random();

        if (this.views.length == 0){
            System.out.println("You have not viewed any real estates!");
            return null;
        }
        return this.views[r.nextInt(this.views.length)].getRealEstate();
    }

    private void addView(View view) {

        View[] temp = this.views;
        this.views = new View[temp.length + 1];
        for (int i = 0; i < temp.length; i++) {
            this.views[i] = temp[i];
        }
        this.views[this.views.length - 1] = view;
    }
}

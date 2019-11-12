package test_two_exercise.real_estates.agency;

import test_two_exercise.real_estates.clients.AgencyPerson;
import test_two_exercise.real_estates.clients.Buyer;
import test_two_exercise.real_estates.clients.Seller;

public class Agent extends AgencyPerson {
    private Seller[] sellers;
    private Buyer[] buyers;
    private View[] views;

    public Agent(String name, String phone) {
        super(name, phone);
        this.buyers = new Buyer[0];
        this.sellers = new Seller[0];
        this.views = new View[0];
    }

    public void addSeller(Seller seller) {
        if(seller == null){
            System.out.println("The seller can not be added to agent's list of sellers!");
            return;
        }
        Seller[] temp = this.sellers;
        this.sellers = new Seller[temp.length + 1];
        for (int i = 0; i < temp.length; i++) {
            this.sellers[i] = temp[i];
        }
        this.sellers[this.sellers.length - 1] = seller;
    }

    public void addBuyer(Buyer buyer) {
        if(buyer == null){
            System.out.println("The buyer can not be added to agent's list of buyers!");
            return;
        }
        Buyer[] temp = this.buyers;
        this.buyers = new Buyer[temp.length + 1];
        for (int i = 0; i < temp.length; i++) {
            this.buyers[i] = temp[i];
        }
        this.buyers[this.buyers.length - 1] = buyer;
    }

    public void addView(View view) {

        if(view == null){
            System.out.println("The view can not be added to agent's list of views!");
            return;
        }

        View[] temp = this.views;
        this.views = new View[temp.length + 1];
        for (int i = 0; i < temp.length; i++) {
            this.views[i] = temp[i];
        }
        this.views[this.views.length - 1] = view;
    }

    @Override
    public String toString() {
        return String.format("Agent: %s%nMoney: %.2f", this.getName(), this.getMoney());
    }
}

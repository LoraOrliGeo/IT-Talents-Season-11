package test_two_exercise.real_estates.clients;

import test_two_exercise.real_estates.agency.Agent;
import test_two_exercise.real_estates.real_estates_types.RealEstate;

public class Seller extends Client {
    private RealEstate realEstate;

    public Seller(String name, String phone, RealEstate realEstate) {
        super(name, phone);
        setRealEstate(realEstate);
        this.realEstate.setOwner(this);
    }

    private void setRealEstate(RealEstate realEstate) {
        if (realEstate != null) {
            this.realEstate = realEstate;
        }
    }

    public void registerRealEstate() {
        agency.registerRealEstate(this.realEstate);
    }
}

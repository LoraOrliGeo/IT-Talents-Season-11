package test_two_exercise.real_estates.agency;

import test_two_exercise.real_estates.clients.Buyer;
import test_two_exercise.real_estates.real_estates_types.RealEstate;

import java.time.LocalDate;

public class View {
    private RealEstate realEstate;
    private Agent agent;
    private Buyer buyer;
    private LocalDate dateView;

    public View(RealEstate realEstate, Agent agent, Buyer buyer) {
        this.realEstate = realEstate;
        this.agent = agent;
        this.buyer = buyer;
        this.dateView = LocalDate.now();
    }

    public RealEstate getRealEstate() {
        return this.realEstate;
    }
}

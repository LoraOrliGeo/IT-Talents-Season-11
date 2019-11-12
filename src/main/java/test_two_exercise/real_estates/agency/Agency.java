package test_two_exercise.real_estates.agency;

import test_two_exercise.real_estates.clients.Buyer;
import test_two_exercise.real_estates.clients.Client;
import test_two_exercise.real_estates.real_estates_types.RealEstate;

import java.util.Random;

public class Agency {
    private static final int NUMBER_OF_AGENTS = 5;
    private static final int NUMBER_OF_REAL_ESTATES_IN_CATALOGUE = 30;

    private String name;
    private String address;
    private String phone;
    private Agent[] agents;
    private RealEstate[] catalogue;
    private double money;

    public Agency(String name, String address, String phone) {
        setName(name);
        setAddress(address);
        setPhone(phone);
        this.agents = new Agent[NUMBER_OF_AGENTS];
        addAgents();
        this.catalogue = new RealEstate[NUMBER_OF_REAL_ESTATES_IN_CATALOGUE];
    }

    private void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
    }

    private void setAddress(String address) {
        if (address != null && !address.isEmpty()) {
            this.address = address;
        }
    }

    private void setPhone(String phone) {
        if (phone != null && !phone.isEmpty()) {
            this.phone = phone;
        }
    }

    private void addAgents() {
        for (int i = 0; i < NUMBER_OF_AGENTS; i++) {
            if (agents[i] == null) {
                agents[i] = new Agent("Agent " + (i + 1), "555-77-23");
            }
        }
    }

    public Agent getRandomAgent() {
        Random r = new Random();
        return this.agents[r.nextInt(this.agents.length)];
    }

    public RealEstate getRandomRealEstate() {
        Random r = new Random();
        return this.catalogue[r.nextInt(this.catalogue.length)];
    }

    public void addRealEstateToCatalogue(RealEstate realEstate) {
        if (realEstate != null) {
            for (int i = 0; i < this.catalogue.length; i++) {
                if (catalogue[i] == null) {
                    catalogue[i] = realEstate;
                    return;
                }
            }
        }
        System.out.println("The real estate can not be added to catalogue!");
    }

    public void receiveMoney(double money) {
        if (money > 0) {
            this.money += money;
        }
    }

    public double getMoney() {
        return this.money;
    }

    public void printAgentsRanking(){
        for (int i = 0; i < agents.length; i++) {
            for (int j = 0; j < agents.length-1-i; j++) {
                if(agents[j].getMoney() < agents[j+1].getMoney()){
                    Agent temp = agents[j];
                    agents[j] = agents[j+1];
                    agents[j+1] = temp;
                }
            }
        }

        for (int i = 0; i < agents.length; i++) {
            System.out.println(agents[i]);
        }
    }

    public void registerRealEstate(RealEstate realEstate) {
        // add the real estate to agency's catalogue
        addRealEstateToCatalogue(realEstate);
        // assign random agent from agency
        Agent agent = getRandomAgent();
        realEstate.setAgent(agent);
        agent.addSeller(realEstate.getOwner());
    }

    public void receiveEnquiry(Buyer buyer) {
        Agent agent = getRandomAgent();
        buyer.setAgent(agent);
        agent.addBuyer(buyer);
    }

    public void confirmDeal(Buyer buyer, RealEstate realEstate) {
        double agencyCommission = realEstate.getPrice() * Client.COMMISSION_PERCENTAGE;
        buyer.spendMoney(agencyCommission + realEstate.getPrice());
        receiveMoney(agencyCommission);
        buyer.getAgent().receiveMoney(agencyCommission / 2);

        realEstate.getOwner().spendMoney(agencyCommission);
        realEstate.getOwner().receiveMoney(realEstate.getPrice());
        realEstate.getAgent().receiveMoney(agencyCommission / 2);

        System.out.println(String.format("%s bought %s",
                buyer.getName(), realEstate.getClass().getSimpleName()));
    }
}
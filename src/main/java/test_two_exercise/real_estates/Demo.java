package test_two_exercise.real_estates;

import test_two_exercise.real_estates.agency.Agency;
import test_two_exercise.real_estates.clients.Buyer;
import test_two_exercise.real_estates.clients.Client;
import test_two_exercise.real_estates.clients.Seller;
import test_two_exercise.real_estates.real_estates_types.Apartment;
import test_two_exercise.real_estates.real_estates_types.House;
import test_two_exercise.real_estates.real_estates_types.Land;
import test_two_exercise.real_estates.real_estates_types.RealEstate;

import java.util.Random;

public class Demo {
    public static void main(String[] args) {

        Agency agency = new Agency("Talents Estate", "Maystor Alexi Rilec 38", "888-999-111");
        Client.agency = agency;
        // create 30 sellers

        Random r = new Random();

        for (int i = 0; i < 30; i++) {
            RealEstate realEstate = null;
            int chance = r.nextInt(3);

            switch (chance) {
                case 0:
                    realEstate = new Apartment("description", "address",
                            r.nextInt(80000) + 70000, "двустаен", 80, "панел");
                    break;
                case 1:
                    realEstate = new House("description", "address",
                            r.nextInt(30000) + 50000, "цяла къща", 160,
                            "тухла", 2, 30);
                    break;
                case 2:
                    realEstate = new Land("description", "address",
                            r.nextInt(55000) + 30000, "гора", 300, r.nextBoolean());
                    break;
            }

            Seller s = new Seller("Seller " + (i + 1), "+359888889966", realEstate);
            s.registerRealEstate();
        }

        for (int i = 0; i < 10; i++) {
            Buyer buyer = new Buyer("Buyer " + (i + 1),
                    "+359891234567", r.nextInt(120_000) + 30_000);

            buyer.makeEnquiry();

            for (int j = 0; j < 3; j++) {
                buyer.declareView(agency.getRandomRealEstate());
            }

            buyer.buyRealEstate(buyer.getRandomViewedRealEstate());
        }

        System.out.println("~~~~~ Agency Income ~~~~~");
        System.out.println(agency.getMoney());

        System.out.println("~~~~~ Agents Ranking ~~~~~");
        agency.printAgentsRanking();
    }
}

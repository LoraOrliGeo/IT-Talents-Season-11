package test_two_exercise.archery_club;

import test_two_exercise.archery_club.archers.Archer;
import test_two_exercise.archery_club.archers.JuniorArcher;
import test_two_exercise.archery_club.archers.SeniorArcher;
import test_two_exercise.archery_club.archers.VeteranArcher;
import test_two_exercise.archery_club.bows.AluminiumBow;
import test_two_exercise.archery_club.bows.CarbonBow;
import test_two_exercise.archery_club.bows.ISeniorBow;
import test_two_exercise.archery_club.bows.WoodenBow;

import java.util.Random;

public class Demo {
    public static void main(String[] args) {

        Club club = new Club("IT Archer", "Alexi Rilec", "Krasi Stoev");
        Random r = new Random();

        String[] genders = {"male", "female"};
        String[] manufacturers = {"Hoyt", "Samick", "Bear", "Black Widow", "Predator"};

        for (int i = 0; i < 40; i++) {
            int chanceArcherType = r.nextInt(3);
            Archer archer = null;
            String name = "Archer " + (i + 1);
            String gender = genders[r.nextInt(genders.length)];
            int age = r.nextInt(41) + 12;
            String manufacturer = manufacturers[r.nextInt(manufacturers.length)];

            switch (chanceArcherType) {
                case 0:
                    WoodenBow woodenBow = new WoodenBow(manufacturer, 2, r.nextInt(10) + 20);
                    archer = new JuniorArcher(name, gender, age, woodenBow, r.nextInt(2) + 1, 2);
                    break;
                case 1:
                    boolean aluminiumBow = r.nextBoolean();
                    ISeniorBow bow = null;
                    if (aluminiumBow) {
                        bow = new AluminiumBow(manufacturer, 2.5, r.nextInt(15) + 25);
                    } else {
                        bow = new CarbonBow(manufacturer, 2.5, r.nextInt(20) + 28);
                    }
                    archer = new SeniorArcher(name, gender, age, bow, r.nextInt(7) + 3, 6);
                    break;
                case 2:
                    CarbonBow carbonBow = new CarbonBow(manufacturer, 3, r.nextInt(20) + 28);
                    archer = new VeteranArcher(name, gender, age, carbonBow, r.nextInt(10) + 10, 9);
                    break;
            }

            club.addArcher(archer);
        }

        club.startTournament();
    }
}

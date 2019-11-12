package test_two_exercise.vignettes;

import test_two_exercise.vignettes.vehicles.Vehicle;
import test_two_exercise.vignettes.vehicles.VignetteType;

import java.time.LocalDate;
import java.util.*;

public class GasStation {
    private static final int NUMBER_OF_VIGNETTES = 10000;

    private double dailyProfit;
    private List<Vignette> vignettes;

    public GasStation() {
        this.vignettes = generateVignettes();
        this.dailyProfit = 0;
    }

    public double getDailyProfit() {
        return this.dailyProfit;
    }

    private List<Vignette> generateVignettes() {
        List<Vignette> vignettes = new ArrayList<>();
        Random r = new Random();

        for (int i = 0; i < NUMBER_OF_VIGNETTES; i++) {
            VignetteType type = VignetteType.values()[r.nextInt(VignetteType.values().length)];
            PeriodType period = PeriodType.values()[r.nextInt(PeriodType.values().length)];
            vignettes.add(new Vignette(type, period));
        }

        vignettes.sort(Comparator.comparingInt(Vignette::getPrice));
        return vignettes;
    }

    public Vignette sellVignette(Vehicle vehicle, PeriodType period) {

        if (vehicle == null || period == null) {
            return null;
        }

        for (int i = 0; i < vignettes.size(); i++) {
            Vignette vignette = vignettes.get(i);
            if(vehicle.getType().equals(vignette.getVehicleType()) && period.equals(vignette.getPeriod())){
                vignette.setDateOfIssue(LocalDate.now());
                dailyProfit += vignette.getPrice();
                vignettes.remove(i);
                return vignette;
            }
        }

        System.out.println("We don't have vignette for you!");
        return null;
    }

    public void printVignettes() {
        System.out.println(String.format("Total vignettes: %d", vignettes.size()));
//        for (Vignette vignette : this.vignettes) {
//            System.out.println(
//                    vignette.getType() + " - " +
//                            vignette.getType().getColor() + " - " +
//                            vignette.getPrice());
//        }
    }
}

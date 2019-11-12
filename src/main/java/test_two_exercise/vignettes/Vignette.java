package test_two_exercise.vignettes;

import test_two_exercise.vignettes.vehicles.VehicleType;
import test_two_exercise.vignettes.vehicles.VignetteType;

import java.time.LocalDate;

public class Vignette {

    private VignetteType type;
    private PeriodType period;
    private int price;
    private LocalDate dateOfIssue;
    private LocalDate dateOfExpire;

    public Vignette(VignetteType type, PeriodType period) {
        this.type = type;
        this.period = period;
        setPrice();
    }

    public int getPrice() {
        return this.price;
    }

    private void setPrice() {
        switch (this.period) {
            case DAY:
                this.price = this.type.getDailyPrice();
                break;
            case MONTH:
                this.price = this.type.getMonthlyPrice();
                break;
            default:
                this.price = this.type.getYearlyPrice();
        }
    }

    public VignetteType getType() {
        return this.type;
    }

    public PeriodType getPeriod() {
        return this.period;
    }

    public LocalDate getDateOfIssue() {
        return this.dateOfIssue;
    }

    public void setDateOfIssue(LocalDate dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
        setDateOfExpire();

    }

    public LocalDate getDateOfExpire() {
        return dateOfExpire;
    }

    private void setDateOfExpire() {
        switch (period){
            case DAY:
                this.dateOfExpire = this.dateOfIssue.plusDays(1);
                break;
            case MONTH:
                this.dateOfExpire = this.dateOfIssue.plusMonths(1);
                break;
            default:
                this.dateOfExpire = this.dateOfIssue.plusYears(1);
        }
    }

    public int stick() {
        return this.type.getStickTime();
    }

    public VehicleType getVehicleType(){
        return this.type.getVehicleType();
    }
}

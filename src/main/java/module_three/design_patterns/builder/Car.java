package module_three.design_patterns.builder;

public class Car {
    private String color;
    private boolean fancyRims;
    private String lightsColor;
    private boolean gasBottle;
    private boolean electricCharger;
    private int tyres;

    //wither -> something like setter but returns new instance of the object with set field
    public Car withFancyRims(boolean fancyRims) {
        this.fancyRims = fancyRims;
        return this;
    }

    public Car withLightColor(String lightColor) {
        this.lightsColor = lightColor;
        return this;
    }

    public Car withElectricCharger() {
        this.electricCharger = true;
        this.gasBottle = false;
        return this;
    }
}

package module_three.test_three_exercise.lutenica.model;

public enum Vegetable {
    TOMATO(3),
    PEPPER(6),
    EGGPLANT(9);

    private int preparationTime;

    Vegetable(int preparationTime) {
        this.preparationTime = preparationTime;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    static public String getVeggieTypeAsString(Vegetable vegetable) {
        switch (vegetable) {
            case PEPPER:
                return "pepper";
            case TOMATO:
                return "tomato";
            default:
                return "eggplant";
        }
    }
}

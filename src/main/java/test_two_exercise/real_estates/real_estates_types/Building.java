package test_two_exercise.real_estates.real_estates_types;

public abstract class Building extends RealEstate{

    protected static final String[] CONSTRUCTION_TYPES = {"ЕПК", "тухла", "панел", "кирпич"};
    private String constructionType;

    public Building(String description, String address, double price, String type, double area, String constructionType) {
        super(description, address, price, type, area);
        this.constructionType = constructionType;
    }

    public String getConstructionType() {
        return constructionType;
    }

    public void setConstructionType(String constructionType) {
        for (int i = 0; i < CONSTRUCTION_TYPES.length; i++) {
            if (CONSTRUCTION_TYPES[i].equalsIgnoreCase(constructionType)) {
                this.constructionType = constructionType;
                return;
            }
        }
        System.out.println("The construction type of the real estate is not valid!");
    }
}

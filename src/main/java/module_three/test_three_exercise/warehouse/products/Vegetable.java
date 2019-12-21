package module_three.test_three_exercise.warehouse.products;

import java.util.Arrays;

public class Vegetable extends Product {

    public enum VegeKind implements IKind {
        potato, cucumber, eggplant;

        @Override
        public ProductType getType() {
            return ProductType.VEGETABLE;
        }
    }

    public Vegetable(IKind name) {
        super(name);
    }

    @Override
    protected boolean isValidName(IKind name) {
        return Arrays.asList(VegeKind.values()).contains(name);
    }

    @Override
    public void setProductType() {
        this.type = ProductType.VEGETABLE;
    }
}

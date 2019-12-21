package module_three.test_three_exercise.warehouse.products;

import java.util.Arrays;

public class Meat extends Product {

    public enum MeatKind implements IKind {
        meat, pork, chicken;

        @Override
        public ProductType getType() {
            return ProductType.MEAT;
        }
    }

    public Meat(IKind name) {
        super(name);
    }

    @Override
    protected boolean isValidName(IKind name) {
        return Arrays.asList(MeatKind.values()).contains(name);
    }

    @Override
    public void setProductType() {
        this.type = ProductType.MEAT;
    }
}

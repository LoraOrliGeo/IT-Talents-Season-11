package module_three.test_three_exercise.warehouse.products;

import java.util.Arrays;

public class Fruit extends Product {

    public enum FruitKind implements IKind {
        apple, banana, orange;

        @Override
        public ProductType getType() {
            return ProductType.FRUIT;
        }
    }

    public Fruit(IKind name) {
        super(name);
    }

    @Override
    protected boolean isValidName(IKind name) {
        return Arrays.asList(FruitKind.values()).contains(name);
    }

    @Override
    public void setProductType() {
        this.type = ProductType.FRUIT;
    }
}

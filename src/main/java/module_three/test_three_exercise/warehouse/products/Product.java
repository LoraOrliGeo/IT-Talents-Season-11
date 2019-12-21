package module_three.test_three_exercise.warehouse.products;

public abstract class Product {

    public enum ProductType {
        FRUIT,
        VEGETABLE,
        MEAT;
    }

    private IKind name;
    protected ProductType type;

    public Product(IKind name) {
        if(isValidName(name)){
            this.name = name;
        }
        setProductType();
    }

    protected abstract boolean isValidName(IKind name);

    public abstract void setProductType();

    public IKind getName() {
        return this.name;
    }

    public ProductType getType() {
        return this.type;
    }
}

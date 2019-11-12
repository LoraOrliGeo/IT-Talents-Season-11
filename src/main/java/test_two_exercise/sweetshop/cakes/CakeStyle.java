package test_two_exercise.sweetshop.cakes;

import java.util.Arrays;
import java.util.List;

public enum CakeStyle {
    WEDDING("big", "small", "middle"),
    STANDARD("biscuit", "eclair", "fruit", "chocolate"),
    SPECIAL("anniversary", "company", "commercial"),
    CHILDREN("birthday", "christening", "purveyor");

    List<String> types;

    CakeStyle(String... types) {
        this.types = Arrays.asList(types);
    }

    public List<String> getTypes() {
        return types;
    }
}

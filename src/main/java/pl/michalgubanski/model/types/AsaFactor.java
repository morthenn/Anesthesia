package pl.michalgubanski.model.types;

import java.util.Arrays;
import java.util.List;

public enum AsaFactor {
    ONE("1"), ONE_E("1E"),
    TWO("2"), TWO_E("2E"),
    THREE("3"), THREE_E("3E"),
    FOUR("4"), FOUR_E("4E"),
    FIVE("5"), FIVE_E("5E");

    private String fieldDescription;
    private static final List<AsaFactor> values = Arrays.asList(values());

    AsaFactor(String value) {
        fieldDescription = value;
    }

    public String getFieldDescription() {
        return fieldDescription;
    }

    public static List<AsaFactor> getValues() {
        return values;
    }

}

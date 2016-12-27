package pl.michalgubanski.model.types;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public enum SupervisionType {
    SAMODZIELNIE("sam."), WSPOLUDZIAL("współ.");

    private static final List<SupervisionType> values = Arrays.asList(values());
    private String fieldDescription;

    SupervisionType(String value) {
        fieldDescription = value;
    }

    public String getFieldDescription() {
        return fieldDescription;
    }

    public static List<SupervisionType> getValues() {
        return values;
    }
}

package pl.michalgubanski.model.types;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public enum AnesthesiaTechnique {
    OGOLNE("og"), PODPAJECZYNOWKOWE("pp"), ZEWNATRZOPONOWE("zo"), BLOKADY_NERWOW("bn");

    private static  List<AnesthesiaTechnique> values = Arrays.asList(values());
    private String fieldDescription;

    AnesthesiaTechnique(String value) {
        fieldDescription = value;
    }

    public String getFieldDescription() {
        return fieldDescription;
    }

    public static List<AnesthesiaTechnique> getValues() {
        return values;
    }
}
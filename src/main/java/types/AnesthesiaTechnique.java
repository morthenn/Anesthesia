package types;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public enum AnesthesiaTechnique {
    OGOLNE("og"), PODPAJECZYNOWKOWE("pp"), ZEWNATRZOPONOWE("zo"), BLOKADY_NERWOW("bn");

    private static final List<AnesthesiaTechnique> VALUES = Arrays.asList(values());
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    private final String fieldDescription;

    AnesthesiaTechnique(String value) {
        fieldDescription = value;
    }

    public String getFieldDescription() {
        return fieldDescription;
    }

    public static AnesthesiaTechnique randomField() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }

    public static AnesthesiaTechnique getNameByStringValue(String value) {
        for ( AnesthesiaTechnique e : AnesthesiaTechnique.values() ) {
            if ( value.equals(e.getFieldDescription()) )
                return e;
        }
        return null;
    }

}

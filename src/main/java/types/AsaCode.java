package types;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public enum AsaCode {
    ONE("1"), ONE_E("1E"),
    TWO("2"), TWO_E("2E"),
    THREE("3"), THREE_E("3E"),
    FOUR("4"), FOUR_E("4E"),
    FIVE("5"), FIVE_E("5E");

    private static final List<AsaCode> VALUES = Arrays.asList(values());
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();
    private final String fieldDescription;
    AsaCode code;

    AsaCode(String value) {
        fieldDescription = value;
    }

    public String getFieldDescription() {
        return fieldDescription;
    }

    public static AsaCode randomField() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }

    public static AsaCode getNameByStringValue(String value) {
        for ( AsaCode e : AsaCode.values() ) {
            if ( value.equals(e.getFieldDescription())  )
                return e;
        }
        return null;
    }
}
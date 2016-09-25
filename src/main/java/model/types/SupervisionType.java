package model.types;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

enum SupervisionType {

    SAMODZIELNIE("sam."), WSPOLUDZIAL("współ.");

    private static final List<SupervisionType> VALUES = Arrays.asList(values());
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();
    private final String fieldDescription;

    SupervisionType(String value) {
        fieldDescription = value;
    }

    public String getFieldDescription() {
        return fieldDescription;
    }

    public static SupervisionType randomSupervision() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}


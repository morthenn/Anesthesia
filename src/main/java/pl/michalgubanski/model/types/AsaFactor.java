package pl.michalgubanski.model.types;


public enum AsaFactor {
    ONE("1"), ONE_E("1E"),
    TWO("2"), TWO_E("2E"),
    THREE("3"), THREE_E("3E"),
    FOUR("4"), FOUR_E("4E"),
    FIVE("5"), FIVE_E("5E");

    private String fieldDescription;

    AsaFactor(String value) {
        fieldDescription = value;
    }

    public String getFieldDescription() {
        return fieldDescription;
    }

}

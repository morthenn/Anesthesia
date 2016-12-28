package pl.michalgubanski.model.types;

public enum SupervisionType {
    SAMODZIELNIE("sam."), WSPOLUDZIAL("współ.");

    private String fieldDescription;

    SupervisionType(String value) {
        fieldDescription = value;
    }

    public String getFieldDescription() {
        return fieldDescription;
    }

}

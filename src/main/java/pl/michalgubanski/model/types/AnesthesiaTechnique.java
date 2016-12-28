package pl.michalgubanski.model.types;

public enum AnesthesiaTechnique {
    OGOLNE("og"), PODPAJECZYNOWKOWE("pp"), ZEWNATRZOPONOWE("zo"), BLOKADY_NERWOW("bn");

    private String fieldDescription;

    AnesthesiaTechnique(String value) {
        fieldDescription = value;
    }

    public String getFieldDescription() {
        return fieldDescription;
    }

}
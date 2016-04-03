package types;

public enum AnesthesiaTechnique {
	OGOLNE("og"), PODPAJECZYNOWKOWE("pp"), ZEWNATRZOPONOWE("zo"), BLOKADY_NERWOW("bn");
	
	private final String fieldDescription;

    private AnesthesiaTechnique(String value) {
        fieldDescription = value;
    }

    public String getFieldDescription() {
        return fieldDescription;
    }
}

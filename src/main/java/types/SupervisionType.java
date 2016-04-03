package types;

public enum SupervisionType {

	SAMODZIELNIE("sam."), WSPOLUDZIAL("wspó³.");
	
	private final String fieldDescription;

    private SupervisionType(String value) {
        fieldDescription = value;
    }

    public String getFieldDescription() {
        return fieldDescription;
    }
}


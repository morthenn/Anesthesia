package source;

import org.joda.time.DateTime;

public class Patient {
    private static final String SEPARATOR = "\t";
    private int evidencialNumber;
    private int patientAge;
    private DateTime regDate;
    private String asaFactor;
    private String treatmentType;
    private String anesthesiaTechnique;
    private String supervisionType;

    public Patient(int evidencialNumber, DateTime regDate, int patientAge, String asaFactor, String treatmentType,
                   String anesthesiaTechnique, String supervisionType) {
        this.evidencialNumber = evidencialNumber;
        this.patientAge = patientAge;
        this.regDate = regDate;
        this.asaFactor = asaFactor;
        this.treatmentType = treatmentType;
        this.anesthesiaTechnique = anesthesiaTechnique;
        this.supervisionType = supervisionType;
    }

    public int getEvidencialNumber() {
        return evidencialNumber;
    }

    public int getPatientAge() {
        return patientAge;
    }

    public DateTime getRegDate() {
        return regDate;
    }

    public String getAsaFactor() {
        return asaFactor;
    }

    public String getTreatmentType() {
        return treatmentType;
    }

    public String getAnesthesiaTechnique() {
        return anesthesiaTechnique;
    }

    public void setAnesthesiaTechnique(String anesthesiaTechnique) {
        this.anesthesiaTechnique = anesthesiaTechnique;
    }

    public String getSupervisionType() {
        return supervisionType;
    }

    public void setSupervisionType(String supervisionType) {
        this.supervisionType = supervisionType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return
                sb.append("EvidencialNumber: ")
                        .append(this.getEvidencialNumber())
                        .append("\t Date : ")
                        .append(this.getRegDate().toString("dd/MM/yyyy"))
                        .append("\t AsaCode : ")
                        .append(this.getAsaFactor())
                        .append("\t TreatmentType : ")
                        .append(this.getTreatmentType())
                        .append("\t Technique : ")
                        .append(this.getAnesthesiaTechnique())
                        .append("\t Supervision : ")
                        .append(this.getSupervisionType())
                        .toString();
    }

    @Override
    public int hashCode() {
        final int prime = 27;
        int result = 1;
        result = prime * result + ((anesthesiaTechnique == null) ? 0 : anesthesiaTechnique.hashCode());
        result = prime * result + ((asaFactor == null) ? 0 : asaFactor.hashCode());
        result = prime * result + evidencialNumber;
        result = prime * result + patientAge;
        result = prime * result + ((regDate == null) ? 0 : regDate.hashCode());
        result = prime * result + ((supervisionType == null) ? 0 : supervisionType.hashCode());
        result = prime * result + ((treatmentType == null) ? 0 : treatmentType.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if ( this == obj )
            return true;
        if ( obj == null )
            return false;
        if ( getClass() != obj.getClass() )
            return false;
        Patient other = (Patient) obj;
        if ( anesthesiaTechnique == null ) {
            if ( other.anesthesiaTechnique != null )
                return false;
        } else if ( ! anesthesiaTechnique.equals(other.anesthesiaTechnique) )
            return false;
        if ( asaFactor == null ) {
            if ( other.asaFactor != null )
                return false;
        } else if ( ! asaFactor.equals(other.asaFactor) )
            return false;
        if ( evidencialNumber != other.evidencialNumber )
            return false;
        if ( patientAge != other.patientAge )
            return false;
        if ( regDate == null ) {
            if ( other.regDate != null )
                return false;
        } else if ( ! regDate.equals(other.regDate) )
            return false;
        if ( supervisionType == null ) {
            if ( other.supervisionType != null )
                return false;
        } else if ( ! supervisionType.equals(other.supervisionType) )
            return false;
        if ( treatmentType == null ) {
            if ( other.treatmentType != null )
                return false;
        } else if ( ! treatmentType.equals(other.treatmentType) )
            return false;
        return true;
    }

}

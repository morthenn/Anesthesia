package utils;

import org.joda.time.DateTime;

public class Patient {
    static final int AMOUINT_OF_DATA = 7;
    private int evidencialNumber;
    private int patientAge;
    private DateTime regDate;
    private String asaFactor;
    private String description;
    private String anesthesiaTechnique;
    private String supervisionType;

    public Patient(int evidencialNumber, DateTime regDate, int patientAge, String asaFactor, String Description,
                   String anesthesiaTechnique, String supervisionType) {
        this.evidencialNumber = evidencialNumber;
        this.patientAge = patientAge;
        this.regDate = regDate;
        this.asaFactor = asaFactor;
        this.description = Description;
        this.anesthesiaTechnique = anesthesiaTechnique;
        this.supervisionType = supervisionType;
    }

    public int getEvidencialNumber() {
        return evidencialNumber;
    }

    public int getPatientAge() {
        return patientAge;
    }

    public String getRegDate() {
        return regDate.toString("dd-MM-yyyy");
    }

    public String getAsaFactor() {
        return asaFactor;
    }

    public String getDescription() {
        return description;
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

    public String[] getPatientInfoArray(){
        String[] patientInfo = new String[AMOUINT_OF_DATA];
        patientInfo[0]= String.valueOf(evidencialNumber);
        patientInfo[1]= String.valueOf(patientAge);
        patientInfo[2]= getRegDate();
        patientInfo[3]= asaFactor;
        patientInfo[4]= description;
        patientInfo[5]= anesthesiaTechnique;
        patientInfo[6]= supervisionType;

        return patientInfo;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return
                sb.append("EvidencialNumber: ")
                        .append(this.getEvidencialNumber())
                        .append("\t Date : ")
                        .append(this.getRegDate())
                        .append("\t AsaCode : ")
                        .append(this.getAsaFactor())
                        .append("\t TreatmentType : ")
                        .append(this.getDescription())
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
        result = prime * result + ((description == null) ? 0 : description.hashCode());
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
        if ( description == null ) {
            if ( other.description != null )
                return false;
        } else if ( ! description.equals(other.description) )
            return false;
        return true;
    }
}

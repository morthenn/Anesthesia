package utils;

import org.joda.time.DateTime;
import types.AnesthesiaTechnique;
import types.AsaCode;
import types.SupervisionType;

public class Patient {
    static final int AMOUNT_OF_DATA = 7;
    private int evidentialNumber;
    private int patientAge;
    private DateTime regDate;
    private AsaCode asaCode;
    private String description;
    private AnesthesiaTechnique anesthesiaTechnique;
    private SupervisionType supervisionType;

    public Patient(int evidentialNumber, DateTime regDate, int patientAge, AsaCode asaCode, String description,
                   AnesthesiaTechnique anesthesiaTechnique, SupervisionType supervisionType) {
        this.evidentialNumber = evidentialNumber;
        this.patientAge = patientAge;
        this.regDate = regDate;
        this.asaCode = asaCode;
        this.description = description;
        this.anesthesiaTechnique = anesthesiaTechnique;
        this.supervisionType = supervisionType;
    }

    public int getEvidentialNumber() {
        return evidentialNumber;
    }

    public int getPatientAge() {
        return patientAge;
    }

    public String getRegDate() {
        return regDate.toString("dd-MM-yyyy");
    }

    public AsaCode getAsaCode() {
        return asaCode;
    }

    public String getDescription() {
        return description;
    }

    public AnesthesiaTechnique getAnesthesiaTechnique() {
        return anesthesiaTechnique;
    }

    public void setAnesthesiaTechnique(AnesthesiaTechnique anesthesiaTechnique) {
        this.anesthesiaTechnique = anesthesiaTechnique;
    }

    public SupervisionType getSupervisionType() {
        return supervisionType;
    }

    public void setSupervisionType(SupervisionType supervisionType) {
        this.supervisionType = supervisionType;
    }

    public String[] getPatientInfoArray() {
        String[] patientInfo = new String[AMOUNT_OF_DATA];
        patientInfo[0] = String.valueOf(evidentialNumber);
        patientInfo[1] = String.valueOf(patientAge);
        patientInfo[2] = getRegDate();
        patientInfo[3] = asaCode.getFieldDescription();
        patientInfo[4] = description;
        patientInfo[5] = anesthesiaTechnique.getFieldDescription();
        patientInfo[6] = supervisionType.getFieldDescription();

        return patientInfo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return
                sb.append("EvidencialNumber: ")
                        .append(this.getEvidentialNumber())
                        .append("\t Date : ")
                        .append(this.getRegDate())
                        .append("\t AsaCode : ")
                        .append(this.getAsaCode())
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
        int result = evidentialNumber;
        result = 31 * result + patientAge;
        result = 31 * result + regDate.hashCode();
        result = 31 * result + asaCode.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + anesthesiaTechnique.hashCode();
        result = 31 * result + supervisionType.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;

        Patient patient = (Patient) o;

        if ( evidentialNumber != patient.evidentialNumber ) return false;
        if ( patientAge != patient.patientAge ) return false;
        if ( ! regDate.equals(patient.regDate) ) return false;
        if ( asaCode != patient.asaCode ) return false;
        if ( description != null ? ! description.equals(patient.description) : patient.description != null )
            return false;
        if ( anesthesiaTechnique != patient.anesthesiaTechnique ) return false;
        return supervisionType == patient.supervisionType;

    }
}

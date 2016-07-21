package utils;

import org.joda.time.DateTime;
import types.AnesthesiaTechnique;
import types.AsaCode;
import types.SupervisionType;

public class Patient {
    static final int COLUMNS_AMOUNT = 7;
    private int evidentialNumber;
    private int patientAge;
    private DateTime regDate;
    private AsaCode asaCode;
    private String description;
    private AnesthesiaTechnique anesthesiaTechnique;
    private SupervisionType supervisionType;

    private Patient(PatientBuilder patientBuilder) {
        this.evidentialNumber = patientBuilder.evidentialNumber;
        this.patientAge = patientBuilder.patientAge;
        this.regDate = patientBuilder.regDate;
        this.asaCode = patientBuilder.asaCode;
        this.description = patientBuilder.description;
        this.anesthesiaTechnique = patientBuilder.anesthesiaTechnique;
        this.supervisionType = patientBuilder.supervisionType;
    }

    public int getEvidentialNumber() {
        return evidentialNumber;
    }

    public int getPatientAge() {
        return patientAge;
    }

    public DateTime getRegDate() {
        return regDate;
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

    public SupervisionType getSupervisionType() {
        return supervisionType;
    }


    public String[] getPatientInfoArray() {
        String[] patientInfo = new String[COLUMNS_AMOUNT];
        patientInfo[0] = String.valueOf(evidentialNumber);
        patientInfo[1] = getRegDate().toString("dd-MM-yyyy");
        patientInfo[2] = String.valueOf(patientAge);
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
                        .append("Age: ")
                        .append(this.getPatientAge())
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Patient patient = (Patient) o;

        if (evidentialNumber != patient.evidentialNumber) return false;
        if (patientAge != patient.patientAge) return false;
        if (!regDate.equals(patient.regDate)) return false;
        if (asaCode != patient.asaCode) return false;
        if (description != null ? !description.equals(patient.description) : patient.description != null)
            return false;
        if (anesthesiaTechnique != patient.anesthesiaTechnique) return false;
        return supervisionType == patient.supervisionType;

    }

    public static class PatientBuilder {
        private int evidentialNumber;
        private int patientAge;
        private DateTime regDate;
        private AsaCode asaCode;
        private String description;
        private AnesthesiaTechnique anesthesiaTechnique;
        private SupervisionType supervisionType;

        public PatientBuilder withEvidentialNumber(int evidentialNumber) {
            this.evidentialNumber = evidentialNumber;
            return this;

        }

        public PatientBuilder withAge(int patientAge) {
            this.patientAge = patientAge;
            return this;

        }

        public PatientBuilder withRegisteredDate(DateTime regDate) {
            this.regDate = regDate;
            return this;
        }

        public PatientBuilder withAsaCode(AsaCode asaCode) {
            this.asaCode = asaCode;
            return this;

        }

        public PatientBuilder withDescription(String description) {
            this.description = description;
            return this;

        }

        public PatientBuilder withAnesthesiaTechnique(AnesthesiaTechnique anesthesiaTechnique) {
            this.anesthesiaTechnique = anesthesiaTechnique;
            return this;

        }

        public PatientBuilder withSupervisionType(SupervisionType supervisionType) {
            this.supervisionType = supervisionType;
            return this;

        }

        public Patient build() {
            return new Patient(this);
        }

    }
}

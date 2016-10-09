package model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import dao.PatientManager;
import org.joda.time.DateTime;

import java.io.Serializable;

@DatabaseTable(tableName = "patients", daoClass = PatientManager.class)
public class Patient implements Serializable {
    private static final String SEPARATOR = "\t";

    @DatabaseField(id = true)
    private int id;
    @DatabaseField
    private int evidencialNumber;
    @DatabaseField
    private int patientAge;
    @DatabaseField
    private DateTime regDate;
    @DatabaseField
    private String asaFactor;
    @DatabaseField
    private String treatmentType;
    @DatabaseField
    private String anesthesiaTechnique;
    @DatabaseField
    private String supervisionType;

    public Patient() {
    }

    public Patient(PatientBuilder patientBuilder) {
        this.evidencialNumber = patientBuilder.evidencialNumber;
        this.patientAge = patientBuilder.patientAge;
        this.regDate = patientBuilder.regDate;
        this.asaFactor = patientBuilder.asaFactor;
        this.treatmentType = patientBuilder.treatmentType;
        this.anesthesiaTechnique = patientBuilder.anesthesiaTechnique;
        this.supervisionType = patientBuilder.supervisionType;
    }

    private int getEvidencialNumber() {
        return evidencialNumber;
    }

    private int getPatientAge() {
        return patientAge;
    }

    private DateTime getRegDate() {
        return regDate;
    }

    private String getAsaFactor() {
        return asaFactor;
    }

    private String getTreatmentType() {
        return treatmentType;
    }

    private String getAnesthesiaTechnique() {
        return anesthesiaTechnique;
    }

    private String getSupervisionType() {
        return supervisionType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append(
                this.getEvidencialNumber())
                .append(SEPARATOR).append(this.getRegDate().toString("dd/MM/yyyy"))
                .append(SEPARATOR).append(this.getAsaFactor())
                .append(SEPARATOR).append(this.getTreatmentType())
                .append(SEPARATOR).append(this.getAnesthesiaTechnique())
                .append(SEPARATOR).append(this.getSupervisionType())
                .append(SEPARATOR).append(this.getPatientAge())
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
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Patient other = (Patient) obj;
        if (anesthesiaTechnique == null) {
            if (other.anesthesiaTechnique != null)
                return false;
        } else if (!anesthesiaTechnique.equals(other.anesthesiaTechnique))
            return false;
        if (asaFactor == null) {
            if (other.asaFactor != null)
                return false;
        } else if (!asaFactor.equals(other.asaFactor))
            return false;
        if (evidencialNumber != other.evidencialNumber)
            return false;
        if (patientAge != other.patientAge)
            return false;
        if (regDate == null) {
            if (other.regDate != null)
                return false;
        } else if (!regDate.equals(other.regDate))
            return false;
        if (supervisionType == null) {
            if (other.supervisionType != null)
                return false;
        } else if (!supervisionType.equals(other.supervisionType))
            return false;
        if (treatmentType == null) {
            if (other.treatmentType != null)
                return false;
        } else if (!treatmentType.equals(other.treatmentType))
            return false;
        return true;
    }

    public static class PatientBuilder {
        private int evidencialNumber;
        private int patientAge;
        private DateTime regDate;
        private String asaFactor;
        private String treatmentType;
        private String anesthesiaTechnique;
        private String supervisionType;

        public PatientBuilder setEvidencialNumber(int evidencialNumber) {
            this.evidencialNumber = evidencialNumber;
            return this;
        }

        public PatientBuilder setPatientAge(int patientAge) {
            this.patientAge = patientAge;
            return this;
        }

        public PatientBuilder setRegDate(DateTime regDate) {
            this.regDate = regDate;
            return this;
        }

        public PatientBuilder setAsaFactor(String asaFactor) {
            this.asaFactor = asaFactor;
            return this;
        }

        public PatientBuilder setTreatmentType(String treatmentType) {
            this.treatmentType = treatmentType;
            return this;
        }

        public PatientBuilder setAnesthesiaTechnique(String anesthesiaTechnique) {
            this.anesthesiaTechnique = anesthesiaTechnique;
            return this;
        }

        public PatientBuilder setSupervisionType(String supervisionType) {
            this.supervisionType = supervisionType;
            return this;
        }

        public Patient build() {
            return new Patient(this);
        }
    }


}

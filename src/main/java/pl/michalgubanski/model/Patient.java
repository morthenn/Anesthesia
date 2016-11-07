package pl.michalgubanski.model;

import org.joda.time.DateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Patient {
    private static final String SEPARATOR = "\t";

    @Id
    @GeneratedValue
    private int id;
    private int evidencialNumber;
    private int patientAge;
    private DateTime regDate;
    private String asaFactor;
    private String treatmentType;
    private String anesthesiaTechnique;
    private String supervisionType;

    public Patient() {
    }

    private Patient(PatientBuilder patientBuilder) {
        this.evidencialNumber = patientBuilder.evidencialNumber;
        this.patientAge = patientBuilder.patientAge;
        this.regDate = patientBuilder.regDate;
        this.asaFactor = patientBuilder.asaFactor;
        this.treatmentType = patientBuilder.treatmentType;
        this.anesthesiaTechnique = patientBuilder.anesthesiaTechnique;
        this.supervisionType = patientBuilder.supervisionType;
    }


    public int getId() {
        return id;
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
        return String.valueOf(this.getEvidencialNumber()) +
                SEPARATOR + this.getRegDate().toString("dd/MM/yyyy") +
                SEPARATOR + this.getAsaFactor() +
                SEPARATOR + this.getTreatmentType() +
                SEPARATOR + this.getAnesthesiaTechnique() +
                SEPARATOR + this.getSupervisionType() +
                SEPARATOR + this.getPatientAge();

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

package model;

import org.joda.time.DateTime;

/**
 * Created by Burzanski on 09.10.2016.
 */
public class PatientBuilder {
    private int id;
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



package pl.michalgubanski.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Patient {
    private static final String SEPARATOR = "\t";

    @Id
    @GeneratedValue
    private int id;
    private int evidentialNumber;
    private int patientAge;

    @Column(columnDefinition = "TIMESTAMP")
    private Date registeredDate;
    private String asaFactor;
    private String treatmentType;
    private String anesthesiaTechnique;
    private String supervisionType;

    public Patient() {
    }

    public int getId() {
        return id;
    }

    public int getEvidentialNumber() {
        return evidentialNumber;
    }

    public int getPatientAge() {
        return patientAge;
    }

    public Date getRegisteredDate() {
        return registeredDate;
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

    public String getSupervisionType() {
        return supervisionType;
    }

    public void setEvidentialNumber(int evidentialNumber) {
        this.evidentialNumber = evidentialNumber;
    }

    public void setPatientAge(int patientAge) {
        this.patientAge = patientAge;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    public void setAsaFactor(String asaFactor) {
        this.asaFactor = asaFactor;
    }

    public void setTreatmentType(String treatmentType) {
        this.treatmentType = treatmentType;
    }

    public void setAnesthesiaTechnique(String anesthesiaTechnique) {
        this.anesthesiaTechnique = anesthesiaTechnique;
    }

    public void setSupervisionType(String supervisionType) {
        this.supervisionType = supervisionType;
    }

    @Override
    public String toString() {
        return String.valueOf(this.getEvidentialNumber()) +
                SEPARATOR + this.getRegisteredDate().toString() +
                SEPARATOR + this.getAsaFactor() +
                SEPARATOR + this.getTreatmentType() +
                SEPARATOR + this.getAnesthesiaTechnique() +
                SEPARATOR + this.getSupervisionType() +
                SEPARATOR + this.getPatientAge();

    }
}

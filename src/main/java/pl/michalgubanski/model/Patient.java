package pl.michalgubanski.model;

import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedDate;

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
    private int evidencialNumber;
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

    private int getEvidencialNumber() {
        return evidencialNumber;
    }

    private int getPatientAge() {
        return patientAge;
    }

    private Date getRegisteredDate() {
        return registeredDate;
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

    public void setEvidencialNumber(int evidencialNumber) {
        this.evidencialNumber = evidencialNumber;
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
        return String.valueOf(this.getEvidencialNumber()) +
                SEPARATOR + this.getRegisteredDate().toString() +
                SEPARATOR + this.getAsaFactor() +
                SEPARATOR + this.getTreatmentType() +
                SEPARATOR + this.getAnesthesiaTechnique() +
                SEPARATOR + this.getSupervisionType() +
                SEPARATOR + this.getPatientAge();

    }
}

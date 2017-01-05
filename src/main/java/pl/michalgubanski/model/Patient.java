package pl.michalgubanski.model;

import pl.michalgubanski.model.types.AsaFactor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "Patients")
public class Patient {
    private static final String SEPARATOR = "\t";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private int evidentialNumber;

    @NotNull
    @Min(0)
    @Max(110)
    private int patientAge;

    @Column(columnDefinition = "TIMESTAMP")
    private Date registeredDate;

    @NotNull
    private String asaFactor;

    @Size(max = 255)
    private String treatmentType;

    @NotNull
    private String anesthesiaTechnique;

    @NotNull
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

    public void setAsaFactor(AsaFactor asaFactor) {
        this.asaFactor = asaFactor.getFieldDescription();
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

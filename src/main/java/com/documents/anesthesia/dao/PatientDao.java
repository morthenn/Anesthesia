package controller;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import types.*;
import utils.Patient;

public class PatientDao extends DatabaseCreator {

    private static final String INSERT_PATIENT_QUERY = "INSERT into test3 values (NULL, ?, ?, ?, ?, ?, ?);";

    private static final String SELECT_ALL_PATIENTS_QUERY = "SELECT * FROM test3";

    private static final String EDIT_PATIENT_QUERY = "UPDATE "
            + "test3 SET REGISTERED_DATE = ?,"
            + "AGE = ?,"
            + "ASA_CODE = ?,"
            + "TREATMENT_TYPE = ?,"
            + "ANESTHESIA_TECHNIQUE = ?,"
            + "SUPERVISION_TYPE = ?"
            + "WHERE EVIDENCIAL_NUMBER = ?";

    private static final String REMOVE_PATIENT_QUERY = "DELETE"
            + " FROM test3"
            + " WHERE EVIDENCIAL_NUMBER = ?;";

    private static final DateTimeFormatter DTF = DateTimeFormat.forPattern("dd/MM/yyyy");
    ArrayList<Patient> patients = new ArrayList<Patient>();
    //constructor

    public PatientDao() {
        super();
        patients = selectPatients();
    }


    //methods

    /**
     * Insert new patient into database
     */
    public void insertPatient(Patient patient) {

        PreparedStatement prepStmt;
        try {

            prepStmt = conn.prepareStatement(INSERT_PATIENT_QUERY);
            prepStmt.setDate(1, new Date(patient.getRegDate().getMillis()));
            prepStmt.setInt(2, patient.getPatientAge());
            prepStmt.setString(3, patient.getAsaCode().getFieldDescription());
            prepStmt.setString(4, patient.getDescription());
            prepStmt.setString(5, patient.getAnesthesiaTechnique().getFieldDescription());
            prepStmt.setString(6, patient.getSupervisionType().getFieldDescription());
            prepStmt.execute();

        } catch (SQLException e) {
            System.err.println("Error on patient insertion");
            e.printStackTrace();
        }
        System.out.println("Patient added");
    }


    // TODO Possibility to add not full record of patient /constructors or
    // static methods

    /**
     * Edit patient's details id, date, age, asa, treatment type, anesthesia,
     * supervision
     */
    public void editPatient(int id, String date, int age, AsaCode asaCode, String treatment, AnesthesiaTechnique anesthesia,
                            SupervisionType supervision) {

        String query = EDIT_PATIENT_QUERY;

        DateTime valueDate = DTF.parseDateTime(date);
        PreparedStatement prepStmt;
        java.sql.Date dateSql = new java.sql.Date(valueDate.getMillis());

        try {
            prepStmt = super.conn.prepareStatement(query);
            prepStmt.setDate(1, dateSql);
            prepStmt.setInt(2, age);
            prepStmt.setString(3, asaCode.getFieldDescription());
            prepStmt.setString(4, treatment);
            prepStmt.setString(5, anesthesia.toString());
            prepStmt.setString(6, supervision.getFieldDescription());
            prepStmt.setInt(7, id);
            prepStmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Blad przy edycji pacjenta");
            e.printStackTrace();
        }
        System.out.println("Edycja pacjenta przebiegla pomyslnie");
    }

    /**
     * Remove patient from DB
     */
    public void removePatient(int id) {

        String query = REMOVE_PATIENT_QUERY;

        PreparedStatement prepStmt;

        try {
            prepStmt = super.conn.prepareStatement(query);
            prepStmt.setInt(1, id);
            prepStmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error in patient removal");
            e.printStackTrace();
        }
        System.out.println("Patient removed");
    }

    /**
     * Show list of every registered patient in database
     */
    public ArrayList<Patient> selectPatients() {
        ArrayList<Patient> patients = new ArrayList<Patient>();
        try {
            ResultSet result = super.stat.executeQuery(SELECT_ALL_PATIENTS_QUERY);
            Date dateDate;
            DateTime date;
            int id, age;
            AsaCode asaCode;
            String description;
            AnesthesiaTechnique anesthesiaTechnique;
            SupervisionType supervisionType;

            while (result.next()) {
                id = result.getInt("EVIDENCIAL_NUMBER");
                dateDate = result.getDate("REGISTERED_DATE");
                date = new DateTime(dateDate);
                age = result.getInt("AGE");
                asaCode = AsaCode.getNameByStringValue(result.getString("ASA_CODE"));
                description = result.getString("TREATMENT_TYPE");
                anesthesiaTechnique = AnesthesiaTechnique.getNameByStringValue(result.getString("ANESTHESIA_TECHNIQUE"));
                supervisionType = SupervisionType.getNameByStringValue(result.getString("SUPERVISION_TYPE"));
                patients.add(new Patient.PatientBuilder()
                        .withEvidentialNumber(id)
                        .withRegisteredDate(date)
                        .withAge(age)
                        .withAsaCode(asaCode)
                        .withDescription(description)
                        .withAnesthesiaTechnique(anesthesiaTechnique)
                        .withSupervisionType(supervisionType)
                        .build());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return patients;
    }

    public void showPatientList() {
        for (Patient c : patients)
            System.out.println(c.toString());
    }

    public Patient searchPatientByEvidencialNumber(int id) {
        for (Patient patient : patients) {
            if (patient.getEvidentialNumber() == id)
                return patient;
        }
        return null;
    }
}

package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.joda.time.DateTime;

import source.Patient;

public class MainControl {

    // SQL - queries
    private static final String SELECT_ALL_PATIENTS_QUERY = "SELECT * FROM test3";
    private static final String CREATE_TABLE_QUERY = "CREATE TABLE"
	    + " if not exists test3"
	    + "(EVIDENCIAL_NUMBER INTEGER PRIMARY KEY AUTOINCREMENT,"
	    + "REGISTERED_DATE NUMERIC,"
	    + "AGE INTEGER,"
	    + "ASA_CODE TEXT,"
	    + "TREATMENT_TYPE TEXT,"
	    + "ANESTHESIA_TECHNIQUE TEXT,"
	    + "SUPERVISION_TYPE TEXT)";
    
    // Driver
    private static final String DRIVER = "org.sqlite.JDBC";
    private static final String DB_URL = "jdbc:sqlite:anesthesia.db";
    
    protected Connection conn;
    private Statement stat;

    public MainControl() {

	try {
	    Class.forName(MainControl.DRIVER);
	} catch (ClassNotFoundException e) {
	    System.err.println("Brak sterownika JDBC");
	    e.printStackTrace();
	}
	try {
	    conn = DriverManager.getConnection(DB_URL);
	    stat = conn.createStatement();
	} catch (SQLException e) {
	    System.err.println("Problem z otwarciem polaczenia");
	    e.printStackTrace();
	}

	createTable();
    }

    /**
     * Creates table if it dont exist
     */

    public boolean createTable() {
	String createTable = CREATE_TABLE_QUERY;

	try {
	    stat.execute(createTable);
	} catch (SQLException e) {
	    System.err.println("Blad przy tworzeniu tabeli");
	    e.printStackTrace();
	    return false;
	}
	return true;
    }
    
    /**
     * Show list of every registered patient in database
     */
    public ArrayList<Patient> selectPatients() {
	ArrayList<Patient> patients = new ArrayList<Patient>();
	try {
	    ResultSet result = stat.executeQuery(SELECT_ALL_PATIENTS_QUERY);
	    Date dateDate;
	    DateTime date;
	    int id, age;
	    String asaCode, treatmentType, anesthesiaTechnique, supervisionType;

	    while (result.next()) {
		id = result.getInt("EVIDENCIAL_NUMBER");
		dateDate = result.getDate("REGISTERED_DATE");
		date = new DateTime(dateDate);
		age = result.getInt("AGE");
		asaCode = result.getString("ASA_CODE");
		treatmentType = result.getString("TREATMENT_TYPE");
		anesthesiaTechnique = result.getString("ANESTHESIA_TECHNIQUE");
		supervisionType = result.getString("SUPERVISION_TYPE");
		patients.add(new Patient(id, date, age, asaCode, treatmentType, anesthesiaTechnique, supervisionType));
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	    return null;
	}
	return patients;
    }
}
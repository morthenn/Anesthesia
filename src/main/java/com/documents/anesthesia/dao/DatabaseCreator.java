package com.documents.anesthesia.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseCreator {

    // SQL - queries
    private static final String CREATE_TEST_TABLE_QUERY = "CREATE TABLE"
            + " if not exists test3"
            + "(EVIDENCIAL_NUMBER INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "REGISTERED_DATE DATE,"
            + "AGE INTEGER,"
            + "ASA_CODE TEXT,"
            + "TREATMENT_TYPE TEXT,"
            + "ANESTHESIA_TECHNIQUE TEXT,"
            + "SUPERVISION_TYPE TEXT)";

    private static final String CREATE_TABLE_QUERY = "CREATE TABLE"
            + " if not exists prod"
            + "(EVIDENCIAL_NUMBER INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "REGISTERED_DATE DATE,"
            + "AGE INTEGER,"
            + "ASA_CODE TEXT,"
            + "TREATMENT_TYPE TEXT,"
            + "ANESTHESIA_TECHNIQUE TEXT,"
            + "SUPERVISION_TYPE TEXT)";

    // Driver
    private static final String DRIVER = "org.sqlite.JDBC";
    private static final String DB_URL = "jdbc:sqlite:anesthesia.db";

    Connection conn;
    Statement stat;

    //constructor
    DatabaseCreator() {
        try {
            Class.forName(DatabaseCreator.DRIVER);
        } catch ( ClassNotFoundException e ) {
            System.err.println("Brak sterownika JDBC");
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection(DB_URL);
            stat = conn.createStatement();
        } catch ( SQLException e ) {
            System.err.println("Problem z otwarciem polaczenia");
            e.printStackTrace();
        }

        createTablesIfNotExists();
    }

    //methods

    /**
     * Creates table if it doesn't exist
     */

    private boolean createTablesIfNotExists() {
        try {
            stat.execute(CREATE_TEST_TABLE_QUERY);
            stat.execute(CREATE_TABLE_QUERY);
        } catch ( SQLException e ) {
            System.err.println("Blad przy tworzeniu tabeli");
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
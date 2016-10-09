package db;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.table.TableUtils;
import model.Patient;

import java.sql.SQLException;

public class DatabaseConnection {

    private static final String DB_URL = "jdbc:sqlite:patients.db";
    private static JdbcConnectionSource conn = null;

    private DatabaseConnection() {
    }

    public static JdbcConnectionSource createConnection() throws SQLException {
        if (conn == null) {
            conn = new JdbcConnectionSource(DB_URL);
            TableUtils.createTableIfNotExists(conn, Patient.class);
        }
        return conn;
    }

    public static boolean closeConnetion() throws SQLException {
        if (conn != null) {
            conn.close();
            return true;
        }
        else return false;
    }

}

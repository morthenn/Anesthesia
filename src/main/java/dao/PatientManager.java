package dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import model.Patient;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

public class PatientManager extends BaseDaoImpl implements Dao {
    private static final Logger LOG = Logger.getLogger( PatientManager.class.getName() );

    public PatientManager(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, model.Patient.class);
    }

    public boolean addPatient(Patient patient) {
        try {
            create(patient);
            LOG.info("Patient succesfully added");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean removePatient(Patient patient) {
        try {
            delete(patient);
            LOG.info("Patient deleted succesfully");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updatePatient(Patient patient) {
        try {
            update(patient);
            LOG.info("Patient's info updated");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Patient> selectAll() {
        try {
            LOG.info("Calling selectAll");
            return queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
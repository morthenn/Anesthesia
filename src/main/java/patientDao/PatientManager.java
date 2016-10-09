package patientDao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import model.Patient;
import java.sql.SQLException;
import java.util.List;

public class PatientManager extends BaseDaoImpl implements PatientDao {
    PatientDao patientDao;

    public PatientManager(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, model.Patient.class);
    }

    public boolean addPatient(Patient patient) {
        try {
            patientDao.create(patient);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean removePatient(Patient patient) {
        try {
            patientDao.delete(patient);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updatePatient(Patient patient) {
        try {
            patientDao.update(patient);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Patient> selectAll() {
        try {
            return patientDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
import db.DatabaseConnection;
import model.Patient;
import model.PatientBuilder;
import org.joda.time.DateTime;
import patientDao.PatientManager;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        PatientManager pm = new PatientManager(DatabaseConnection.createConnection());
        Patient p = new PatientBuilder()
                .setEvidencialNumber(997)
                .setPatientAge(17)
                .setAsaFactor("5A")
                .setRegDate(DateTime.now())
                .setSupervisionType("bez niczego")
                .setTreatmentType("mlotkiem w leb")
                .setAnesthesiaTechnique("kekeke")
                .build();
        pm.addPatient(p);
        for (Object entry : pm.selectAll()){
            System.out.println(entry);
        }

    }

}

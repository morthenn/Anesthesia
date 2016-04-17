import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import controller.PatientDao;
import org.joda.time.DateTime;
import types.AnesthesiaTechnique;
import types.AsaCode;
import types.SupervisionType;
import utils.Exporter;
import utils.Patient;

public class Main {
    private static PatientDao patientDao = new PatientDao();
    private static Exporter exp = new Exporter();

    public static void main(String[] args) {
//
//                for (int i = 0; i < 112; i++) {
//            int randomAge = getRandomInRange(5, 95);
//            patientDao.insertPatient(DateTime.now().plusDays(-getRandomInRange(1, 20)), randomAge, AsaCode.randomField(), "Opis zabiegu po operacji", AnesthesiaTechnique.randomField(), SupervisionType.randomField());
//        }
        patientDao.showPatientList();

        exp.createXlsFileFromList(patientDao.selectPatients()).exportFile();


//	patientDao.editPatient(12, "06/09/2016", 27, AsaCode.ONE, "EDIT", AnesthesiaTechnique.PODPAJECZYNOWKOWE, SupervisionType.SAMODZIELNIE);

//	patientDao.removePatient(14);

    }


    private static int getRandomInRange(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }


}
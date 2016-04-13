import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import controller.PatientDao;
import org.joda.time.DateTime;
import utils.Exporter;
import utils.Patient;

public class Main {

    public static void main(String[] args) {

        PatientDao patientDao = new PatientDao();

        int temp =2;
        temp =3;
        DateTime currentDate = new DateTime();
        System.out.println(currentDate);
//        for ( int i = 0; i < 10; i++ ) {
//            int randomAge = getRandomInRange(5, 95);
//
//            patientDao.insertPatient(currentDate.plusDays(- randomAge + randomAge - 7), randomAge, AsaCode.randomField(), "Opis zabiegu po operacji", AnesthesiaTechnique.randomField(), SupervisionType.randomField());
//
//        }

        ArrayList<Patient> patients = patientDao.selectPatients();
        showPatientList(patients);

        Exporter exp = new Exporter();
        exp.createXlsFileFromList(patients).exportFile();


////	p.editPatient(12, "06/09/2016", 27, "5", "Last lastowo", AnesthesiaTechnique.PODPAJECZYNOWKOWE, "sam");
//	System.out.println();
//	patients = p.selectPatients();
//	showPatientList(patients);
//	System.out.println();
//	System.out.println("Po usunieciu numeru 14");
//	p.removePatient(14);

//	patients = p.selectPatients();
//	showPatientList(patients);
    }

    private static int getRandomInRange(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    private static void showPatientList(List<Patient> patients) {
        for ( Patient c : patients )
            System.out.println(c.toString());
    }
}
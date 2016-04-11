package controller;

import java.util.List;

import org.joda.time.DateTime;
import types.AnesthesiaTechnique;
import types.AsaCode;
import types.SupervisionType;
import utils.Patient;

public class MainController {

    public static void main(String[] args) {

        PatientDao patientDao = new PatientDao();

        DateTime currentDate = new DateTime();
        System.out.println(currentDate);
        for ( int i = 0; i < 10; i++ ) {
            int randomAge = getRandomInRange(5, 95);

//            patientDao.insertPatient(currentDate.plusDays(- randomAge + randomAge - 7), randomAge, AsaCode.randomField(), "Opis zabiegu po operacji", AnesthesiaTechnique.randomField(), SupervisionType.randomField());

        }

        List<Patient> patients = patientDao.selectPatients();
        showPatientList(patients);

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
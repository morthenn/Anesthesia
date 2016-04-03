package source;

import java.util.List;
import java.util.Random;

import org.joda.time.DateTime;
import controller.PatientControl;
import types.AnesthesiaTechnique;
import types.SupervisionType;

public class Test {

    public static void main(String[] args) {

        PatientControl pc = new PatientControl();
        DateTime currentDate = new DateTime();
        System.out.println(currentDate);
        for (int i = 0; i < 30; i++) {
            int randomAsa = getRandomInRange(0, 10);
            int randomAge = getRandomInRange(5, 95);

//            pc.insertPatient(currentDate.plusDays(-randomAge+randomAsa), randomAge, randomAsa + "", "Krótki opis lub uwagi", AnesthesiaTechnique.randomAnesthesia(), SupervisionType.randomSupervision());

        }

        List<Patient> patients = pc.selectPatients();
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
        for (Patient c : patients)
            System.out.println(c.toString());
    }
}
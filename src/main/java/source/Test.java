package source;

import java.util.List;

import org.joda.time.DateTime;

import controller.MainControl;
import controller.PatientControl;

public class Test {

    public static void main(String[] args) {
	MainControl m = new PatientControl();
	DateTime currentDate = new DateTime();
	System.out.println(currentDate);
	// ((PatientControl) m).insertPatient(currentDate, 27, "1", "Wada
	// zgryzu", AnesthesiaTechnique.BLOKADY_NERWOW, "wspol");
	// ((PatientControl) m).insertPatient(currentDate, 14, "2", "dddddddd",
	// "Ogolne", "sam");
	// m.insertPatient(currentDate, 15, "4", "xxxxxxxxx", "Ogolne",
	// "wspol");
	// m.insertPatient(currentDate, 22, "5", "Hemorodiy", "pp", "sam");
	// m.insertPatient(currentDate, 17, "2", "Rak uszu", "bn", "sam");
	// m.insertPatient(currentDate, 52, "3", "Lupus", "og", "sam");
	// m.insertPatient(currentDate, 27, "2", "Chloniak", "bn", "wspol");

	List<Patient> patients = m.selectPatients();
	PatientControl p = (PatientControl) m;
	System.out.println("Lista pacjentow: ");
	showPatientList(patients);
	System.out.println(patients.get(9).equals(patients.get(9)));

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

    private static void showPatientList(List<Patient> patients) {
	for (Patient c : patients)
	    System.out.println(c.toString());
    }
}
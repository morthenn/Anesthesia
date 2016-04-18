import com.documents.anesthesia.dao.PatientDao;
import com.documents.anesthesia.types.AnesthesiaTechnique;
import com.documents.anesthesia.types.AsaCode;
import com.documents.anesthesia.types.SupervisionType;
import com.documents.anesthesia.utils.Exporter;
import org.joda.time.DateTime;

public class Main {
    private static PatientDao patientDao = new PatientDao();
    private static Exporter exp = new Exporter();

    public static void main(String[] args) {

//                for (int i = 0; i <95; i++) {
//            int randomAge = getRandomInRange(5, 95);
//            patientDao.insertPatient(DateTime.now().plusDays(-getRandomInRange(1, 20)),
//                    randomAge,
//                    AsaCode.randomField(),
//                    "Opis zabiegu po operacji",
//                    AnesthesiaTechnique.randomField(),
//                    SupervisionType.randomField());
//        }

        patientDao.showPatientList();


//        exp.createXlsFileFromList(patientDao.selectPatients()).exportFile();


//	patientDao.editPatient(12, "06/09/2016", 27, AsaCode.ONE, "EDIT", AnesthesiaTechnique.PODPAJECZYNOWKOWE, SupervisionType.SAMODZIELNIE);

//	patientDao.removePatient(14);

    }


    private static int getRandomInRange(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }


}
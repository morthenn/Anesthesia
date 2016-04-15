package controller;

import org.joda.time.DateTime;
import org.junit.Test;
import types.AnesthesiaTechnique;
import types.AsaCode;
import types.SupervisionType;
import utils.Patient;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Burza on 2016-04-03.first tests check
 */
public class PatientDaoTest {
PatientDao patientDao = new PatientDao();

    @Test
    public void insertPatient() throws Exception {
        ArrayList<Patient> list = patientDao.selectPatients();
        patientDao.insertPatient(DateTime.now().withDate(2000, 1, 1), 999, AsaCode.ONE, "Test description", AnesthesiaTechnique.OGOLNE, SupervisionType.SAMODZIELNIE);
        assertEquals("Inserting patient, expected list size shall be size()+1", list.size()+1, patientDao.selectPatients().size());
    }

    @Test
    public void editPatient() throws Exception {

    }

    @Test
    public void removePatient() throws Exception {
        ArrayList<Patient> list = patientDao.selectPatients();
        patientDao.removePatient(list.size());
        assertEquals("Removing patient, expected list size shall be size()-1", list.size()-1, patientDao.selectPatients().size());
    }

    @Test
    public void insertPatient1() throws Exception {

    }

    @Test
    public void selectPatients() throws Exception {
        PatientDao patientDao = new PatientDao();
        ArrayList<Patient> list = patientDao.selectPatients();

        assertEquals("First record in database of evidencial number must be 1", 1, patientDao.selectPatients().get(0).getEvidentialNumber());
        assertEquals("Last record in database of evidencial number must be 1", list.size(), patientDao.selectPatients().size());
    }
}
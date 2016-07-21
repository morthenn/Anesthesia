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
    public void selectPatients() throws Exception {
        PatientDao patientDao = new PatientDao();
        ArrayList<Patient> list = patientDao.selectPatients();

        assertEquals("First record in database of evidencial number must be 1", 1, patientDao.selectPatients().get(0).getEvidentialNumber());
        assertEquals("Last record in database of evidencial number must be 1", list.size(), patientDao.selectPatients().size());
    }
}
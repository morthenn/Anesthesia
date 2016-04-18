package com.documents.anesthesia.controller;

import com.documents.anesthesia.dao.PatientDao;
import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Test;
import com.documents.anesthesia.types.AnesthesiaTechnique;
import com.documents.anesthesia.types.AsaCode;
import com.documents.anesthesia.types.SupervisionType;
import com.documents.anesthesia.utils.Patient;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Burza on 2016-04-03. first tests check
 */
public class PatientDaoTest {
static PatientDao patientDao = new PatientDao();

    @Test
    public void insertPatient() throws Exception {
        ArrayList<Patient> list = patientDao.selectPatients();
        patientDao.insertPatient(DateTime.now().withDate(2000, 1, 1), 999, AsaCode.ONE, "Test description", AnesthesiaTechnique.OGOLNE, SupervisionType.SAMODZIELNIE);
        assertEquals("Inserting patient, expected list size shall be size()"+list.size()+"+1", list.size()+1, patientDao.selectPatients().size());
    }

    @Test
    public void editPatient() throws Exception {

    }

    @Test
    public void removePatient() throws Exception {
        ArrayList<Patient> list = patientDao.selectPatients();
        assertTrue(patientDao.removePatient(list.size()));
    }

    @Test
    public void selectPatients() throws Exception {
        PatientDao patientDao = new PatientDao();
        ArrayList<Patient> list = patientDao.selectPatients();

        assertEquals("First record in database of evidencial number must be 1", 1, patientDao.selectPatients().get(0).getEvidentialNumber());
        assertEquals("Last record in database of evidencial number must be "+list.size(), list.size(), patientDao.selectPatients().size());
    }
}
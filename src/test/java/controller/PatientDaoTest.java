package controller;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Burza on 2016-04-03.first tests check
 */
public class PatientDaoTest {
    @Test
    public void searchPatientByEvidencialNumber() throws Exception {

    }

    @Test
    public void insertPatient() throws Exception {

    }

    @Test
    public void editPatient() throws Exception {

    }

    @Test
    public void removePatient() throws Exception {

    }

    @Test
    public void insertPatient1() throws Exception {

    }

    @Test
    public void selectPatients() throws Exception {
        PatientDao patientDao = new PatientDao();
        assertEquals("First database evidencial number must be 1", 1, patientDao.selectPatients().get(0).getEvidencialNumber());
    }
}
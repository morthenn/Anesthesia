package controller;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Burza on 2016-04-03. first tests check
 */
public class DatabaseCreatorTest {

    @Test
    public void selectPatients() throws Exception {
        DatabaseCreator mc = new DatabaseCreator();
        assertEquals("First database evidencial number must be 1", 1, mc.selectPatients().get(0).getEvidencialNumber());
    }
}
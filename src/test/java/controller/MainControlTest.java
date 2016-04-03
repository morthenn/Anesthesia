package controller;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Burza on 2016-04-03. first tests check
 */
public class MainControlTest {

    @Test
    public void selectPatients() throws Exception {
        MainControl mc = new MainControl();
        assertEquals("First database evidencial number must be 1", 1, mc.selectPatients().get(0).getEvidencialNumber());
    }
}
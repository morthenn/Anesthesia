package pl.michalgubanski.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.michalgubanski.model.Patient;
import pl.michalgubanski.repository.PatientRepository;

import java.util.List;

/**
 * Created by U6041021 on 07/11/2016.
 */
@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> list() {
        return patientRepository.findAllByOrderByRegisteredDate();
    }

    public Patient getByEvidentialNumber() {
        return patientRepository.findFirstByOrderByEvidentialNumber();
    }

    public Patient addPatient(Patient newPatient) {
        return patientRepository.save(newPatient);
    }
}

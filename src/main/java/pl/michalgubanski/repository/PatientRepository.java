package pl.michalgubanski.repository;

import org.springframework.stereotype.Repository;
import pl.michalgubanski.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by U6041021 on 07/11/2016.
 */

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{

    List<Patient> findAllByOrderByRegisteredDate();
    List<Patient> findAllByOrderById();
    List<Patient> findAllByOrderByEvidentialNumberDesc();
    Patient findFirstEvidentialNumber();
}

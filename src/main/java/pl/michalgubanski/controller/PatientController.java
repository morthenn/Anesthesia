package pl.michalgubanski.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.michalgubanski.model.Patient;
import pl.michalgubanski.model.types.AnesthesiaTechnique;
import pl.michalgubanski.model.types.AsaFactor;
import pl.michalgubanski.model.types.SupervisionType;
import pl.michalgubanski.service.PatientService;
import pl.michalgubanski.utils.PatientUtil;

@Controller
@RequestMapping("/patients")
public class PatientController {
    private static final Logger log = LoggerFactory.getLogger(PatientController.class);

    @Autowired
    private PatientService patientService;

    @RequestMapping("/list")
    public String listPatients(Model model) {
        model.addAttribute("patients", patientService.listByEvidentialNumber());
        return "patient/list";
    }

    @RequestMapping(value = "/view/{evidentialNumber}", method = RequestMethod.GET)
    public String patient(@PathVariable(value = "evidentialNumber") Integer evidentialNumber, Model model) {
        model.addAttribute("patient", patientService.getByEvidentialNumber(evidentialNumber));
        model.addAttribute("asaList", AsaFactor.values());
        model.addAttribute("supervisionList", SupervisionType.values());
        model.addAttribute("anesthesiaList", AnesthesiaTechnique.values());
        return "patient/view";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String patientCreationGet(Model model) {
        model.addAttribute("patient", new Patient());
        model.addAttribute("asaList", AsaFactor.values());
        model.addAttribute("supervisionList", SupervisionType.values());
        model.addAttribute("anesthesiaList", AnesthesiaTechnique.values());
        model.addAttribute("defaultEvNo", patientService.getLastPatient().getEvidentialNumber() + 1);
        return "patient/create";
    }

    @Transactional
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String addPatientToDatabase(Patient patient) {
        if (patientService.getByEvidentialNumber(patient.getEvidentialNumber()) != null)
            return "redirect:/patients/list";
        patientService.addPatient(patient);
        log.info("Patient id={} created", patient.getEvidentialNumber());
        return "redirect:/patients/list";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String patientUpdateGet(Model model, Patient patient) {
        model.addAttribute("patient", patient);
        model.addAttribute("asaList", AsaFactor.values());
        model.addAttribute("supervisionList", SupervisionType.values());
        model.addAttribute("anesthesiaList", AnesthesiaTechnique.values());
        return "patient/update";
    }

    @Transactional
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updatePatientEntry(Patient patient) {
//        patientService.addPatient(patient);
//        log.info("Patient id={} updated", patient.getEvidentialNumber());
        return "redirect:/patients/list";
    }
}


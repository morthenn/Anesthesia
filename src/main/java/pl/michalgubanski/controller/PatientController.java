package pl.michalgubanski.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.michalgubanski.model.Patient;
import pl.michalgubanski.service.PatientService;

@Controller
@RequestMapping("/patients")
public class PatientController {
    private static final Logger log = LoggerFactory.getLogger(PatientController.class);
    @Autowired
    private PatientService patientService;

    @RequestMapping("/list")
    public String listPatients(Model model) {
        model.addAttribute("patients", patientService.list());
        return "patient/list";
    }

    @RequestMapping("/view/{evidencialNumber}")
    public String patient(@PathVariable(value = "evidencialNumber") String evidencialNumber, Model model) {
        model.addAttribute("patient", patientService.getByEvidentialNumber());
        return "patient/view";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String patientCreation(Model model) {
        model.addAttribute("patient", new Patient());
        return "patient/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String patientsAdd(@ModelAttribute Patient patient) {

        patientService.addPatient(patient);
        return "/patient/list";
    }

}

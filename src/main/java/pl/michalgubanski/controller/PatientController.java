package pl.michalgubanski.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.michalgubanski.service.PatientService;

@Controller
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @RequestMapping("/list")
    public String listPatients(Model model) {
        model.addAttribute("patients", patientService.list());
        return "patient/list";
    }

    @RequestMapping("/view/{evidencialNumber}")
    public String patient(@PathVariable(value = "evidencialNumber") String evidencialNumber, Model model) {
        model.addAttribute("patient", patientService.getByEvidencialNumber());
        return "patient/view";
    }

}

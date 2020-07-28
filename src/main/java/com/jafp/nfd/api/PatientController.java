package com.jafp.nfd.api;

import com.jafp.nfd.entity.Patient;
import com.jafp.nfd.services.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/demo")
public class PatientController {

    @Autowired
    private IPatientService patientService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Iterable<Patient> allPatients() {
        return patientService.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Patient patientById(@PathVariable long id) {
        return patientService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Patient savePatient(@RequestBody Patient patient) {
        return patientService.save(patient);
    }
}

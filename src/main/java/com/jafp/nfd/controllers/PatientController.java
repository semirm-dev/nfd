package com.jafp.nfd.controllers;

import com.jafp.nfd.models.PatientUpdateModel;
import com.jafp.nfd.services.IPatientService;
import com.jafp.nfd.models.PatientViewModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/demo")
public class PatientController {

    private final IPatientService patientService;

    public PatientController(IPatientService patientService) {
        this.patientService = patientService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Iterable<PatientViewModel> allPatients() {
        return patientService.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public PatientViewModel patientById(@PathVariable long id) {
        return patientService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public PatientViewModel createPatient(@RequestBody PatientViewModel viewModel) {
        return patientService.save(viewModel);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public PatientViewModel editPatient(@PathVariable long id, @RequestBody PatientUpdateModel updateModel) {
        return patientService.edit(id, updateModel);
    }
}

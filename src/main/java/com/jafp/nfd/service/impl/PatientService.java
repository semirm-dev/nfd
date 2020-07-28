package com.jafp.nfd.service.impl;

import com.jafp.nfd.entity.Patient;
import com.jafp.nfd.repository.PatientRepository;
import com.jafp.nfd.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService implements IPatientService {

    @Autowired
    private PatientRepository repository;

    @Override
    public List<Patient> findAll() {
        return repository.findAll();
    }

    @Override
    public Patient findById(long id) {
        Optional<Patient> patient = repository.findById(id);

        return patient.isEmpty() ? null : patient.get();
    }

    @Override
    public Patient save(Patient patient) {
        patient.setRegistered(new Date(System.currentTimeMillis()));

        return repository.save(patient);
    }
}

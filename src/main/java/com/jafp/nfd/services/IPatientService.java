package com.jafp.nfd.services;

import com.jafp.nfd.entity.Patient;

import java.util.List;

public interface IPatientService {
    List<Patient> findAll();

    Patient save(Patient patient);

    Patient findById(long id);
}

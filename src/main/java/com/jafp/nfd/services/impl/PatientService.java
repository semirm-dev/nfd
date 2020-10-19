package com.jafp.nfd.services.impl;

import com.jafp.nfd.entity.Patient;
import com.jafp.nfd.mappers.PatientMapper;
import com.jafp.nfd.models.PatientUpdateModel;
import com.jafp.nfd.models.PatientViewModel;
import com.jafp.nfd.repository.PatientRepository;
import com.jafp.nfd.services.IPatientService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService implements IPatientService {

    private final PatientRepository repository;
    private final PatientMapper mapper;

    public PatientService(PatientRepository repository, @Qualifier("patientMapperImpl") PatientMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<PatientViewModel> findAll() {
        return repository.findByOrderById().stream().map(mapper::entityToViewModel).collect(Collectors.toList());
    }

    @Override
    public PatientViewModel findById(long id) {
        return repository.findById(id).map(mapper::entityToViewModel).orElse(null);
    }

    @Override
    public PatientViewModel save(PatientViewModel viewModel) {
        Patient patient = mapper.viewModelToEntity(viewModel);

        patient.setRegistered(new Date(System.currentTimeMillis()));

        repository.save(patient);

        return mapper.entityToViewModel(patient);
    }

    @Override
    public PatientViewModel edit(long id, PatientUpdateModel updateModel) {
        Patient existing = mapper.entityFromUpdateModel(updateModel, repository.findById(id).orElse(null));

        repository.save(existing);

        return mapper.entityToViewModel(existing);
    }
}

package com.jafp.nfd.services;

import com.jafp.nfd.models.PatientRequestModel;
import com.jafp.nfd.models.PatientUpdateModel;
import com.jafp.nfd.models.PatientViewModel;

import java.util.List;

public interface IPatientService {
    List<PatientViewModel> findAll();

    PatientViewModel save(PatientRequestModel model);

    PatientViewModel findById(long id);

    PatientViewModel edit(long id, PatientUpdateModel updateModel);
}

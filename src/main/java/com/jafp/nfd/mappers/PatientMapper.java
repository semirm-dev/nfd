package com.jafp.nfd.mappers;

import com.jafp.nfd.entity.Patient;
import com.jafp.nfd.models.PatientRequestModel;
import com.jafp.nfd.models.PatientUpdateModel;
import com.jafp.nfd.models.PatientViewModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {AddressMapper.class})
public interface PatientMapper {
    PatientViewModel entityToViewModel(Patient patient);
    Patient requestModelToEntity(PatientRequestModel model);
    Patient entityFromUpdateModel(PatientUpdateModel updateModel, @MappingTarget Patient patient);
}

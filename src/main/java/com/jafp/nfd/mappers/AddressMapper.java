package com.jafp.nfd.mappers;

import com.jafp.nfd.entity.Address;
import com.jafp.nfd.models.AddressViewModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressViewModel entityToViewModel(Address address);
    Address viewModelToEntity(AddressViewModel viewModel);
}

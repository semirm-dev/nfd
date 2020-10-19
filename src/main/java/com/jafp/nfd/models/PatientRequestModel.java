package com.jafp.nfd.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientRequestModel {
    private String name;
    private AddressRequestModel address;
}

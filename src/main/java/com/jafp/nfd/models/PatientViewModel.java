package com.jafp.nfd.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientViewModel {
    private long id;
    private String name;
    private AddressViewModel address;
}

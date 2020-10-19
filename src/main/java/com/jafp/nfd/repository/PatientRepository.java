package com.jafp.nfd.repository;

import com.jafp.nfd.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByOrderById();

    List<Patient> findByName(String name);

    List<Patient> findByAddressLocation(String location);

    @Query(value = "SELECT * FROM patients WHERE name = ?1 AND address_id = ?2", nativeQuery = true)
    List<Patient> getSomethingElse(String name, long addressId);
}

package com.project.clinic.clinic.daos;

import com.project.clinic.clinic.models.Admin;
import com.project.clinic.clinic.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public  interface PatientDao extends JpaRepository<Patient,Long> {
    @Query(value = "SELECT * FROM patient WHERE email=?1 ", nativeQuery= true )
    Patient getPatientByEmail(String email);



}
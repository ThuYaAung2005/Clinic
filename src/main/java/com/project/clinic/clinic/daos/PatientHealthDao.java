package com.project.clinic.clinic.daos;

import com.project.clinic.clinic.models.PatientHealth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientHealthDao extends JpaRepository<PatientHealth ,Long > {

}

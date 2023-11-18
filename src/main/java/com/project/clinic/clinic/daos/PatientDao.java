package com.project.clinic.clinic.daos;

import com.project.clinic.clinic.models.Patient;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public  interface PatientDao extends JpaRepository<Patient,Long> {


}

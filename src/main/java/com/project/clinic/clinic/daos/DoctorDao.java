package com.project.clinic.clinic.daos;

import com.project.clinic.clinic.models.Doctor;
import com.project.clinic.clinic.models.Patient;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface DoctorDao extends JpaRepository<Doctor,Integer> {

}

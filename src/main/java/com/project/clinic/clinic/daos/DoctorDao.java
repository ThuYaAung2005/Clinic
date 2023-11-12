package com.project.clinic.clinic.daos;

import com.project.clinic.clinic.models.Patient;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;

public interface DoctorDao extends JpaAttributeConverter<Patient,Integer> {
}

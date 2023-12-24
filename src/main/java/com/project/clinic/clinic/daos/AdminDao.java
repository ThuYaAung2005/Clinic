package com.project.clinic.clinic.daos;

import com.project.clinic.clinic.models.Admin;
import com.project.clinic.clinic.models.Patient;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao extends JpaRepository<Admin,Long> {
    @Query(value = "SELECT * FROM admin WHERE email=?1 ", nativeQuery= true )
    Admin getAdminByEmail(String email);



}

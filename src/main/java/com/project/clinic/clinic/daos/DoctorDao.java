package com.project.clinic.clinic.daos;

import com.project.clinic.clinic.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorDao extends JpaRepository<Doctor, Long> {

    @Query(value = "SELECT * FROM doctor WHERE email=?1 AND password=?2", nativeQuery= true )
    Doctor getDoctorByEmailAndPassword(String email, String password);



}

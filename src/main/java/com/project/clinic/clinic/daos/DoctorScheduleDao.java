package com.project.clinic.clinic.daos;

import com.project.clinic.clinic.models.DoctorSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DoctorScheduleDao extends JpaRepository<DoctorSchedule,Long> {


   @Query(value = "SELECT s.* FROM schedule s INNER JOIN doctor d ON d.doctor_id=s.doctor_id WHERE d.doctor_id=?",nativeQuery = true)
    DoctorSchedule getByDocuterId(Long doctor_id);
}

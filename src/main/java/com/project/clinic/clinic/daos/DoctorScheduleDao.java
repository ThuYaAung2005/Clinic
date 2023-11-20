package com.project.clinic.clinic.daos;

import com.project.clinic.clinic.models.DoctorSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorScheduleDao extends JpaRepository<DoctorSchedule,Long> {
}

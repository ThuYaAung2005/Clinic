package com.project.clinic.clinic.daos;


import com.project.clinic.clinic.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingDao extends JpaRepository<Booking,Long> {
//
//    @Query( value = "SELECT rq.* FROM request_service rq INNER JOIN appointment ap ON rq.rq_id=ap.rq_id WHERE a_id=?1", nativeQuery = true)
//    Request_Service getRequestServiceByAppId(Long a_id);
//
//    @Query(value = "select * from request_service where status='Done'", nativeQuery = true)
//    List<Request_Service> getRequestsByStatuss();

     @Query(value ="from Booking b where b.patients.patient_id=:patient_id  And b.doctor.docSchedule.schedule_id=:schedule_id ")
    List<Booking> findByPatientAndScheduleId(Long patient_id, Long schedule_id);


}

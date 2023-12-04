package com.project.clinic.clinic.daos;


import com.project.clinic.clinic.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingDao extends JpaRepository<Booking,Long> {
}

package com.project.clinic.clinic.daos;

import com.project.clinic.clinic.models.Stuff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StuffDao extends JpaRepository<Stuff,Long> {

}

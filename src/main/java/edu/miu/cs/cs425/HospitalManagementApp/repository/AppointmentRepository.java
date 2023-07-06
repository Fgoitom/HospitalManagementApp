package edu.miu.cs.cs425.HospitalManagementApp.repository;

import edu.miu.cs.cs425.HospitalManagementApp.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer>{
}

package edu.miu.cs.cs425.HospitalManagementApp.repository;

import edu.miu.cs.cs425.HospitalManagementApp.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;



@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {


//    @Query(value = "SELECT Name, DOB FROM Patients WHERE DATE_DIFF(CURRENT_DATE, DOB, Year) >= 65", nativeQuery = true)
//    public List<Patient> getSeniorPatients();

    List<Patient>findAllByDateOfBirthBefore(LocalDate dateOfBirth);
}

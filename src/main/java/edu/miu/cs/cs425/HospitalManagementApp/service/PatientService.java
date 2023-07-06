package edu.miu.cs.cs425.HospitalManagementApp.service;

import edu.miu.cs.cs425.HospitalManagementApp.model.Patient;

import java.util.List;

public interface PatientService {

    public abstract List<Patient> getAllPatients();
    public abstract Patient getPatientById(Integer patientId);
    public abstract Patient addPatient(Patient patient);
    public abstract Patient updatePatient(Patient updatedPatient, Integer patientId);
    public abstract void deletePatientById(Integer patientId);

    public List<Patient> getAllElderlyPatients();
}

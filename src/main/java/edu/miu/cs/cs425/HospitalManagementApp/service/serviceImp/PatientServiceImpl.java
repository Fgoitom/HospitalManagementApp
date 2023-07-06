package edu.miu.cs.cs425.HospitalManagementApp.service.serviceImp;

import edu.miu.cs.cs425.HospitalManagementApp.model.Patient;
import edu.miu.cs.cs425.HospitalManagementApp.repository.PatientRepository;
import edu.miu.cs.cs425.HospitalManagementApp.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(Integer patientId) {
        return patientRepository.findById(patientId).orElse(null);
    }

    @Override
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient updatePatient(Patient updatedPatient, Integer patientId) {
        return patientRepository.findById(patientId)
                .map(patient -> {
                    patient.setPatientNumber(updatedPatient.getPatientNumber());
                    patient.setFirstName(updatedPatient.getFirstName());
                    patient.setLastName(updatedPatient.getLastName());
                    patient.setDateOfBirth(updatedPatient.getDateOfBirth());
                    return patientRepository.save(patient);
                })
                .orElseGet(() -> patientRepository.save(updatedPatient));
    }

    @Override
    public void deletePatientById(Integer patientId) {
        patientRepository.deleteById(patientId);

    }

    @Override
    public List<Patient> getAllElderlyPatients() {
        var date65YearsFromNow = LocalDate.now().minusYears(65);
        return patientRepository.findAllByDateOfBirthBefore(date65YearsFromNow);
    }


}
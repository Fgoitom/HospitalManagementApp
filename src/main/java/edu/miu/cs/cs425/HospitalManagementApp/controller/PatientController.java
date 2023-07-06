package edu.miu.cs.cs425.HospitalManagementApp.controller;

import edu.miu.cs.cs425.HospitalManagementApp.model.Patient;
import edu.miu.cs.cs425.HospitalManagementApp.repository.PatientRepository;
import edu.miu.cs.cs425.HospitalManagementApp.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {
    @Autowired
    PatientService patientService;


    @GetMapping(value = "/patients")
    public ResponseEntity<List<Patient>> getAllPatients(){
        return new ResponseEntity<>(patientService.getAllPatients(), HttpStatus.OK);
    }
    @GetMapping(value = "/elderlyPatients")
    public ResponseEntity<List<Patient>> getElderlyPatients(){
        return new ResponseEntity<>(patientService.getAllPatients(), HttpStatus.OK);
    }

    @GetMapping(value = "/patients/{patientId}")
    public ResponseEntity<Patient> getPatientById(@PathVariable("patientId") Integer patientId){
        return new ResponseEntity<>(patientService.getPatientById(patientId), HttpStatus.OK);
    }

    @PostMapping(value = "/patients")
    public ResponseEntity<Patient> addPatient(@Valid @RequestBody Patient patient){
        return new ResponseEntity<>( patientService.addPatient(patient), HttpStatus.CREATED);
    }

    @PutMapping(value = "/patients/{patientId}")
    public ResponseEntity<Patient> updatePatient(@Valid @RequestBody Patient updatedPatient, @PathVariable("patientId") Integer patientId){
        return new ResponseEntity<>(patientService.updatePatient(updatedPatient, patientId), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/patients/{patientId}")
    public ResponseEntity<?> deletePatientById(@PathVariable("patientId") Integer patientId){
        patientService.deletePatientById(patientId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

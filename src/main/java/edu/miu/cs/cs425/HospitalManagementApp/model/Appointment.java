package edu.miu.cs.cs425.HospitalManagementApp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "appointments")

public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long appointmentId;
    @Column(nullable = false)
    private LocalDate appointmentDate;
    @Column(nullable = false)
    private LocalTime appointmentTime;
    private String dentistName;
    private String surgeryLocation;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "patientId")
    private Patient patient;
}

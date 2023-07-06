package edu.miu.cs.cs425.HospitalManagementApp.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "patients")
public class Patient {
@Id
@GeneratedValue
    private Integer patientId;
@NotBlank(message = "Patient Number is required")
    private String patientNumber;
@NotBlank(message = "First Name is required")
    private String firstName;
@NotBlank(message = "Last Name is required")
    private String lastName;
@Column(nullable = false)
    private LocalDate dateOfBirth;

@JsonManagedReference
@OneToMany(mappedBy = "patient")
    public List<Appointment> appointment;


}

package edu.miu.cs.cs425.HospitalManagementApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HospitalManagementAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(HospitalManagementAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello World!");
		System.out.println("This is Hospital Management System");


	}
}

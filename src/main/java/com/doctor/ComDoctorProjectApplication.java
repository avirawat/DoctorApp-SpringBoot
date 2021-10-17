package com.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.doctor.service.IDoctorService;

//@SpringBootConfiguration
//@EnableAutoConfiguration
@SpringBootApplication
public class ComDoctorProjectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ComDoctorProjectApplication.class, args);
	}

	@Autowired
	IDoctorService doctorService;

	@Override
	public void run(String... args) throws Exception {
//		adding value-1
//		Specialisation
//		Specialisation s1=new Specialisation("Dietition","MS","India");
//		Specialisation s2=new Specialisation("Nutrition","MD","UK");
//		Set<Specialisation> specialityList=new HashSet<>(Arrays.asList(s1,s2));
//		//hospital
//		Hospital hospital1=new Hospital("MotherhoodHospital","Pediatrician",4.1);
//		Hospital hospital2=new Hospital("Manipal","orthopedist",4.5);
//		Set<Hospital> hospitalList=new HashSet<>(Arrays.asList(hospital1,hospital2));
//		//Consulatation Time
//		LocalDate dateInstance=LocalDate.of(2021,9,29);
//		LocalTime startTime=LocalTime.of(9,30);
//		LocalTime endTime=LocalTime.of(16,30);
//		Consultation consultancyPeriod1=new Consultation(dateInstance,"available", startTime, endTime);
//		Set<Consultation> consultancyList=new HashSet<>(Arrays.asList(consultancyPeriod1));
//		Doctor doctor=new Doctor("Dr.Ayan","Blg",4.5,10,1200.0,specialityList,hospitalList,consultancyList);
		// doctorService.addDoctor(doctor);
		// adding Value-2
//		Specialisation s1=new Specialisation("Neurology","MCAT","Harward");
//		Specialisation s2=new Specialisation("Dermatology","MD","India");
//		Set<Specialisation> specialityList=new HashSet<>(Arrays.asList(s1,s2));
//		//hospital
//		Hospital hospital1=new Hospital("Ace hospital","Cardio",4.7);
//		Hospital hospital2=new Hospital("Intense Hospital","urology",4.4);
//		Set<Hospital> hospitalList=new HashSet<>(Arrays.asList(hospital1,hospital2));
//		//Consulatation Time
//		LocalDate dateInstance=LocalDate.of(2021,10,1);
//		LocalTime startTime=LocalTime.of(9,15);
//		LocalTime endTime=LocalTime.of(16,15);
//		Consultation consultancyPeriod1=new Consultation(dateInstance,"available", startTime, endTime);
//		Set<Consultation> consultancyList=new HashSet<>(Arrays.asList(consultancyPeriod1));
//		Doctor doctor=new Doctor("Dr.Suman","Chennai",4.3,13,1300.0,specialityList,hospitalList,consultancyList);
		// doctorService.addDoctor(doctor);
		// add Value-3
//		Specialisation s1=new Specialisation("Ayurveda","MDF","India");
//		Specialisation s2=new Specialisation("Gasterologist","PG","Pakistan");
//		Set<Specialisation> specialityList=new HashSet<>(Arrays.asList(s1,s2));
//		//hospital
//		Hospital hospital1=new Hospital("Medicover","Cardio",4.8);
//		Hospital hospital2=new Hospital("Medico","physician",4.1);
//		Set<Hospital> hospitalList=new HashSet<>(Arrays.asList(hospital1,hospital2));
//		//Consulatation Time
//		LocalDate dateInstance=LocalDate.of(2021,9,28);
//		LocalTime startTime=LocalTime.of(10,30);
//		LocalTime endTime=LocalTime.of(5,30);
//		Consultation consultancyPeriod1=new Consultation(dateInstance,"available", startTime, endTime);
//		LocalDate dateIns=LocalDate.of(2021,9,30);
//		LocalTime startT=LocalTime.of(11,30);
//		LocalTime endT=LocalTime.of(6,30);
//		Consultation consultancyPeriod2=new Consultation(dateIns,"available", startT, endT);
//		Set<Consultation> consultancyList=new HashSet<>(Arrays.asList(consultancyPeriod1,consultancyPeriod2));
//		Doctor doctor=new Doctor("Dr.Navin","Puducherry",4.1,9,800.0,specialityList,hospitalList,consultancyList);
		// doctorService.addDoctor(doctor);

	}

}

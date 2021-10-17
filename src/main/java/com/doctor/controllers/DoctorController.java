package com.doctor.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctor.model.Doctor;
import com.doctor.service.IDoctorService;

@RestController
@RequestMapping("doctor-service")                                              //Map web request
public class DoctorController {                                               //Doctor-Controller

	@Autowired
	IDoctorService doctorService;                                              //automatic dependency Injection

	// http://localhost:8080/doctor-service/doctors
	@GetMapping("/doctors")                                              //Get all Doctors List
	List<Doctor> getAllDoctors() {
		return doctorService.getAllDoctors();
	}

	// http://localhost:8080/doctor-service/doctors/doctorId/100
	@GetMapping("/doctors/doctorId/{doctorId}")                         //Get Doctor By ID
	Doctor getById(@PathVariable("doctorId") int doctorId) {
		return doctorService.getById(doctorId);
	}

	// http://localhost:8080/doctor-service/doctors/name/Dr.Ayan
	@GetMapping("/doctors/name/{name}")                                //Get Doctor By Doctor Name
	List<Doctor> getByName(@PathVariable("name") String name) {
		return doctorService.getByName(name);
	}

	// http://localhost:8080/doctor-service/doctors/city/Hyd
	@GetMapping("/doctors/city/{city}")                                //Get List Of Doctor By City
	List<Doctor> getByCity(@PathVariable("city") String city) {
		return doctorService.getByCity(city);
	}

	// http://localhost:8080/doctor-service/doctors/rating/4.5
	@GetMapping("/doctors/rating/{rating}")                             //Get List Of Doctor By rating
	List<Doctor> getByRating(@PathVariable("rating") double rating) {
		return doctorService.getByRating(rating);
	}

	// http://localhost:8080/doctor-service/doctors/experience/15
	@GetMapping("/doctors/experience/{experience}")                      //Get List Of Doctor By experience
	List<Doctor> getByExperience(@PathVariable("experience") int experience) {
		return doctorService.getByExperience(experience);
	}

	// http://localhost:8080/doctor-service/doctors/fee/1500
	@GetMapping("/doctors/fee/{fee}")                                   //Get List Of Doctor By fee
	List<Doctor> getByFeeLessThan(@PathVariable("fee") double fee) {
		return doctorService.getByFeeLessThan(fee);
	}

	// http://localhost:8080/doctor-service/doctors/cityName/Hyd/exp/15
	@GetMapping("/doctors/cityName/{city}/exp/{experience}")              //Get List Of Doctor By City and Experience
	List<Doctor> getByCityAndExperience(@PathVariable("city") String city, @PathVariable("experience") int experience) {
		return doctorService.getByCityAndExperience(city, experience);
	}

	// http://localhost:8080/doctor-service/doctors/cityName/Hyd/feeValue/1500
	@GetMapping("/doctors/cityName/{city}/feeValue/{fee}")                //Get List Of Doctor By City and Fee
	List<Doctor> getByCityAndFee(@PathVariable("city") String city, @PathVariable("fee") double fee) {
		return doctorService.getByCityAndFee(city, fee);
	}

	// Doctor And Specialisation Table
	// http://localhost:8080/doctor-service/doctors/cityName/Hyd/speciality/Dentist
	@GetMapping("/doctors/cityName/{city}/speciality/{speciality}")      //Get List Of Doctor By City And Speciality
	List<Doctor> getByCityAndSpeciality(@PathVariable("city") String city,
			@PathVariable("speciality") String speciality) {
		return doctorService.getByCityAndSpeciality(city, speciality);
	}

	// http://localhost:8080/doctor-service/doctors/feeValue/1500/spl/Dentist
	@GetMapping("/doctors/feeValue/{fee}/spl/{speciality}")             //Get List Of Doctor By fee and speciality
	List<Doctor> getByFeeAndSpeciality(@PathVariable("fee") double fee, @PathVariable("speciality") String speciality) {
		return doctorService.getByFeeAndSpeciality(fee, speciality);
	}
}

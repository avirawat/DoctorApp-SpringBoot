package com.doctor.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.doctor.model.Hospital;
import com.doctor.service.IHospitalService;

@RestController
@RequestMapping("hospital-service")                                            //Map web request
public class HospitalController {                                              //Hospital-controller

	@Autowired
	IHospitalService hospitalService;                                         //automatic dependency Injection

	// http://localhost:8080/hospital-service/hospitals
	@GetMapping("/hospitals")                                                  //Get List Of all hospitals
	List<Hospital> getAllHospitals() {
		return hospitalService.getAllHospitals();
	}

	// http://localhost:8080/hospital-service/hospitals/hospitalId/100
	@GetMapping("/hospitals/hospitalId/{hospitalId}")                         //Get hospital By ID
	Hospital getById(@PathVariable("hospitalId") int hospitalId) {
		return hospitalService.getById(hospitalId);
	}

	// http://localhost:8080/hospital-service/hospitals/hname/Apollo
	@GetMapping("/hospitals/hname/{hname}")                                    //Get hospital By Name
	Hospital getByName(@PathVariable("hname") String name) {
		return hospitalService.getByName(name);
	}

	// http://localhost:8080/hospital-service/hospitals/rating/4.5
	@GetMapping("/hospitals/rating/{rating}")                                   //Get hospital By rating
	List<Hospital> getByRating(@PathVariable("rating") double rating) {
		return hospitalService.getByRating(rating);
	}

	// http://localhost:8080/hospital-service/hospitals/speciality/Cardio
	@GetMapping("/hospitals/speciality/{speciality}")                            //Get hospital By Speciality
	List<Hospital> getBySpeciality(@PathVariable("speciality") String speciality) {
		return hospitalService.getBySpeciality(speciality);
	}

	// http://localhost:8080/hospital-service/hospitals/doctorName/Dr.Ayan
	@GetMapping("/hospitals/doctorName/{name}")                                  //Get hospital By Doctor Name
	List<Hospital> getByDoctorName(@PathVariable("name") String name) {
		return hospitalService.getByDoctorName(name);
	}

	// http://localhost:8080/hospital-service/hospitals/cityName/Hyd/speciality/orthopedist
	@GetMapping("/hospitals/cityName/{city}/speciality/{speciality}")             //Get hospital By city and speciality
	List<Hospital> getByCityAndSpeciality(@PathVariable("city") String city,
			@PathVariable("speciality") String speciality) {
		return hospitalService.getByCityAndSpeciality(city, speciality);
	}

	// http://localhost:8080/hospital-service/hospitals/cityName/Hyd/speciality/orthopedist
	@GetMapping("/hospitals/feeValue/{fee}/spl/{speciality}")                     //Get hospital By Fee and speciality
	List<Hospital> getByFeeAndSpeciality(@PathVariable("fee") double fee,
			@PathVariable("speciality") String speciality) {
		return hospitalService.getByFeeAndSpeciality(fee, speciality);
	}

	// http://localhost:8080/hospital-service/hospitals/fee/1500
	@GetMapping("/hospitals/fee/{fee}")                                         //Get hospital By Fee
	List<Hospital> getByDoctorFee(@PathVariable("fee") double fee) {
		return hospitalService.getByDoctorFee(fee);
	}
}

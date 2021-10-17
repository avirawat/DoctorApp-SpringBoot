package com.doctor.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctor.model.Specialisation;
import com.doctor.service.ISpecialisationService;

@RestController
@RequestMapping("speciality-service")                                                     //Map web request
public class SpecialisationController {                                                  //Specialisation-Controller

	@Autowired
	ISpecialisationService specialityService;                                            //automatic dependency Injection

	// http://localhost:8080/speciality-service/speciality/degree/MS
	@RequestMapping("/speciality/degree/{degree}")                                       //Get list Doctor By Degree
	List<Specialisation> getDoctorByDegree(@PathVariable("degree") String degree) {
		return specialityService.getDoctorByDegree(degree);
	}

	// http://localhost:8080/speciality-service/speciality/spl/Dietition/degree/MS
	@RequestMapping("/speciality/spl/{specialist}/degree/{degree}")                      //Get list Doctor By Speciality and degree
	List<Specialisation> getDoctorBySpecialityAndDegree(@PathVariable("specialist") String speciality,
			@PathVariable("degree") String degree) {
		return specialityService.getDoctorBySpecialityAndDegree(speciality, degree);
	}

	// http://localhost:8080/speciality-service/speciality/fee/1500/country/India
	@RequestMapping("/speciality/fee/{fee}/country/{country}")                       //Get list Doctor By fee and country
	List<Specialisation> getDoctorByFeeAndDegreeCountry(@PathVariable("fee") double fee,
			@PathVariable("country") String country) {
		return specialityService.getDoctorByFeeAndDegreeCountry(fee, country);
	}
}

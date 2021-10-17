package com.doctor.controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctor.exceptions.DateTimeNotFoundException;
import com.doctor.exceptions.DoctorNotFoundException;
import com.doctor.exceptions.TimeSlotNotFoundException;
import com.doctor.model.Consultation;
import com.doctor.service.IConsultationService;

@RestController
@RequestMapping("consultation-service")                                                  //Map web request
public class ConsultationController {                                                    //Consultation-Controller

	@Autowired
	IConsultationService consultancyService;                                              //automatic dependency Injection

	// http://localhost:8080/consultation-service/consultancy/name/Dr.Ayan
	@GetMapping("/consultancy/name/{doctorName}")                                        //Checking doctor Availability By Name
	public String getDoctorAvailability(@PathVariable("doctorName") String doctorName) throws DoctorNotFoundException {
		return consultancyService.getDoctorAvailability(doctorName);
	}

	// http://localhost:8080/consultation-service/consultancy/startTime/09:30:00/endTime/02:30:00
	@GetMapping("/consultancy/startTime/{sTime}/endTime/{eTime}")				        //Checking doctor Availability By Time
	List<Consultation> getDoctorsAvailabilityByTime(@PathVariable("sTime") String sTime,
			@PathVariable("eTime") String eTime) throws DoctorNotFoundException {
		LocalTime startTime = LocalTime.parse(sTime);									//Changing String to Local Time
		LocalTime endTime = LocalTime.parse(eTime);										//Changing String to Local Time
		return consultancyService.getDoctorsAvailabilityByTime(startTime, endTime);
	}

	// http://localhost:8080/consultation-service/consultancy/date/2021-09-29
	@GetMapping("/consultancy/date/{date}")                                             //Checking doctor Availability By Date
	List<Consultation> getDoctorsAvailabilityByDate(@PathVariable("date") String date) throws DoctorNotFoundException {
		LocalDate currDate = LocalDate.parse(date);									//Changing String to LocalDate
		return consultancyService.getDoctorsAvailabilityByDate(currDate);
	}

	// http://localhost:8080/consultation-service/consultancy/doctorName/Dr.Navin
	@GetMapping("/consultancy/doctorName/{name}")						            //Checking doctor Availability TimeSlot By Name
	List<Consultation> getAvailabilityTimeSlotByDoctorName(@PathVariable("name") String name)
			throws TimeSlotNotFoundException {
		return consultancyService.getAvailabilityTimeSlotByDoctorName(name);
	}

	// http://localhost:8080/consultation-service/consultancy/date/2021-09-29/stime/09:30:00/etime/14:30:00
	@GetMapping("/consultancy/date/{date}/stime/{sTime}/etime/{eTime}")          //Checking doctor Availability By Date
	List<Consultation> getAvailabilityByDateAndTime(@PathVariable("date") String date,
			@PathVariable("sTime") String sTime, @PathVariable("eTime") String eTime) throws DateTimeNotFoundException {
		LocalTime startTime = LocalTime.parse(sTime);
		LocalTime endTime = LocalTime.parse(eTime);                                //Changing String to Local Time
		LocalDate currDate = LocalDate.parse(date);									//Changing String to Local Date
		return consultancyService.getAvailabilityByDateAndTime(currDate, startTime, endTime);
	}

	// http://localhost:8080/consultation-service/consultancy/cityName/Puducherry
	@GetMapping("/consultancy/cityName/{city}")                                  //Checking doctor Availability TimeSlot By City
	List<Consultation> getDoctorsAvailabilityTimeSlotByCity(@PathVariable("city") String city)
			throws DoctorNotFoundException {
		return consultancyService.getDoctorsAvailabilityTimeSlotByCity(city);
	}

	// http://localhost:8080/consultation-service/consultancy/feeValue/1500
	@GetMapping("/consultancy/feeValue/{fee}")	                              //Checking doctor Availability TimeSlot By Fee
	List<Consultation> getDoctorsAvailabilityTimeSlotByfee(@PathVariable("fee") double fee)
			throws DoctorNotFoundException {
		return consultancyService.getDoctorsAvailabilityTimeSlotByfee(fee);
	}
}

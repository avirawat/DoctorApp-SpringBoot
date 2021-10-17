package com.doctor.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.doctor.exceptions.DateTimeNotFoundException;
import com.doctor.exceptions.DoctorNotFoundException;
import com.doctor.exceptions.TimeSlotNotFoundException;
import com.doctor.model.Consultation;

@Service
public interface IConsultationService {

	// check Doctors Availability
	public String getDoctorAvailability(String doctorName) throws DoctorNotFoundException;

	List<Consultation> getDoctorsAvailabilityByTime(LocalTime sTime, LocalTime eTime) throws DoctorNotFoundException;

	List<Consultation> getDoctorsAvailabilityByDate(LocalDate date) throws DoctorNotFoundException;

	List<Consultation> getAvailabilityTimeSlotByDoctorName(String doctorName) throws TimeSlotNotFoundException;

	List<Consultation> getAvailabilityByDateAndTime(LocalDate date, LocalTime sTime, LocalTime eTime)
			throws DateTimeNotFoundException;

	List<Consultation> getDoctorsAvailabilityTimeSlotByCity(String city) throws DoctorNotFoundException;

	List<Consultation> getDoctorsAvailabilityTimeSlotByfee(double fee) throws DoctorNotFoundException;
}

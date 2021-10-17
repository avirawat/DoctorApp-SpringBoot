package com.doctor.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctor.exceptions.DateTimeNotFoundException;
import com.doctor.exceptions.DoctorNotFoundException;
import com.doctor.exceptions.TimeSlotNotFoundException;
import com.doctor.model.Consultation;
import com.doctor.repository.ConsultationRepository;

/**
 * @author AvinashRavat
 *
 */
@Service
public class ConsulatationServiceImpl implements IConsultationService { // class implementing interface with all
																		// function definitions

	@Autowired
	ConsultationRepository consultancyRepository; // Object of Consultation-repository

	public String getDoctorAvailability(String doctorName) throws DoctorNotFoundException { // checking doctor
																							// availability By Name
		String available = consultancyRepository.findDoctorsAvailabilityByName(doctorName);
		if (available == null) {
			throw new DoctorNotFoundException("Doctor is not available"); // throwing exception if Doctor not present
		}
		return available; // if Doctor present return his availability
	}

	@Override
	public List<Consultation> getDoctorsAvailabilityByTime(LocalTime sTime, LocalTime eTime)
			throws DoctorNotFoundException { // check availability By there start and ending time
		List<Consultation> doctorsAvailabilityByTime = consultancyRepository.findDoctorsAvailabilityByTime(sTime,
				eTime);
		if (doctorsAvailabilityByTime.isEmpty()) {
			throw new DoctorNotFoundException("Doctor is not available in this Time Period"); // throwing exception if
																								// Doctor not present
		}
		return doctorsAvailabilityByTime; // return list of available time of doctors
	}

	@Override
	public List<Consultation> getDoctorsAvailabilityByDate(LocalDate date) throws DoctorNotFoundException {
		List<Consultation> doctorsAvailabilityByDate = consultancyRepository.findDoctorsAvailabilityByDate(date);
		if (doctorsAvailabilityByDate.isEmpty()) { // check doctors availability By Date
			throw new DoctorNotFoundException("Doctor is not available in this Date");
		}
		return doctorsAvailabilityByDate; // if doctors present return list of doctors
	}

	@Override // check availability of doctors By their Name
	public List<Consultation> getAvailabilityTimeSlotByDoctorName(String doctorName) throws TimeSlotNotFoundException {
		List<Consultation> availabilityTimeSlotByDoctorName = consultancyRepository
				.findAvailabilityTimeSlotByDoctorName(doctorName);
		if (availabilityTimeSlotByDoctorName.isEmpty()) {
			throw new TimeSlotNotFoundException("SLot not found By this Doctor Name");// throwing exception if
																						// availability not found
		}
		return availabilityTimeSlotByDoctorName; // return list of consultation time of particular doctor By Name
	}

	@Override
	public List<Consultation> getAvailabilityByDateAndTime(LocalDate date, LocalTime sTime, LocalTime eTime)
			throws DateTimeNotFoundException { // get Doctors availability by date and time
		List<Consultation> availabilityByDateAndTime = consultancyRepository.findAvailabilityByDateAndTime(date, sTime,
				eTime);
		if (availabilityByDateAndTime.isEmpty()) {
			throw new DateTimeNotFoundException("Date time not found for consultation");
		}
		return availabilityByDateAndTime; // return list of available doctors by Date and Time
	}

	@Override // check doctors time slot by City Name
	public List<Consultation> getDoctorsAvailabilityTimeSlotByCity(String city) throws DoctorNotFoundException {
		List<Consultation> doctorsAvailabilityTimeSlotByCity = consultancyRepository
				.findDoctorsAvailabilityTimeSlotByCity(city);
		if (doctorsAvailabilityTimeSlotByCity.isEmpty()) { // checking list of doctor is empty or not
			throw new DoctorNotFoundException("Doctor is not available in this City");// throwing exception if doctors
																						// are not available in given
																						// city
		}
		return doctorsAvailabilityTimeSlotByCity; // return list of doctors By city name
	}

	@Override // check doctors by fee(maximum fee)
	public List<Consultation> getDoctorsAvailabilityTimeSlotByfee(double fee) throws DoctorNotFoundException {
		List<Consultation> doctorsAvailabilityTimeSlotByfee = consultancyRepository
				.findDoctorsAvailabilityTimeSlotByfee(fee);
		if (doctorsAvailabilityTimeSlotByfee.isEmpty()) {
			throw new DoctorNotFoundException("Doctor is not available within this fee"); // throwing exception if
																							// doctors not found within
																							// that Fee money
		}
		return doctorsAvailabilityTimeSlotByfee; // return list of Doctors with maximum fee
	}

}

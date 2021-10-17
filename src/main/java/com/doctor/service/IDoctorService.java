package com.doctor.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.doctor.exceptions.DoctorNotFoundException;
import com.doctor.exceptions.IdNotFoundException;
import com.doctor.model.Doctor;

@Service
public interface IDoctorService {
	
	// CRUD
	
	void addDoctor(Doctor doctor);

	void deleteDoctor(int doctorId);

	void updateDoctor(Doctor doctor);

	Doctor getById(int doctorId) throws IdNotFoundException;

	List<Doctor> getAllDoctors();

	// Doctor table
	
	List<Doctor> getByName(String name) throws DoctorNotFoundException;

	List<Doctor> getByCity(String city) throws DoctorNotFoundException;

	List<Doctor> getByRating(double rating) throws DoctorNotFoundException;

	List<Doctor> getByExperience(int experience) throws DoctorNotFoundException;

	List<Doctor> getByFeeLessThan(double fee) throws DoctorNotFoundException;

	List<Doctor> getByCityAndExperience(String city, int experience) throws DoctorNotFoundException;

	List<Doctor> getByCityAndFee(String city, double fee) throws DoctorNotFoundException;

	// Doctor And Specialization Table
	
	List<Doctor> getByCityAndSpeciality(String city, String speciality) throws DoctorNotFoundException;

	List<Doctor> getByFeeAndSpeciality(double fee, String speciality) throws DoctorNotFoundException;

}

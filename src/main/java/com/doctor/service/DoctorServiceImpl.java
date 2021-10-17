package com.doctor.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctor.exceptions.DoctorNotFoundException;
import com.doctor.exceptions.IdNotFoundException;
import com.doctor.model.Doctor;
import com.doctor.repository.DoctorRepository;

/**
 * @author AvinashRavat
 *
 */
@Service
public class DoctorServiceImpl implements IDoctorService {

	@Autowired
	DoctorRepository doctorRepository; // Object of Doctor-repository Automatic dependency Injection

	@Override
	public void addDoctor(Doctor doctor) { // Add Doctors details
		doctorRepository.save(doctor);

	}

	@Override
	public List<Doctor> getAllDoctors() { // List of all Doctors
		return doctorRepository.findAll();
	}

	@Override
	public void deleteDoctor(int doctorId) { // Delete doctors details By Id
		doctorRepository.deleteById(doctorId);

	}

	@Override
	public void updateDoctor(Doctor doctor) { // Update doctor details
		doctorRepository.save(doctor);

	}

	@Override
	public Doctor getById(int doctorId) throws IdNotFoundException { // Get Doctor By ID
		return doctorRepository.findById(doctorId).orElseThrow(() -> new IdNotFoundException("Doctor Id not Found"));
//		if (doctorById == null) {
//			throw new IdNotFoundException("Id not found"); // If Doctor Not found throw exceptions
//		}
//		return doctorById; // Returning Doctor details

	}

	@Override
	public List<Doctor> getByName(String name) throws DoctorNotFoundException { // Get Doctor By Name
		List<Doctor> listByName = doctorRepository.findByName(name).stream()
				.sorted(Comparator.comparing(Doctor::getName)).collect(Collectors.toList());
		if (listByName.isEmpty()) {
			throw new DoctorNotFoundException("Doctor not found"); // If Doctor Not found throw exceptions
		}
		return listByName; // Returning List Of Doctors By Name
	}

	@Override
	public List<Doctor> getByCity(String city) throws DoctorNotFoundException { // Get Doctor By City
		List<Doctor> listByCity = doctorRepository.findByCity(city).stream()
				.sorted(Comparator.comparing(Doctor::getName)).collect(Collectors.toList());
		if (listByCity.isEmpty()) {
			throw new DoctorNotFoundException("Doctor not found"); // If Doctor Not found throw exceptions
		}
		return listByCity; // Returning List Of Doctors By City
	}

	@Override
	public List<Doctor> getByRating(double rating) throws DoctorNotFoundException { // Get Doctor By rating
		List<Doctor> listByRating = doctorRepository.findByRating(rating).stream()
				.sorted(Comparator.comparing(Doctor::getName)).collect(Collectors.toList());
		if (listByRating.isEmpty()) {
			throw new DoctorNotFoundException("Doctor not found");// If Doctor Not found throw exceptions
		}
		return listByRating; // Returning List Of Doctors By Rating
	}

	@Override
	public List<Doctor> getByExperience(int experience) throws DoctorNotFoundException { // Get Doctor By Experince
		List<Doctor> listByExperience = doctorRepository.findByExperience(experience).stream()
				.sorted(Comparator.comparing(Doctor::getName)).collect(Collectors.toList());
		if (listByExperience.isEmpty()) {
			throw new DoctorNotFoundException("Doctor not found"); // If Doctor Not found throw exceptions
		}
		return listByExperience; // Returning List Of Doctors By Experience
	}

	@Override
	public List<Doctor> getByFeeLessThan(double fee) throws DoctorNotFoundException { // Get Doctor By maximum Fee
		List<Doctor> listByFee = doctorRepository.findByFeeLessThan(fee).stream()
				.sorted(Comparator.comparing(Doctor::getName)).collect(Collectors.toList());
		if (listByFee.isEmpty()) {
			throw new DoctorNotFoundException("Doctor not found"); // If Doctor Not found throw exceptions
		}
		return listByFee; // Returning List Of Doctors By Fee
	}

	@Override // Get Doctor By City And Experience
	public List<Doctor> getByCityAndExperience(String city, int experience) throws DoctorNotFoundException {
		List<Doctor> listByCityAndExperience = doctorRepository.findByCityAndExperience(city, experience).stream()
				.sorted(Comparator.comparing(Doctor::getName)).collect(Collectors.toList());
		if (listByCityAndExperience.isEmpty()) {
			throw new DoctorNotFoundException("Doctor not found"); // If Doctor Not found throw exceptions
		}
		return listByCityAndExperience; // Returning List Of Doctors By City And Experience
	}

	@Override // Get Doctor By City And fee
	public List<Doctor> getByCityAndFee(String city, double fee) throws DoctorNotFoundException {
		List<Doctor> listByCityAndFee = doctorRepository.findByCityAndFee(city, fee).stream()
				.sorted(Comparator.comparing(Doctor::getName)).collect(Collectors.toList());
		if (listByCityAndFee.isEmpty()) {
			throw new DoctorNotFoundException("Doctor not found"); // If Doctor Not found throw exceptions
		}
		return listByCityAndFee; // Returning List Of Doctors City And fee
	}

	@Override // Get Doctor By City And Specialty
	public List<Doctor> getByCityAndSpeciality(String city, String speciality) throws DoctorNotFoundException {
		List<Doctor> doctorsByCityAndSpeciality = doctorRepository.findByCityAndSpeciality(city, speciality);
		if (doctorsByCityAndSpeciality.isEmpty()) {
			throw new DoctorNotFoundException("Doctor not found with this city and speciality"); // If Doctor Not found
																									// throw exceptions
		}
		return doctorsByCityAndSpeciality;
	}

	@Override // Get Doctor By fee And Specialty
	public List<Doctor> getByFeeAndSpeciality(double fee, String speciality) throws DoctorNotFoundException {
		List<Doctor> getByFeeAndSpeciality = doctorRepository.findByFeeAndSpeciality(fee, speciality);
		if (getByFeeAndSpeciality.isEmpty()) {
			throw new DoctorNotFoundException("Doctor not found with this Specialitya and fee"); // If Doctor Not found
																									// throw exceptions
		}
		return getByFeeAndSpeciality;
	}

}

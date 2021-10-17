package com.doctor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctor.exceptions.DoctorNotFoundException;
import com.doctor.model.Specialisation;
import com.doctor.repository.SpecialisationRepository;

@Service
public class SpecialisationServiceImpl implements ISpecialisationService {

	@Autowired
	SpecialisationRepository specialRepository; // Object of Specialization-repository Automatic dependency Injection

	@Override
	public List<Specialisation> getDoctorByDegree(String degree) throws DoctorNotFoundException { // getting doctors By
																									// their degree
		List<Specialisation> doctorByDegree = specialRepository.findDoctorByDegree(degree);
		if (doctorByDegree.isEmpty()) {
			throw new DoctorNotFoundException("No doctor found with this Degeree"); // throw exception if doctor not
																					// available with this degree
		}
		return doctorByDegree; // list of doctors with this degree
	}

	@Override
	public List<Specialisation> getDoctorBySpecialityAndDegree(String speciality, String degree)
			throws DoctorNotFoundException { // getting doctors by their specialty and degree
		List<Specialisation> doctorBySpecialityAndDegree = specialRepository.findDoctorBySpecialityAndDegree(speciality,
				degree);
		if (doctorBySpecialityAndDegree.isEmpty()) { // checking doctors availability
			throw new DoctorNotFoundException("No doctor found with this Degeree and Specialty");// throw exception when
																									// doctor is not
																									// available with
																									// this specialty
																									// and degree
		}
		return doctorBySpecialityAndDegree; // return list of doctors of with specialty and degree
	}

	@Override
	public List<Specialisation> getDoctorByFeeAndDegreeCountry(double fee, String country)
			throws DoctorNotFoundException { // getting doctors by fee and degree of country
		List<Specialisation> doctorByFeeAndDegreeCountry = specialRepository.findDoctorByFeeAndDegreeCountry(fee,
				country);
		if (doctorByFeeAndDegreeCountry.isEmpty()) {
			throw new DoctorNotFoundException("No doctor found with this fee and country Degree");
		} // if doctors not found throwing exception
		return doctorByFeeAndDegreeCountry; // return list of doctors with fee
	}

}

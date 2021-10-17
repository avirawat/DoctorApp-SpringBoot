package com.doctor.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.doctor.exceptions.DoctorNotFoundException;
import com.doctor.model.Specialisation;

@Service
public interface ISpecialisationService {

	List<Specialisation> getDoctorByDegree(String degree) throws DoctorNotFoundException;

	List<Specialisation> getDoctorBySpecialityAndDegree(String speciality, String degree)
			throws DoctorNotFoundException;

	List<Specialisation> getDoctorByFeeAndDegreeCountry(double fee, String country) throws DoctorNotFoundException;
}

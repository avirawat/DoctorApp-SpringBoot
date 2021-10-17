package com.doctor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctor.exceptions.HospitalNotFoundException;
import com.doctor.model.Hospital;
import com.doctor.repository.HospitalRepository;

@Service
public class HospitalServiceImpl implements IHospitalService {

	@Autowired
	HospitalRepository hospitalRepository; // Object of hospital-repository Automatic dependency Injection

	public List<Hospital> getAllHospitals() { // get All hospitals
		return hospitalRepository.findAll();
	}

	@Override
	public Hospital getById(int hospitalId) throws HospitalNotFoundException { // get hospital By hospital Id
		return hospitalRepository.findById(hospitalId)
				.orElseThrow(() -> new HospitalNotFoundException("Hospital Id not Found"));
	} // If Id not found then throw Exception

	@Override
	public Hospital getByName(String name) throws HospitalNotFoundException { // function for Getting hospital By Name
		Hospital hospitalByName = hospitalRepository.findByHname(name);
		if (hospitalByName == null) {
			throw new HospitalNotFoundException("Hospital not found by This Name"); // throwing Exception if Not found
		}
		return hospitalByName; // Hospital with details
	}

	@Override
	public List<Hospital> getByRating(double rating) throws HospitalNotFoundException { // function for hospital by
																						// Rating
		List<Hospital> hospitalByRating = hospitalRepository.findByRating(rating);
		if (hospitalByRating.isEmpty()) {
			throw new HospitalNotFoundException("Hospital not found by This Rating");
		}
		return hospitalByRating; // list of hospitals within rating
	}

	@Override
	public List<Hospital> getBySpeciality(String speciality) throws HospitalNotFoundException { // get Hospital By
																								// specialty
		List<Hospital> hospitalBySpeciality = hospitalRepository.findBySpeciality(speciality);
		if (hospitalBySpeciality.isEmpty()) {
			throw new HospitalNotFoundException("Hospital not found by This Speciality"); // throw exception if not
																							// found
		}
		return hospitalBySpeciality; // list of hospital by specialty
	}

	@Override
	public List<Hospital> getByDoctorName(String name) throws HospitalNotFoundException { // get hospital By Doctor Name
		List<Hospital> hospitalByDoctorName = hospitalRepository.findByDoctorName(name);
		if (hospitalByDoctorName.isEmpty()) {
			throw new HospitalNotFoundException("Hospital not found by This Doctor Name"); // throw exception if
																							// Hospital not found
		}
		return hospitalByDoctorName;// list of hospitals by doctors name
	}

	@Override // get hospital By City and specialty
	public List<Hospital> getByCityAndSpeciality(String city, String speciality) throws HospitalNotFoundException {
		List<Hospital> hospitalByCityAndSpeciality = hospitalRepository.findByCityAndSpeciality(city, speciality);
		if (hospitalByCityAndSpeciality.isEmpty()) {
			throw new HospitalNotFoundException("Hospital not found by This city And Speciality");
		}
		return hospitalByCityAndSpeciality; // List of hospitals with city and specialty
	}

	@Override // getting hospitals by fee and specialty
	public List<Hospital> getByFeeAndSpeciality(double fee, String speciality) throws HospitalNotFoundException {
		List<Hospital> hospitalByFeeAndSpeciality = hospitalRepository.findByFeeAndSpeciality(fee, speciality);
		if (hospitalByFeeAndSpeciality.isEmpty()) {
			throw new HospitalNotFoundException("Hospital not found by This fee And Speciality"); // if hospital not
																									// found throw
																									// exception
		}
		return hospitalByFeeAndSpeciality; // return list of hospital with fee and specialty

	}

	@Override
	public List<Hospital> getByDoctorFee(double fee) throws HospitalNotFoundException { // getting hospitals by doctor
																						// fee
		List<Hospital> hospitalByDoctorFee = hospitalRepository.findByDoctorFee(fee);
		if (hospitalByDoctorFee.isEmpty()) {
			throw new HospitalNotFoundException("Hospital not found by This fee"); // throw exception if no hospitals
																					// comes within this doctor fee
		}
		return hospitalByDoctorFee; // return hospitals list within this doctor fee
	}

}

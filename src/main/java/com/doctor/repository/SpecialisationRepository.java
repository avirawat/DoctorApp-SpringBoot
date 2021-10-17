package com.doctor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.doctor.exceptions.DoctorNotFoundException;
import com.doctor.model.Specialisation;

@Repository
public interface SpecialisationRepository extends JpaRepository<Specialisation, Integer> {

	@Query(value = "select * from Doctor d inner join specialisation s on d.doctor_id=s.spl_id where s.degree=?1", nativeQuery = true)
	List<Specialisation> findDoctorByDegree(String degree) throws DoctorNotFoundException;

	@Query(value = "select * from Doctor d inner join specialisation s on d.doctor_id=s.spl_id where s.sname=?1 and s.degree=?2", nativeQuery = true)
	List<Specialisation> findDoctorBySpecialityAndDegree(String speciality, String degree)
			throws DoctorNotFoundException;

	@Query(value = "select * from Doctor d inner join specialisation s on d.doctor_id=s.spl_id where d.fee<=?1 and s.country=?2", nativeQuery = true)
	List<Specialisation> findDoctorByFeeAndDegreeCountry(double fee, String country) throws DoctorNotFoundException;
}

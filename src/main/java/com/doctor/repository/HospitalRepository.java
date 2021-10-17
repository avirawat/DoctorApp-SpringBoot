package com.doctor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.doctor.exceptions.HospitalNotFoundException;
import com.doctor.model.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

	// Hospital table

	Hospital findByHname(String name) throws HospitalNotFoundException;

	List<Hospital> findByRating(double rating) throws HospitalNotFoundException;

	List<Hospital> findBySpeciality(String speciality) throws HospitalNotFoundException;

	// Hospital And Doctor Table
	@Query("From Hospital h inner join h.doctorList d where d.name=?1")
	List<Hospital> findByDoctorName(String name) throws HospitalNotFoundException;

	@Query("From Hospital h inner join h.doctorList d where d.city=?1 and h.speciality=?2")
	List<Hospital> findByCityAndSpeciality(String city, String speciality) throws HospitalNotFoundException;

	@Query("From Hospital h inner join h.doctorList d where d.fee<=?1 and h.speciality=?2")
	List<Hospital> findByFeeAndSpeciality(double fee, String speciality) throws HospitalNotFoundException;

	@Query("From Hospital h inner join h.doctorList d where d.fee<=?1")
	List<Hospital> findByDoctorFee(double fee) throws HospitalNotFoundException;

}

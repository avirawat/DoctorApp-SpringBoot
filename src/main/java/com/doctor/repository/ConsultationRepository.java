package com.doctor.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.doctor.exceptions.DateTimeNotFoundException;
import com.doctor.exceptions.DoctorNotFoundException;
import com.doctor.exceptions.TimeSlotNotFoundException;
import com.doctor.model.Consultation;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Integer> {

	@Query(value = " select availability from consultation c inner join doctor d on d.doctor_id=c.consultation_id where d.name=?1", nativeQuery = true)
	public String findDoctorsAvailabilityByName(String doctorName) throws DoctorNotFoundException;

	// List Of Doctors with Consultation
	@Query(value = "select * from doctor d inner join consultation c on d.doctor_id=c.consultation_id where c.start_time<=?1 and c.end_time>=?2", nativeQuery = true)
	List<Consultation> findDoctorsAvailabilityByTime(LocalTime sTime, LocalTime eTime) throws DoctorNotFoundException;

	@Query(value = "select * from doctor d inner join consultation c on d.doctor_id=c.consultation_id where c.local_date=?1", nativeQuery = true)
	List<Consultation> findDoctorsAvailabilityByDate(LocalDate date) throws DoctorNotFoundException;

	@Query(value = "select * from doctor d inner join consultation c on d.doctor_id=c.doctor_id where d.name=?1", nativeQuery = true)
	List<Consultation> findAvailabilityTimeSlotByDoctorName(String doctorName) throws TimeSlotNotFoundException;

	@Query(value = "select * from doctor d inner join consultation c on d.doctor_id=c.doctor_id where c.local_date=?1 and c.start_time<=?2 and c.end_time>=?3", nativeQuery = true)
	List<Consultation> findAvailabilityByDateAndTime(LocalDate date, LocalTime sTime, LocalTime eTime)
			throws DateTimeNotFoundException;

	@Query(value = "select * from doctor d inner join consultation c on d.doctor_id=c.doctor_id where d.city=?1", nativeQuery = true)
	List<Consultation> findDoctorsAvailabilityTimeSlotByCity(String city) throws DoctorNotFoundException;

	@Query(value = "select * from doctor d inner join consultation c on d.doctor_id=c.doctor_id where d.fee<=?1", nativeQuery = true)
	List<Consultation> findDoctorsAvailabilityTimeSlotByfee(double fee) throws DoctorNotFoundException;
}

package com.doctor.model;

import java.time.LocalDate;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Consultation {           //Consultation class for Doctor connected By one to many

	@Id
	@GeneratedValue(generator = "cons_id", strategy = GenerationType.AUTO)  //Auto ID Generation
	@SequenceGenerator(name = "cons_id", sequenceName = "cons_seq", initialValue = 100, allocationSize = 1)
	private Integer consultationId;
	private LocalDate localDate;
	@Column(length = 20)
	private String availability;
	private LocalTime startTime;
	private LocalTime endTime;
	@ManyToOne
	@JoinColumn(name = "doctor_id")      //Reducing table by adding one extra column
	@JsonIgnore
	private Doctor doctor;               //Doctor reference variable
	
	//Constructor class 
	public Consultation(LocalDate localDate, String availability, LocalTime startTime, LocalTime endTime) {
		super();
		this.localDate = localDate;
		this.availability = availability;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	//To string methods
	@Override
	public String toString() {
		return "Consultation [localDate=" + localDate + ", availability=" + availability + ", startTime=" + startTime
				+ ", endTime=" + endTime + "]";
	}

}

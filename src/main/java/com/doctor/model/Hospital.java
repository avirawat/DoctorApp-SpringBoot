package com.doctor.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Hospital {    //Hospital class connected with doctor class many to many

	@Id
	@GeneratedValue(generator = "hospital_id", strategy = GenerationType.AUTO) //Auto ID Generation
	@SequenceGenerator(name = "hospital_id", sequenceName = "hospital_seq", initialValue = 100, allocationSize = 1)
	private Integer hospitalId;
	@Column(length = 20)
	private String hname;
	@Column(length = 20)
	private String speciality;
	private double rating;

	@ManyToMany(mappedBy = "hospitalList", fetch = FetchType.EAGER) 
	@JsonIgnore
	private Set<Doctor> doctorList; //set of doctors

	//Constructor class 
	public Hospital(String hname, String speciality, double rating) {
		super();
		this.hname = hname;
		this.speciality = speciality;
		this.rating = rating;
	}

	//To-string methods
	@Override
	public String toString() {
		return "Hospital [Hospital Name=" + hname + ", speciality=" + speciality + ", rating=" + rating + "]";
	}
	
	
}

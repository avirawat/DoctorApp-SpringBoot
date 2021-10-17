package com.doctor.model;

import java.util.HashSet;
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

public class Specialisation {    //Specialisation class connected with Doctor class many to many

	@Id
	@GeneratedValue(generator = "sp_id", strategy = GenerationType.AUTO) //Auto ID Generation
	@SequenceGenerator(name = "sp_id", sequenceName = "sp_seq", initialValue = 100, allocationSize = 1)

	private Integer splId;
	@Column(length = 20)
	private String sname;
	@Column(length = 20)
	private String degree;
	@Column(length = 20)
	private String country;

	@ManyToMany(mappedBy = "specialityList", fetch = FetchType.EAGER)
	@JsonIgnore
	Set<Doctor> doctorList = new HashSet<>(); //set of doctors
	
	//Constructor class 
	public Specialisation(String sname, String degree, String country) {
		super();
		this.sname = sname;
		this.degree = degree;
		this.country = country;
	}
	// to String methods
	@Override
	public String toString() {
		return "Specialisation [name=" + sname + ", degree=" + degree + ", country=" + country + "]";
	}

}

package com.doctor.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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

public class Doctor {  //Doctor class connected with speciality and Hospital with Many to many

	@Id
	@GeneratedValue(generator = "doctor_id", strategy = GenerationType.AUTO) //Auto ID Generation
	@SequenceGenerator(name = "doctor_id", sequenceName = "doctor_seq", initialValue = 100, allocationSize = 1)
	private Integer doctorId;

	@Column(length = 20)
	private String name;

	@Column(length = 20)
	private String city;

	private double rating;
	private Integer experience;
	private double fee;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)        
	@JoinTable(name = "doctor_speciality", joinColumns = @JoinColumn(name = "doctor_id"),
												inverseJoinColumns = @JoinColumn(name = "spl_id")) //Reducing table by Creating one extra table
	@JsonIgnore
	private Set<Specialisation> specialityList;  //Set of speciality

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "doctor_hospital", joinColumns = @JoinColumn(name = "doctor_id"), 
											inverseJoinColumns = @JoinColumn(name = "hospital_id"))//Reducing table by Creating one extra table
	@JsonIgnore
	private Set<Hospital> hospitalList;          //Set of hospitals

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "doctor_id")			     //Reducing table by Creating one extra column
	@JsonIgnore
	private Set<Consultation> consultancyList;   //Set Of consultancy
	
	//Constructor class 
	public Doctor(String name, String city, double rating, Integer experience, double fee,
			Set<Specialisation> specialityList, Set<Hospital> hospitalList, Set<Consultation> consultancyList) {
		super();
		this.name = name;
		this.city = city;
		this.rating = rating;
		this.experience = experience;
		this.fee = fee;
		this.specialityList = specialityList;
		this.hospitalList = hospitalList;
		this.consultancyList = consultancyList;
	}
	//to string method
	@Override
	public String toString() {
		return "Doctor [Doctor Name=" + name + ", city=" + city + ", rating=" + rating + ", experience=" + experience
				+ ", fee=" + fee + ", specialityList=" + specialityList + ", hospitalList=" + hospitalList
				+ ", consultancyList=" + consultancyList + "]";
	}

}

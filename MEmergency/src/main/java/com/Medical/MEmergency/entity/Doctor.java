package com.Medical.MEmergency.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Doctor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    private String speciality;
    
    private String contactNumber;
    
    @OneToMany(mappedBy = "doctor")
    private Set<HospitalDoctor> hospitalDoctors;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Set<HospitalDoctor> getHospitalDoctors() {
		return hospitalDoctors;
	}

	public void setHospitalDoctors(Set<HospitalDoctor> hospitalDoctors) {
		this.hospitalDoctors = hospitalDoctors;
	}

	public void setHospital(Hospital hospital) {
		// TODO Auto-generated method stub
		
	}
   
    
}
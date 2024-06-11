package com.Medical.MEmergency.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Hospital {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    private String address;
    
    private double latitude;
    
    private double longitude;
    
    private String contactNumber;
    
    private String username;
    
    private String password;
    
    @OneToMany(mappedBy = "hospital")
    private Set<HospitalDisease> hospitalDiseases;
    
    @OneToMany(mappedBy = "hospital")
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<HospitalDisease> getHospitalDiseases() {
		return hospitalDiseases;
	}

	public void setHospitalDiseases(Set<HospitalDisease> hospitalDiseases) {
		this.hospitalDiseases = hospitalDiseases;
	}

	public Set<HospitalDoctor> getHospitalDoctors() {
		return hospitalDoctors;
	}

	public void setHospitalDoctors(Set<HospitalDoctor> hospitalDoctors) {
		this.hospitalDoctors = hospitalDoctors;
	}
    
    
}
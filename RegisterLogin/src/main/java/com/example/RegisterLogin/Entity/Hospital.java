package com.example.RegisterLogin.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "hospitals")
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hospital_id")
    private Long hospitalId;

    
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "contact_number", nullable = false)
    private String contactNumber;

    @Column(name = "latitude", nullable = false, precision = 9, scale = 6)
    private Double latitude;

    @Column(name = "longitude", nullable = false, precision = 9, scale = 6)
    private Double longitude;

	
    
    public Hospital(Long hospitalId, String name, String address, String contactNumber, Double latitude,
			Double longitude) {
		super();
		this.hospitalId = hospitalId;
		this.name = name;
		this.address = address;
		this.contactNumber = contactNumber;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Hospital() {
		super();
	}

	public Long getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Long hospitalId) {
		this.hospitalId = hospitalId;
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

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "Hospital [hospitalId=" + hospitalId + ", name=" + name + ", address=" + address + ", contactNumber="
				+ contactNumber + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}

   
}
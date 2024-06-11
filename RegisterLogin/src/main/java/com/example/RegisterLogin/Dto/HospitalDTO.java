package com.example.RegisterLogin.Dto;

import jakarta.persistence.Column;


public class HospitalDTO {
	
	
	 private Long hospitalId;

	    private String name;

	    private String address;

	    private String contactNumber;

	    private Double latitude;

	    private Double longitude;

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

		public HospitalDTO(Long hospitalId, String name, String address, String contactNumber, Double latitude,
				Double longitude) {
			super();
			this.hospitalId = hospitalId;
			this.name = name;
			this.address = address;
			this.contactNumber = contactNumber;
			this.latitude = latitude;
			this.longitude = longitude;
		}

		public HospitalDTO() {
			super();
		}

		@Override
		public String toString() {
			return "HospitalDTO [hospitalId=" + hospitalId + ", name=" + name + ", address=" + address
					+ ", contactNumber=" + contactNumber + ", latitude=" + latitude + ", longitude=" + longitude + "]";
		}

		
	    
	    
}

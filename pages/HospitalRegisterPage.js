import React, { useState } from 'react';
import AuthService from '../services/AuthService';

const HospitalRegisterPage = () => {
    const [hospital, setHospital] = useState({
        name: '', address: '', contactNumber: '', latitude: '', longitude: '', username: '', password: ''
    });

    const handleChange = (e) => {
        setHospital({ ...hospital, [e.target.name]: e.target.value });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        AuthService.register(hospital).then(response => {
            alert('Hospital registered successfully');
        }).catch(error => {
            console.error('There was an error!', error);
        });
    };

    return (
        <div>
            <h2>Register Hospital</h2>
            <form onSubmit={handleSubmit}>
                <input name="name" placeholder="Name" onChange={handleChange} required /><br />
                <input name="address" placeholder="Address" onChange={handleChange} required /><br />
                <input name="contactNumber" placeholder="Contact Number" onChange={handleChange} required /><br />
                <input name="latitude" placeholder="Latitude" onChange={handleChange} required /><br />
                <input name="longitude" placeholder="Longitude" onChange={handleChange} required /><br />
                <input name="username" placeholder="Username" onChange={handleChange} required /><br />
                <input name="password" type="password" placeholder="Password" onChange={handleChange} required /><br />
                <button type="submit">Register</button>
            </form>
        </div>
    );
};

export default HospitalRegisterPage;

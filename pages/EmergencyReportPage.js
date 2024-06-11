import React, { useState, useEffect } from 'react';
import EmergencyService from '../services/EmergencyService';
import HospitalService from '../services/HospitalService';
import GoogleMapComponent from '../components/GoogleMapComponent';

const EmergencyReportPage = () => {
    const [report, setReport] = useState({ phoneNumber: '', diseaseType: '' });
    const [hospitals, setHospitals] = useState([]);

    const handleChange = (e) => {
        setReport({ ...report, [e.target.name]: e.target.value });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        EmergencyService.submitReport(report).then(response => {
            alert('Emergency reported successfully');
            fetchHospitals();
        }).catch(error => {
            console.error('There was an error!', error);
        });
    };

    const fetchHospitals = () => {
        HospitalService.getAllHospitals().then(response => {
            setHospitals(response.data);
        }).catch(error => {
            console.error('There was an error!', error);
        });
    };

    useEffect(() => {
        fetchHospitals();
    }, []);

    return (
        <div>
            <h2>Report Emergency</h2>
            <form onSubmit={handleSubmit}>
                <input name="phoneNumber" placeholder="Phone Number" onChange={handleChange} required /><br />
                <input name="diseaseType" placeholder="Disease Type" onChange={handleChange} required /><br />
                <button type="submit">Submit Report</button>
            </form>

            <h2>Nearby Hospitals</h2>
            <GoogleMapComponent hospitals={hospitals} />
        </div>
    );
};

export default EmergencyReportPage;

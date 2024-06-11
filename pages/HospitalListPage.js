import React, { useEffect, useState } from 'react';
import HospitalService from '../services/HospitalService';

const HospitalListPage = () => {
    const [hospitals, setHospitals] = useState([]);

    useEffect(() => {
        HospitalService.getAllHospitals().then(response => {
            setHospitals(response.data);
        });
    }, []);

    return (
        <div>
            <h2>Hospitals</h2>
            <ul>
                {hospitals.map(hospital => (
                    <li key={hospital.id}>{hospital.name}</li>
                ))}
            </ul>
        </div>
    );
};

export default HospitalListPage;

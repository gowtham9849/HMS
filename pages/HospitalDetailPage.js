import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import HospitalService from '../services/HospitalService';

const HospitalDetailPage = () => {
    const { id } = useParams();
    const [hospital, setHospital] = useState(null);

    useEffect(() => {
        HospitalService.getHospitalById(id).then(response => {
            setHospital(response.data);
        });
    }, [id]);

    if (!hospital) return <div>Loading...</div>;

    return (
        <div>
            <h2>{hospital.name}</h2>
            <p>Address: {hospital.address}</p>
            <p>Contact: {hospital.contactNumber}</p>
        </div>
    );
};

export default HospitalDetailPage;

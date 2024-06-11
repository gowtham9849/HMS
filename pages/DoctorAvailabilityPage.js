import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import DoctorService from '../services/DoctorService';

const DoctorAvailabilityPage = () => {
    const { hospitalId } = useParams();
    const [availability, setAvailability] = useState([]);

    useEffect(() => {
        DoctorService.getDoctorAvailabilityByHospital(hospitalId).then(response => {
            setAvailability(response.data);
        });
    }, [hospitalId]);

    return (
        <div>
            <h2>Doctor Availability</h2>
            <ul>
                {availability.map(availability => (
                    <li key={availability.id}>{availability.doctorName}: {availability.availability}</li>
                ))}
            </ul>
        </div>
    );
};

export default DoctorAvailabilityPage;

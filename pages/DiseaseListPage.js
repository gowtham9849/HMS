import React, { useEffect, useState } from 'react';
import DiseaseService from '../services/DiseaseService';

const DiseaseListPage = () => {
    const [diseases, setDiseases] = useState([]);

    useEffect(() => {
        DiseaseService.getAllDiseases().then(response => {
            setDiseases(response.data);
        });
    }, []);

    return (
        <div>
            <h2>Diseases</h2>
            <ul>
                {diseases.map(disease => (
                    <li key={disease.id}>{disease.name}</li>
                ))}
            </ul>
        </div>
    );
};

export default DiseaseListPage;

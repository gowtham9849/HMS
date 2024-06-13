import React, { useState, useEffect } from 'react';
import './dashboard.css';

const Dashboard = () => {
  const [emergencies, setEmergencies] = useState([]);

  const fetchEmergencies = async () => {
    try {
      const response = await fetch('api/emergencies');
      const data = await response.json();
      setEmergencies(data);
    } catch (error) {
      console.error('Error fetching emergencies:', error);
    }
  };

  useEffect(() => {
    fetchEmergencies();
  }, []);

  return (
    <div>dashboard dsvkfgjkdsjkhfdjkhds
      sd;;fhklhsdldhfklshsklh
      <div>
        {/* Display emergency data */}
        {emergencies.map((emergency) => (
          <div key={emergency.id}>
            <h2>{emergency.title}</h2>
            <p>{emergency.description}</p>
            <p>Location: {emergency.location}</p>
            {/* Additional emergency details */}
            <p>Status: {emergency.status}</p>
            <p>Severity: {emergency.severity}</p>
            {/* Add more details as needed */}
          </div>
        ))}
      </div>
    </div>
  );
};

export default Dashboard;

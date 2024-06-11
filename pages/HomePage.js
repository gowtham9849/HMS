import React from 'react';
import { Link } from 'react-router-dom';

const HomePage = () => {
    return (
        <div>
            <h1>Welcome to the Hospital Emergency Application</h1>
            <Link to="/register">Register as Hospital</Link> | 
            <Link to="/login">Login as Hospital</Link> | 
            <Link to="/emergency-report">Report Emergency</Link>
        </div>
    );
};

export default HomePage;


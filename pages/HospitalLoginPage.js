import React, { useState } from 'react';
import AuthService from '../services/AuthService';

const HospitalLoginPage = () => {
    const [credentials, setCredentials] = useState({ username: '', password: '' });

    const handleChange = (e) => {
        setCredentials({ ...credentials, [e.target.name]: e.target.value });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        AuthService.login(credentials).then(response => {
            alert('Login successful');
        }).catch(error => {
            console.error('There was an error!', error);
        });
    };

    return (
        <div>
            <h2>Login as Hospital</h2>
            <form onSubmit={handleSubmit}>
                <input name="username" placeholder="Username" onChange={handleChange} required /><br />
                <input name="password" type="password" placeholder="Password" onChange={handleChange} required /><br />
                <button type="submit">Login</button>
            </form>
        </div>
    );
};

export default HospitalLoginPage;

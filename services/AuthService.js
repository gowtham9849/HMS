import axios from 'axios';

const API_URL = 'http://localhost:8080/api/hospitals';

class AuthService {
    register(hospital) {
        return axios.post(API_URL + '/register', hospital);
    }

    login(credentials) {
        return axios.post(API_URL + '/login', credentials);
    }
}

export default new AuthService();

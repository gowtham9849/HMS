import axios from 'axios';

const API_URL = 'http://localhost:8080/api/hospitals';

class HospitalService {
    getAllHospitals() {
        return axios.get(API_URL);
    }

    getHospitalById(id) {
        return axios.get(API_URL + '/' + id);
    }
}

export default new HospitalService();

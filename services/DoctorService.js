import axios from 'axios';

const API_URL = 'http://localhost:8080/api/doctor-availability';

class DoctorService {
    getDoctorAvailabilityByHospital(hospitalId) {
        return axios.get(API_URL + '/' + hospitalId);
    }
}

export default new DoctorService();
